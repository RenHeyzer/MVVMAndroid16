package com.ren.onlinestore.models

import com.ren.onlinestore.utils.Result

interface ProductRepository {

    fun getProducts(
        onResult: (result: Result<List<Product>>) -> Unit,
    )
}