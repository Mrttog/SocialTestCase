package com.example.myapplication.api.models

import com.example.myapplication.data.Deal

data class DealResponse (
    val num_deals: Int,
    val deals: List<Deal>
)