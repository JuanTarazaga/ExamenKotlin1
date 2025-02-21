package com.example.httpclienttest.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.httpclienttest.ui.components.FakeStore.BottomBar
import com.example.httpclienttest.ui.screens.DescripcionProducto.DescripcionProductoScreen
import com.example.httpclienttest.ui.screens.product.ProductListScreen
import com.example.httpclienttest.ui.screens.user.UserListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.TUS_PRODUCTOS_URL // Pantalla inicial
    ) {
        composable(Destinations.TUS_PRODUCTOS_URL) {
            ProductListScreen(navController = navController)
        }
        composable(Destinations.TUS_USERS_URL) {
            UserListScreen()
        }
        composable(
            route = "${Destinations.TU_VISTAPRODUCTOS_URL}/{productId}",
            arguments = listOf(
                navArgument("productId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            DescripcionProductoScreen(productId = productId)
        }
    }
}


