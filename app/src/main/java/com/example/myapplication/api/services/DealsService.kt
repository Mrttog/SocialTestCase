package com.example.myapplication.api.services

import com.example.myapplication.api.models.DealResponse
import retrofit2.Response
import retrofit2.http.GET

interface DealsService {
    @GET("demo/deals.json")
    suspend fun getDeals(): Response<DealResponse>
}