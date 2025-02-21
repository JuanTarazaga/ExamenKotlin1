package com.example.httpclienttest.ui.screens.DescripcionProducto

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.httpclienttest.data.model.Product
import com.example.httpclienttest.data.repositories.ProductReposoitory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DescripcionProductoViewModel @Inject constructor(
    private val productReposoitory: ProductReposoitory
) : ViewModel() {
    var products by mutableStateOf<Product?>(null)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    suspend fun getProduct(id: Int) {
        val result = productReposoitory.getProduct(id = id)
        if (result != null) {
            this.products = result
            this.errorMessage = null
        } else {
            this.errorMessage = "Producto no encontrado"
        }
    }
}