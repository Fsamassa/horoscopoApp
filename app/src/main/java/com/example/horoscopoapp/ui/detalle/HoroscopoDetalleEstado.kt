package com.example.horoscopoapp.ui.detalle

import com.example.horoscopoapp.domain.model.HoroscopoModel

sealed class HoroscopoDetalleEstado {
    data object Loading:HoroscopoDetalleEstado()
    data class Error(val error:String):HoroscopoDetalleEstado()
    data class Success(val prediccion:String, val signo:String, val horoscopoModel: HoroscopoModel):HoroscopoDetalleEstado()
}