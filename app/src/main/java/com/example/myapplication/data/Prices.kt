package com.example.myapplication.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class Prices (
    @SerializedName("price") val price: Price?,
    @SerializedName("from_price") val fromPrice: Price?,
    @SerializedName("price_label") val priceLabel: String?,
    @SerializedName("discount_label") val discountLabel: String?
)