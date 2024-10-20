package com.example.myapplication.utils

object UtilPrice {
    fun Double.toFormattedPrice() : String {
        val priceWithDecimals = this / 100.0
        return String.format("%.2f", priceWithDecimals)
    }

    fun convertPrice(amountInEuro: Double, isDollar: Boolean, conversionRate: Double = 1.18): Double {
        val convertedAmount = if (isDollar) {
            (amountInEuro * conversionRate)

        } else {
            amountInEuro
        }

        return convertedAmount
    }
}