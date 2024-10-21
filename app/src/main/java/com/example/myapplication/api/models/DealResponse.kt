package com.example.myapplication.api.models

import com.example.myapplication.data.Prices
import com.google.gson.annotations.SerializedName

data class DealResponse (
    @SerializedName("unique") val unique: String,
    @SerializedName("title") val title: String,
    @SerializedName("company") val company: String,
    @SerializedName("description")val description: String,
    @SerializedName("city") val city: String,
    @SerializedName("sold_label") val soldLabel: String,
    @SerializedName("prices") val prices: Prices
)