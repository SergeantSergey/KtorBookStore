package com.learning

data class Book(
    var id: String,
    var title: String,
    var author: String,
    var price: Float
)

data class ShoppingCard(
    var id: String,
    var user: String,
    val items: ArrayList<ShoppingItem>
)

data class ShoppingItem(
    var bookId: String,
    var qty: Int
)

data class User(
    var userId: String,
    var name: String,
    var userName: String,
    var password: String
)
