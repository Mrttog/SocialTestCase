package com.example.myapplication.api.models

import com.example.myapplication.data.Data
import com.example.myapplication.data.Meta

data class ConversionResponse(
    val data: Data,
    val meta: Meta
)