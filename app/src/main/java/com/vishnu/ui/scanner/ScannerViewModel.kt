package com.vishnu.ui.scanner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.vishnu.ProductItem
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ScannerViewModel : ViewModel() {

    private val database = Firebase.database
    private val productsRef = database.getReference("products")
    private val receivedItemsRef = database.getReference("received_items")

    private val _product = MutableLiveData<ProductItem?>()
    val product: LiveData<ProductItem?> = _product

    private val _addToReceivedStatus = MutableLiveData<Boolean>()
    val addToReceivedStatus: LiveData<Boolean> = _addToReceivedStatus

    fun fetchProductByBarcode(barcode: String) {
        productsRef.orderByChild("barcode").equalTo(barcode)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (productSnapshot in snapshot.children) {
                            val product = productSnapshot.getValue(ProductItem::class.java)
                            _product.value = product
                            return
                        }
                    }
                    _product.value = null
                }

                override fun onCancelled(error: DatabaseError) {
                    _product.value = null
                }
            })
    }

    fun addToReceivedItems(product: ProductItem) {
        viewModelScope.launch {
            try {
                val receivedItemData = hashMapOf(
                    "productId" to product.id,
                    "name" to product.name,
                    "price" to product.price,
                    "quantity" to product.quantity,
                    "imageUrl" to product.imageUrl,
                    "receivedAt" to System.currentTimeMillis()
                )

                receivedItemsRef.push().setValue(receivedItemData).await()
                _addToReceivedStatus.value = true
            } catch (e: Exception) {
                _addToReceivedStatus.value = false
            }
        }
    }
}