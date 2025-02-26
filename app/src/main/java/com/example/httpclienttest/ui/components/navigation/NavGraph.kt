package com.example.httpclienttest.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.httpclienttest.ui.screens.user.UserListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.TUS_USERS_URL // Pantalla inicial
    ) {
        composable(Destinations.TUS_USERS_URL) {
            UserListScreen()
        }
    }
}


