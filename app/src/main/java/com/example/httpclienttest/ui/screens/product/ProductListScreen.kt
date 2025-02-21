package com.example.httpclienttest.ui.screens.product

import ProductItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.httpclienttest.ui.components.navigation.Destinations

@Composable
fun ProductListScreen(
    navController: NavController,
    productListViewModel: ProductListViewModel = hiltViewModel()
) {

    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        productListViewModel.getProducts()
        isLoading = false
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(productListViewModel.products) { product ->
                ProductItem(
                    product = product,
                    onClick = {
                        navController.navigate("${Destinations.TU_VISTAPRODUCTOS_URL}/${product.id}")
                    }
                )
            }
        }
    }
}