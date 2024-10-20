package com.example.myapplication.api.services

import com.example.myapplication.api.models.ConversionResponse
import retrofit2.Response
import retrofit2.http.GET

interface ConversionService {
    @GET("v3/latest?apikey=cur_live_ogzEuuciXOR0LOZdFaYKNa4cbM5WymdlIn3y9Lme&currencies=USD&base_currency=EUR")
    suspend fun getConversion(): Response<ConversionResponse>
}