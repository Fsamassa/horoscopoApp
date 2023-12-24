package com.example.horoscopoapp.domain.model

import com.example.horoscopoapp.R


sealed class HoroscopoInfo(val imagen:Int, val name:Int, val rango_fecha:Int, var idioma:String ) {
    data object Aries:HoroscopoInfo(R.drawable.aries, R.string.aries, R.string.rango_aries, "es")
    data object Tauro:HoroscopoInfo(R.drawable.tauro, R.string.tauro, R.string.rango_tauro, "es")
    data object Geminis:HoroscopoInfo(R.drawable.geminis, R.string.geminis, R.string.rango_geminis, "es")
    data object Leo:HoroscopoInfo(R.drawable.leo, R.string.leo, R.string.rango_leo, "es")
    data object Virgo:HoroscopoInfo(R.drawable.virgo, R.string.virgo, R.string.rango_virgo, "es")
    data object Cancer:HoroscopoInfo(R.drawable.cancer, R.string.cancer, R.string.rango_cancer, "es")
    data object Libra:HoroscopoInfo(R.drawable.libra, R.string.libra, R.string.rango_libra, "es")
    data object Escorpio:HoroscopoInfo(R.drawable.escorpio, R.string.escorpio, R.string.rango_escorpio, "es")
    data object Sagitario:HoroscopoInfo(R.drawable.sagitario, R.string.sagitario, R.string.rango_sagitario, "es")
    data object Capricornio:HoroscopoInfo(R.drawable.capricornio, R.string.capricornio, R.string.rango_capricornio, "es")
    data object Aquario:HoroscopoInfo(R.drawable.aquario, R.string.aquario, R.string.rango_aquario, "es")
    data object Piscis:HoroscopoInfo(R.drawable.piscis, R.string.piscis, R.string.rango_piscis, "es")


}