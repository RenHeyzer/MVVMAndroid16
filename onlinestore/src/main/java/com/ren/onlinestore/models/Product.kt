package com.ren.onlinestore.models

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: Category,
    val image: String,
    val price: Int,
    val firm: String,
    val inBasket: Boolean = false
)