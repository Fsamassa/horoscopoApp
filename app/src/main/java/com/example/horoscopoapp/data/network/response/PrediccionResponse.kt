package com.example.horoscopoapp.data.network.response

import com.example.horoscopoapp.domain.model.PrediccionModel
import com.google.gson.annotations.SerializedName
data class PrediccionResponse(
    @SerializedName("date") val fecha:String,
    @SerializedName("horoscope") val horoscopo:String,
    @SerializedName("sign") val signo:String
){
    fun toDomain():PrediccionModel{
        return PrediccionModel(
            horoscopo = horoscopo,
            signo = signo
        )
    }
}