package com.example.httpclienttest.ui.screens.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.httpclienttest.data.repositories.UserRepository
import com.example.httpclienttest.ui.components.UserItem



@Composable
fun UserListScreen(userListViewModel: UserListViewModel = hiltViewModel()) {
    val userRepository = UserRepository()
    //var users by remember { mutableStateOf<List<User>?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    // Llamar al API al cargar la pantalla
    LaunchedEffect(Unit) {
        userRepository.fetchUsers()?.let { userListViewModel.getUsers(it) }
        isLoading = false
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    } else {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(userListViewModel.users) { user ->
                UserItem(user)
            }
        }

    }
}