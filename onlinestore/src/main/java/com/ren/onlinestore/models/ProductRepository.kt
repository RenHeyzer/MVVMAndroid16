package com.ren.onlinestore.models

import androidx.lifecycle.LiveData

interface ProductRepository {

    fun getProducts(): LiveData<List<Product>>
}