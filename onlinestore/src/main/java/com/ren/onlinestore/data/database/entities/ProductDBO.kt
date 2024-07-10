package com.ren.onlinestore.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ren.onlinestore.models.Category
import com.ren.onlinestore.models.Product

@Entity(tableName = "product")
data class ProductDBO(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val image: String,
    val price: Int,
    val firm: String
)

fun ProductDBO.toProduct() = Product(
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
    firm = firm,
    inBasket = false
)