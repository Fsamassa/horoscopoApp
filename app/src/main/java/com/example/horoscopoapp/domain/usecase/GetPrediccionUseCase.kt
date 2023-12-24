package com.example.horoscopoapp.domain.usecase

import com.example.horoscopoapp.domain.Repositorio
import javax.inject.Inject

class GetPrediccionUseCase @Inject constructor(private val repositorio: Repositorio) {

    suspend operator fun invoke(signo:String, idioma:String) = repositorio.getPrediccion(signo,idioma)
}