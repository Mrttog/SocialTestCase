package com.example.myapplication.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Singleton

@Singleton
class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("shared_preferences", Context.MODE_PRIVATE)

    companion object {
        private const val IS_EURO = "is_euro"
    }

    fun saveCurrencyPreference(isEuro: Boolean) {
        sharedPreferences.edit().putBoolean(IS_EURO, isEuro).apply()
    }

    fun getCurrencyPreference(): Boolean {
        return sharedPreferences.getBoolean(IS_EURO, true)
    }
}