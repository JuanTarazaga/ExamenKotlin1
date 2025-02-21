package com.example.httpclienttest.data.repositories

import com.example.httpclienttest.data.model.LoginRequest
import com.example.httpclienttest.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository {
    // Método para realizar login y obtener el token
    suspend fun login(email: String, password: String): String? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.fakestore.login(LoginRequest(email, password)).execute()
            if (response.isSuccessful) {
                response.body()?.token
            } else {
                null
            }
        }
    }
}