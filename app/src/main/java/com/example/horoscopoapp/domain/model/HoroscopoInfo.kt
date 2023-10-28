package com.example.horoscopoapp.domain.model

import com.example.horoscopoapp.R


sealed class HoroscopoInfo(val imagen:Int, val name:Int) {
    data object Aries:HoroscopoInfo(R.drawable.aries, R.string.aries)
    data object Tauro:HoroscopoInfo(R.drawable.tauro, R.string.tauro)
    data object Geminis:HoroscopoInfo(R.drawable.geminis, R.string.geminis)
    data object Leo:HoroscopoInfo(R.drawable.leo, R.string.leo)
    data object Virgo:HoroscopoInfo(R.drawable.virgo, R.string.virgo)
    data object Cancer:HoroscopoInfo(R.drawable.cancer, R.string.cancer)
    data object Libra:HoroscopoInfo(R.drawable.libra, R.string.libra)
    data object Escorpio:HoroscopoInfo(R.drawable.escorpio, R.string.escorpio)
    data object Sagitario:HoroscopoInfo(R.drawable.sagitario, R.string.sagitario)
    data object Capricornio:HoroscopoInfo(R.drawable.capricornio, R.string.capricornio)
    data object Aquario:HoroscopoInfo(R.drawable.aquario, R.string.aquario)
    data object Piscis:HoroscopoInfo(R.drawable.piscis, R.string.piscis)


}