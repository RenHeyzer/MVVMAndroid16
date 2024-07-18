package com.ren.onlinestore.data.network.api

import com.ren.onlinestore.data.network.models.ProductDTO
import retrofit2.Call
import retrofit2.http.GET

private const val END_POINT = "products"

interface ProductApiService {

    @GET(END_POINT)
    fun getAllProducts(): Call<List<ProductDTO>>
}