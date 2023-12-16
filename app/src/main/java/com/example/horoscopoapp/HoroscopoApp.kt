package com.example.horoscopoapp

import android.app.Application
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HoroscopoApp:Application(){

    override fun onCreate(){
        super.onCreate()
        MobileAds.initialize(this)
    }
}