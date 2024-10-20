package com.example.myapplication.api.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.data.Prices

@Entity(tableName = "favorites")
data class DealEntity(
    @PrimaryKey val unique: String,
    val title: String,
    val image: String,
    val sold_label: String,
    val company: String,
    val city: String,
    val prices: Prices,
    var isFavorite: Boolean = false
)
