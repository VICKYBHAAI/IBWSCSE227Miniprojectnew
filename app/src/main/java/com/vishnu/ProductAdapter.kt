package com.vishnu

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.ibwscse227miniproject.R
import com.vishnu.ibwscse227miniproject.databinding.ItemProductBinding
import com.vishnu.ui.cart.CartViewModel

class ProductAdapter(
    private val cartViewModel: CartViewModel
) : ListAdapter<ProductItem, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ProductViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductItem) {
            with(binding) {
                tvProductName.text = item.name
                tvProductPrice.text = itemView.context.getString(R.string.price_format, item.price)

                // Handle nullable imageRes with a default placeholder
                item.imageRes?.let { resId ->
                    ivProduct.setImageResource(resId)
                } ?: run {
                    ivProduct.setImageResource(R.drawable.ic_placeholder)
                }

                btnAddToCart.setOnClickListener {
                    cartViewModel.addToCart(item)
                    Toast.makeText(
                        itemView.context,
                        itemView.context.getString(R.string.item_added_to_cart, item.name),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<ProductItem>() {
    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem == newItem
    }
}