package com.example.horoscopoapp.domain.model

import com.example.horoscopoapp.R


sealed class HoroscopoInfo(val imagen:Int, val name:Int, val rango_fecha:Int) {
    data object Aries:HoroscopoInfo(R.drawable.aries, R.string.aries, R.string.rango_aries)
    data object Tauro:HoroscopoInfo(R.drawable.tauro, R.string.tauro, R.string.rango_tauro)
    data object Geminis:HoroscopoInfo(R.drawable.geminis, R.string.geminis, R.string.rango_geminis)
    data object Leo:HoroscopoInfo(R.drawable.leo, R.string.leo, R.string.rango_leo)
    data object Virgo:HoroscopoInfo(R.drawable.virgo, R.string.virgo, R.string.rango_virgo)
    data object Cancer:HoroscopoInfo(R.drawable.cancer, R.string.cancer, R.string.rango_cancer)
    data object Libra:HoroscopoInfo(R.drawable.libra, R.string.libra, R.string.rango_libra)
    data object Escorpio:HoroscopoInfo(R.drawable.escorpio, R.string.escorpio, R.string.rango_escorpio)
    data object Sagitario:HoroscopoInfo(R.drawable.sagitario, R.string.sagitario, R.string.rango_sagitario)
    data object Capricornio:HoroscopoInfo(R.drawable.capricornio, R.string.capricornio, R.string.rango_capricornio)
    data object Aquario:HoroscopoInfo(R.drawable.aquario, R.string.aquario, R.string.rango_aquario)
    data object Piscis:HoroscopoInfo(R.drawable.piscis, R.string.piscis, R.string.rango_piscis)


}