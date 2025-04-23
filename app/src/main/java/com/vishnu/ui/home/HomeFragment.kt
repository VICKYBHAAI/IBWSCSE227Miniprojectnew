package com.vishnu.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishnu.ProductAdapter
import com.vishnu.ProductItem
import com.vishnu.ProductListProvider
import com.vishnu.ibwscse227miniproject.databinding.FragmentHomeBinding
import com.vishnu.ui.cart.CartViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter
    private lateinit var trendingAdapter: ProductAdapter
    private val allProducts = ProductListProvider.getAllProducts()
    private val trendingProducts = getTrendingProducts()
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapters()
        setupSearchBar()
        setupRecyclerViews()
    }

    private fun setupAdapters() {
        productAdapter = ProductAdapter(cartViewModel)
        trendingAdapter = ProductAdapter(cartViewModel)
    }

    private fun setupSearchBar() {
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                filterProducts(s?.toString()?.trim() ?: "")
            }
        })
    }

    private fun filterProducts(query: String) {
        val filteredList = if (query.isEmpty()) {
            allProducts
        } else {
            allProducts.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
        productAdapter.submitList(filteredList)
    }

    private fun setupRecyclerViews() {
        // Trending products (horizontal)
        binding.trendingRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = trendingAdapter
            trendingAdapter.submitList(trendingProducts)
        }

        // All products (grid)
        binding.productsRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = productAdapter
            productAdapter.submitList(allProducts)
        }
    }

    private fun getTrendingProducts(): List<ProductItem> {
        return listOf(
            allProducts[0], allProducts[4], allProducts[10],
            allProducts[15], allProducts[20], allProducts[25]
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}