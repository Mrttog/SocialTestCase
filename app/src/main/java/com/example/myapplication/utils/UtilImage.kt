package com.example.myapplication.utils

object  UtilImage {
    fun String.addPrefix() : String {
        return "https://images.socialdeal.nl$this"
    }
}