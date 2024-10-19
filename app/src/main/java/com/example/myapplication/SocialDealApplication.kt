package com.example.myapplication

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SocialDealApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}