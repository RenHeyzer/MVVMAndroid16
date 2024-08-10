package com.ren.onlinestore.data.repositories

import com.ren.onlinestore.models.Product
import com.ren.onlinestore.utils.Result

interface ProductRepository {

    fun getProducts(
        onResult: (result: Result<List<Product>>) -> Unit,
    )
}