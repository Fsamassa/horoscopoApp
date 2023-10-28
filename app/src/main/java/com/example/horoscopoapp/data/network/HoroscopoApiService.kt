package com.example.horoscopoapp.data.network

import com.example.horoscopoapp.data.network.response.PrediccionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiService {
    @GET("/{sign}")
    suspend fun getHoroscopo(@Path("sign") unSigno:String):PrediccionResponse
}