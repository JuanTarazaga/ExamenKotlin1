package com.example.httpclienttest.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val FAKESTORE_URL = "https://fakestoreapi.com"
    private const val JSONPLACEHOLDER_URL = "https://jsonplaceholder.typicode.com"

    val jsonplaceholder: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(JSONPLACEHOLDER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    val fakestore: FakeStoreService by lazy{
        Retrofit.Builder()
            .baseUrl(FAKESTORE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeStoreService::class.java)
    }

}