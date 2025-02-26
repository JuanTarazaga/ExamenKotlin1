package com.example.httpclienttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.httpclienttest.ui.components.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.httpclienttest.ui.components.navigation.Destinations
import com.example.httpclienttest.ui.components.navigation.getBottomBarForRoute
import com.example.httpclienttest.ui.screens.user.UserListViewModel
import com.example.httpclienttest.ui.theme.HttpClientTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val userListViewModel: UserListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HttpClientTestTheme {
                Surface {
                    App1()
                }

            }
        }
    }
}

@Composable
fun App1(){
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val showFAB = remember { mutableStateOf(true) }

    // Lista de destinos donde el FAB debe desaparecer
    val hideFABDestinations = listOf(
        Destinations.TUS_USERS_URL
    )

    LaunchedEffect(currentRoute) {
        showFAB.value = currentRoute !in hideFABDestinations
    }

    Scaffold (modifier = Modifier.fillMaxSize(),
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavGraph(navController)
            }
        },
        bottomBar = {
            // Llama a la función que devuelve el BottomBar correspondiente
            val bottomBarContent = getBottomBarForRoute(currentRoute, navController)
            bottomBarContent?.invoke() // Muestra el BottomBar si no es nulo
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewApp() {
}