package com.ren.onlinestore.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ren.onlinestore.data.database.dao.ProductDao
import com.ren.onlinestore.data.mappers.toProduct
import com.ren.onlinestore.models.Product
import com.ren.onlinestore.models.ProductRepository

class ProductDataRepository(
    private val dao: ProductDao
) : ProductRepository {

    override fun getProducts(): LiveData<List<Product>> {
        return dao.getAllProducts().map { products ->
            products.map {
                it.toProduct()
            }
        }
    }
}