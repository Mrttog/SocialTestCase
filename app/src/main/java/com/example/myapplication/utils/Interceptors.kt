package com.example.myapplication.utils

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class TrailingCommaInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        val url = response.request.url.toString()
        val responseBodyString = response.body?.string() ?: ""

        val newResponse = if (url.contains("details.json")) {
            responseBodyString.removeRange(responseBodyString.length - 3, responseBodyString.length - 2)
        } else {
            responseBodyString
        }
        return response.newBuilder()
            .body(newResponse.toResponseBody(response.body?.contentType()))
            .build()
    }
}