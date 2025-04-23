package com.vishnu.ui.cart

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.vishnu.CartAdapter
import com.vishnu.ibwscse227miniproject.databinding.FragmentCartBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import org.json.JSONObject

class CartFragment : Fragment(), PaymentResultListener {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val cartViewModel: CartViewModel by activityViewModels()
    private lateinit var cartAdapter: CartAdapter
    private var currentOrderTotal = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Checkout.preload(requireActivity().application)
        setupCartRecyclerView()
        setupObservers()
        setupButtons()
    }

    private fun setupCartRecyclerView() {
        cartAdapter = CartAdapter(
            onRemoveClick = { product ->
                cartViewModel.removeFromCart(product)
                Toast.makeText(context, "${product.name} removed", Toast.LENGTH_SHORT).show()
            },
            onQuantityChange = { product, newQuantity ->
                cartViewModel.updateQuantity(product, newQuantity)
            }
        )
        binding.cartRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cartAdapter
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                cartViewModel.cartItems.collect { items ->
                    cartAdapter.submitList(items)
                    val isEmpty = items.isEmpty()
                    binding.emptyCartView.visibility = if (isEmpty) View.VISIBLE else View.GONE
                    binding.btnPlaceOrder.visibility = if (isEmpty) View.GONE else View.VISIBLE
                    updateTotalPrice()
                }
            }
        }
    }

    private fun updateTotalPrice() {
        currentOrderTotal = cartViewModel.cartItems.value.sumOf { it.price * it.quantity }
        binding.tvTotalPrice.text = "₹${"%.2f".format(currentOrderTotal)}"
    }

    private fun setupButtons() {
        binding.btnPlaceOrder.setOnClickListener {
            if (cartViewModel.cartItems.value.isNotEmpty()) {
                startRazorpayPayment()

            } else {
                Toast.makeText(context, "Cart is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startRazorpayPayment() {
        try {
            val checkout = Checkout()
            checkout.setKeyID("rzp_test_u8RDFDdSlURosQ")

            val options = JSONObject().apply {
                put("name", "Your App Name")
                put("description", "Order Payment")
                put("image", "https://your-logo-url.png")
                put("theme.color", "#FF5722")
                put("currency", "INR")
                put("amount", (currentOrderTotal * 100).toInt())
                put("prefill", JSONObject().apply {
                    put("email", "customer@example.com")
                    put("contact", "9876543210")
                })
            }

            checkout.open(requireActivity(), options)
        } catch (e: Exception) {
            Toast.makeText(context, "Error in payment: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPaymentSuccess(razorpayPaymentId: String?) {
        razorpayPaymentId?.let { paymentId ->
            binding.btnPlaceOrder.isEnabled = false
            binding.progressBar.visibility = View.VISIBLE

            viewLifecycleOwner.lifecycleScope.launch {
                val success = try {
                    cartViewModel.moveCartToOrders(paymentId, currentOrderTotal)
                } catch (e: Exception) {
                    false
                }

                if (success) {
                    Toast.makeText(
                        context,
                        "Order placed successfully!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    showRetryDialog(paymentId)
                }

                binding.btnPlaceOrder.isEnabled = true
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun showRetryDialog(paymentId: String) {
        AlertDialog.Builder(requireContext())
            .setTitle("Order Failed")
            .setMessage("Something went wrong. Please try again.")
            .setPositiveButton("Retry") { dialog, _ ->
                dialog.dismiss()
                startRazorpayPayment() // Restart payment process
            }
            .setNegativeButton("Go Back") { dialog, _ ->
                dialog.dismiss()
                // Optional: Handle navigation back
            }
            .setCancelable(false)
            .show()
    }

    override fun onPaymentError(code: Int, message: String?) {
        Toast.makeText(
            context,
            "Payment Failed: ${message ?: "Error code $code"}",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    private suspend fun moveCartToOrders(orderId: String): Boolean {
//        return try {
//            val cartItems = cartViewModel.cartItems.value
//            val orderData = hashMapOf(
//                "orderId" to orderId,
//                "timestamp" to System.currentTimeMillis(),
//                "totalAmount" to currentOrderTotal,
//                "items" to cartItems.map { item ->
//                    hashMapOf(
//                        "productId" to item.id,
//                        "name" to item.name,
//                        "price" to item.price,
//                        "quantity" to item.quantity,
//                        "imageUrl" to item.imageUrl
//                    )
//                },
//                "status" to "completed"
//            )
//
//            Firebase.database.reference
//                .child("placedOrders")
//                .child(orderId)
//                .setValue(orderData)
//                .await()
//
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
}