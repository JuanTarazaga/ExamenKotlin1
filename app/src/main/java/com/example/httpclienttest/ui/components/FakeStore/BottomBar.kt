package com.example.httpclienttest.ui.components.FakeStore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.httpclienttest.R
import com.example.httpclienttest.ui.components.navigation.Destinations

@Composable
fun BottomBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(Color(0xFF020000)) // Azul
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { navController.navigate(Destinations.TUS_PRODUCTOS_URL) },
                    modifier = Modifier.size(50.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.lista1),
                        contentDescription = "productos",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { navController.navigate(Destinations.TUS_USERS_URL) },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.usuario),
                        contentDescription = "usuarios",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
        }


    }
}

@Preview
@Composable
fun PreviewBot() {
    BottomBar(navController = rememberNavController())
}
