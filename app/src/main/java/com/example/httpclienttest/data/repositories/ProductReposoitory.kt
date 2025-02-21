package com.example.httpclienttest.data.repositories

import com.example.httpclienttest.data.model.Product
import com.example.httpclienttest.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ProductReposoitory {

    suspend fun getProducts(): List<Product>? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.fakestore.getProducts().execute()
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }

    suspend fun getProduct(id: Int): Product? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.fakestore.getProduct(id).execute()
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }

    suspend fun postProduct(product: Product): Product? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.fakestore.postProduct(product).execute()
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }

    suspend fun putProduct (product: Product): Product? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.fakestore.putProduct(product.id, product).execute()
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }

    suspend fun deleteProduct(id: Int): Product? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.fakestore.deleteProduct(id).execute()
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }
}