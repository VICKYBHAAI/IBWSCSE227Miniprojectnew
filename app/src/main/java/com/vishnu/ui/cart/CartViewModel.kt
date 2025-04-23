package com.vishnu.ui.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.vishnu.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.tasks.await
import java.util.*

class CartViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()
    private val cartRef = database.getReference("carts")
    private val ordersRef = database.getReference("orders")

    private val _cartItems = MutableStateFlow<List<ProductItem>>(emptyList())
    val cartItems: StateFlow<List<ProductItem>> = _cartItems

    private val _totalPrice = MutableStateFlow(0.0)
    val totalPrice = _totalPrice.asLiveData()

    init {
        loadCartItems()
    }

    fun addToCart(product: ProductItem) {
        val userId = auth.currentUser?.uid ?: return
        val userCartRef = cartRef.child(userId)

        userCartRef.child(product.id).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val currentQuantity = snapshot.child("quantity").getValue(Int::class.java) ?: 0
                updateQuantity(product.copy(quantity = currentQuantity), currentQuantity + 1)
            } else {
                val cartItem = product.copy(quantity = 1)
                userCartRef.child(product.id).setValue(cartItem.toFirebaseMap())
                    .addOnSuccessListener {
                        _cartItems.update { it + cartItem }
                    }
                    .addOnFailureListener { e ->
                        Log.e("CartVM", "Failed to add item", e)
                    }
            }
        }.addOnFailureListener { e ->
            Log.e("CartVM", "Failed to check cart", e)
        }
    }

    fun updateQuantity(product: ProductItem, newQuantity: Int) {
        val userId = auth.currentUser?.uid ?: return

        _cartItems.update { currentItems ->
            currentItems.map {
                if (it.id == product.id) it.copy(quantity = newQuantity) else it
            }
        }
        calculateTotalPrice()

        cartRef.child(userId).child(product.id).child("quantity")
            .setValue(newQuantity)
            .addOnFailureListener { e ->
                Log.e("CartVM", "Update failed", e)
                _cartItems.update { currentItems ->
                    currentItems.map {
                        if (it.id == product.id) product else it
                    }
                }
            }
    }

    private fun loadCartItems() {
        val userId = auth.currentUser?.uid ?: return

        cartRef.child(userId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<ProductItem>()
                for (childSnapshot in snapshot.children) {
                    try {
                        val product = childSnapshot.getValue(ProductItem::class.java)
                        product?.let { items.add(it) }
                    } catch (e: Exception) {
                        Log.e("CartVM", "Parse error", e)
                    }
                }
                _cartItems.value = items
                calculateTotalPrice()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("CartVM", "Database error", error.toException())
            }
        })
    }

    private fun calculateTotalPrice() {
        _totalPrice.value = _cartItems.value.sumOf { it.price * it.quantity }
    }

    fun removeFromCart(product: ProductItem) {
        val userId = auth.currentUser?.uid ?: return
        _cartItems.update { it.filterNot { item -> item.id == product.id } }
        cartRef.child(userId).child(product.id).removeValue()
    }

    fun clearCart() {
        val userId = auth.currentUser?.uid ?: return
        _cartItems.value = emptyList()
        cartRef.child(userId).removeValue()
    }

    suspend fun moveCartToOrders(paymentId: String, totalAmount: Double): Boolean {
        return try {
            // Get current cart items
            val cartItems = cartItems.value

            // Create order data
            val orderData = hashMapOf(
                "orderId" to paymentId,
                "timestamp" to System.currentTimeMillis(),
                "totalAmount" to totalAmount,
                "items" to cartItems.map { item ->
                    hashMapOf(
                        "productId" to item.id,
                        "name" to item.name,
                        "price" to item.price,
                        "quantity" to item.quantity,
                        "imageUrl" to item.imageUrl
                    )
                },
                "status" to "placed"
            )

            // Reference to Firebase database
            val database = Firebase.database.reference

            // Save to placed orders
            database.child("placedOrders").child(paymentId).setValue(orderData).await()

            // Clear the cart after successful order placement
            clearCart()

            true
        } catch (e: Exception) {
            false
        }
    }

}