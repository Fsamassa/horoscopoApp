package com.example.horoscopoapp.data.providers

import com.example.horoscopoapp.domain.model.HoroscopoInfo
import com.example.horoscopoapp.domain.model.HoroscopoInfo.*
import javax.inject.Inject

class HoroscopoProvider @Inject constructor(){
    fun getHoroscopo():List<HoroscopoInfo> {
        return listOf(
            Aries,
            Tauro,
            Geminis,
            Leo,
            Virgo,
            Cancer,
            Libra,
            Escorpio,
            Sagitario,
            Capricornio,
            Aquario,
            Piscis
        )

    }
}