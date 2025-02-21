package com.example.httpclienttest.data.repositories

import com.example.httpclienttest.data.model.User
import com.example.httpclienttest.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {

    suspend fun fetchUsers(): List<User>? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.jsonplaceholder.getUsers().execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }
}