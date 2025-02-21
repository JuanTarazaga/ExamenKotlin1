package com.example.httpclienttest.ui.screens.product

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.httpclienttest.data.model.Product
import com.example.httpclienttest.data.repositories.ProductReposoitory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productReposoitory: ProductReposoitory
) : ViewModel() {
    var products by mutableStateOf(listOf<Product>())
        private set

    fun replaceProducts(products: List<Product>) {
        this.products = products
    }

    suspend fun getProducts(): List<Product> {
        var result = productReposoitory.getProducts()
        if (result != null) {
            this.products = result
        }
        return this.products
    }
}