package com.vishnu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vishnu.ibwscse227miniproject.R
import com.vishnu.ibwscse227miniproject.databinding.ItemCartBinding

class CartAdapter(
    private val onRemoveClick: (ProductItem) -> Unit,
    private val onQuantityChange: (ProductItem, Int) -> Unit
) : ListAdapter<ProductItem, CartAdapter.CartViewHolder>(CartDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CartViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductItem) {
            with(binding) {
                tvProductName.text = item.name
                updateQuantityViews(item.quantity, item.price)

                // Load image
                if (!item.imageUrl.isNullOrEmpty()) {
                    Glide.with(root.context)
                        .load(item.imageUrl)
                        .placeholder(R.drawable.ic_placeholder)
                        .error(R.drawable.ic_error)
                        .into(ivProduct)
                } else {
                    item.imageRes?.let { ivProduct.setImageResource(it) }
                        ?: ivProduct.setImageResource(R.drawable.ic_placeholder)
                }

                // Button click handlers
                btnRemove.setOnClickListener { onRemoveClick(item) }
                btnIncrease.setOnClickListener {
                    onQuantityChange(item, item.quantity + 1)
                }
                btnDecrease.setOnClickListener {
                    if (item.quantity > 1) onQuantityChange(item, item.quantity - 1)
                }
            }
        }

        private fun updateQuantityViews(quantity: Int, price: Double) {
            binding.tvQuantity.text = quantity.toString()
            binding.tvProductPrice.text = "₹${"%.2f".format(price * quantity)}"
        }
    }
}

class CartDiffCallback : DiffUtil.ItemCallback<ProductItem>() {
    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem) =
        oldItem == newItem
}