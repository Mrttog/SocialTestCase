package com.example.myapplication.api.models

import com.example.myapplication.data.Prices

data class DealResponse (
    val unique: String,
    val title: String,
    val company: String,
    val description: String,
    val city: String,
    val sold_label: String,
    val prices: Prices
)