package com.example.myapplication.data

data class Deal(
    val unique: String,
    val title: String,
    val image: String,
    val sold_label: String,
    val company: String,
    val city: String,
    val prices: Prices
)
