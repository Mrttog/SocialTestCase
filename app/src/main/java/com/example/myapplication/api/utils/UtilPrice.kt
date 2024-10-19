package com.example.myapplication.api.utils

object UtilPrice {
    fun Int.toFormattedPrice() : String {
        val priceWithDecimals = this.toFloat() / 100
        return priceWithDecimals.toString()
    }
}