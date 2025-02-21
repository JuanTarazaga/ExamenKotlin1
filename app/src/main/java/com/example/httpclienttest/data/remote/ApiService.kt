package com.example.httpclienttest.data.remote

import com.example.httpclienttest.data.model.LoginRequest
import com.example.httpclienttest.data.model.LoginResponse
import com.example.httpclienttest.data.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}