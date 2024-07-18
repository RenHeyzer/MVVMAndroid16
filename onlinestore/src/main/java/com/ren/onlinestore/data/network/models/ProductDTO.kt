package com.ren.onlinestore.data.network.models

import com.google.gson.annotations.SerializedName
import com.ren.onlinestore.data.database.entities.ProductDBO
import com.ren.onlinestore.models.Category
import com.ren.onlinestore.models.Product

data class ProductDTO(
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("rating")
    val rating: Rating,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("category")
    val category: String
)

fun ProductDTO.toProduct() = Product(
    id = id,
    title = title,
    description = description,
    category = when (category) {
        "electronics" -> Category.ELECTRONICS
        "jewelery" -> Category.JEWELERY
        "men's clothing" -> Category.MENS_CLOTHING
        else -> Category.WOMENS_CLOTHING
    },
    image = image,
    price = price,
    firm = "",
    inBasket = false
)
