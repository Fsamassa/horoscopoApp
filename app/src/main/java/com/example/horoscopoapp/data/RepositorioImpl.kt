package com.example.horoscopoapp.data

import android.util.Log
import com.example.horoscopoapp.data.network.HoroscopoApiService
import com.example.horoscopoapp.domain.Repositorio
import com.example.horoscopoapp.domain.model.PrediccionModel
import javax.inject.Inject

class RepositorioImpl @Inject constructor(private val apiService: HoroscopoApiService):Repositorio {
    override suspend fun getPrediccion(signo: String):PrediccionModel? {
        runCatching{ apiService.getHoroscopo(signo)}
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Error", "Error al intentar obtener prediccion: ${it.message}") }

        return null
    }
}