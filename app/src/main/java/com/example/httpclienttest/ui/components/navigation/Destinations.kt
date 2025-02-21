package com.example.httpclienttest.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.httpclienttest.ui.components.FakeStore.BottomBar
import com.example.httpclienttest.ui.components.FakeStore.TopBar

object Destinations {
    const val TUS_PRODUCTOS_URL = "tus-productos"
    const val TUS_USERS_URL = "tus-usuarios"
    const val TU_VISTAPRODUCTOS_URL = "tus-vistaproductos"
}

fun getBottomBarForRoute(route: String?,navController: NavController): @Composable (() -> Unit)? {
    return when (route) {
        Destinations.TUS_PRODUCTOS_URL -> {
            { BottomBar(navController) }
        }

        Destinations.TUS_USERS_URL -> {
            { BottomBar(navController) }
        }

        Destinations.TU_VISTAPRODUCTOS_URL -> {
            { BottomBar(navController) }
        }

        else -> null
    }
}

fun getTopBarForRoute(route: String?, navController: NavController): @Composable (() -> Unit)? {
    return when (route) {
        Destinations.TUS_PRODUCTOS_URL -> {
            { TopBar("FakeStore") }
        }

        Destinations.TUS_USERS_URL  -> {
            { TopBar("FakeStore") }
        }

        Destinations.TU_VISTAPRODUCTOS_URL -> {
            { BottomBar(navController) }
        }

        else -> null // No mostrar `TopBar` para otras rutas si no corresponde
    }
}