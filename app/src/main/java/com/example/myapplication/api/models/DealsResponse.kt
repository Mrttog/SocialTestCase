package com.example.myapplication.api.models

import com.example.myapplication.data.Deal

data class DealsResponse (
    val num_deals: Int,
    val deals: List<Deal>
)