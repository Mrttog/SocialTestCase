package com.example.myapplication.utils

object UtilPrice {
    fun Int.toFormattedPrice() : String {
        val priceWithDecimals = this / 100.0
        return String.format("%.2f", priceWithDecimals)
    }
}