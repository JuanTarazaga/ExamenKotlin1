package com.example.httpclienttest.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.httpclienttest.ui.components.BotTop.BottomBar

object Destinations {
    const val TUS_USERS_URL = "tus-usuarios"
}

fun getBottomBarForRoute(route: String?,navController: NavController): @Composable (() -> Unit)? {
    return when (route) {

        Destinations.TUS_USERS_URL -> {
            { BottomBar(navController) }
        }

        else -> null
    }
}