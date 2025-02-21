package com.example.httpclienttest.ui.screens.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.httpclienttest.data.model.User
import com.example.httpclienttest.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val UserRepository: UserRepository
) : ViewModel() {
    var users by mutableStateOf(listOf<User>())
        private set

    fun replaceUsers (users:List<User>){
        this.users = users
    }

    suspend fun getUsers(users: List<User>): List<User> {
        var result = UserRepository.fetchUsers()
        if (result != null) {
            this.users = result
        }
        return this.users
    }
}