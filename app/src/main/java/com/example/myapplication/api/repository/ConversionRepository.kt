package com.example.myapplication.api.repository

import com.example.myapplication.api.services.ConversionService
import com.example.myapplication.di.BaseUrlConversion
import javax.inject.Inject


class ConversionRepository @Inject constructor(
    @BaseUrlConversion private val conversionService: ConversionService
) {

    suspend fun getConversion() = conversionService.getConversion()
}