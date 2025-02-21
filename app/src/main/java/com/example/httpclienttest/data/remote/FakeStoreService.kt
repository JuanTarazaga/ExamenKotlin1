package com.example.httpclienttest.data.remote

import com.example.httpclienttest.data.model.LoginRequest
import com.example.httpclienttest.data.model.LoginResponse
import com.example.httpclienttest.data.model.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface FakeStoreService {

    @GET("products")
    fun getProducts(): Call<List<Product>>

    @GET("products/{id}")
    fun getProduct(@Path("id") id: Int): Call<Product>

    @POST("products")
    fun postProduct(@Body product: Product): Call<Product>

    @PUT("products/{id}")
    fun putProduct(@Path("id") id: Int, @Body product: Product): Call<Product>

    @DELETE("products/{id}")
    fun deleteProduct(@Path("id") id: Int): Call<Product>

    //Login
    @POST("/auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

}