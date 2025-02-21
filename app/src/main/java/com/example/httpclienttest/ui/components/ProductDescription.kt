package com.example.httpclienttest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.httpclienttest.data.model.Product

@Composable
fun ProductDescription(product: Product) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = product.title,
                style = MaterialTheme.typography.bodyLarge
            )

            Box(modifier = Modifier.padding(16.dp))

            Image(
                painter = rememberAsyncImagePainter(model = product.image),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Text(text = "${product.price}€", style = MaterialTheme.typography.bodyLarge)
        }

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                modifier = Modifier.padding(16.dp),
                text = product.description, style = MaterialTheme.typography.bodyMedium
            )

            Box(modifier = Modifier.padding(16.dp))

            Text(text = product.category, style = MaterialTheme.typography.bodyMedium)


        }
    }
}
