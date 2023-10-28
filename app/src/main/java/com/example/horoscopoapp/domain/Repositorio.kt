package com.example.horoscopoapp.domain

import com.example.horoscopoapp.domain.model.PrediccionModel


// comunicación entre capa data y capa dominio
interface Repositorio {
    suspend fun getPrediccion(sign:String): PrediccionModel?
}