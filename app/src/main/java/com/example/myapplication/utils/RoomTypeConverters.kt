package com.example.myapplication.utils

import androidx.room.TypeConverter
import com.example.myapplication.data.Currency
import com.example.myapplication.data.Price
import com.example.myapplication.data.Prices
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomTypeConverters {
    @TypeConverter
    fun fromPrices(prices: Prices?): String {
        return Gson().toJson(prices)
    }

    @TypeConverter
    fun toPrices(pricesJson: String): Prices {
        return Gson().fromJson(pricesJson, object : TypeToken<Prices>() {}.type)
    }

    @TypeConverter
    fun fromPrice(price: Price?): String {
        return Gson().toJson(price)
    }

    @TypeConverter
    fun toPrice(priceJson: String): Price {
        return Gson().fromJson(priceJson, object : TypeToken<Price>() {}.type)
    }

    @TypeConverter
    fun fromCurrency(currency: Currency?): String {
        return Gson().toJson(currency)
    }

    @TypeConverter
    fun toCurrency(currencyJson: String): Currency {
        return Gson().fromJson(currencyJson, object : TypeToken<Currency>() {}.type)
    }
}