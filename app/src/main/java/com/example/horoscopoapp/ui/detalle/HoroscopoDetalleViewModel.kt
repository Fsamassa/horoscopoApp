package com.example.horoscopoapp.ui.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscopoapp.domain.model.HoroscopoInfo
import com.example.horoscopoapp.domain.model.HoroscopoModel
import com.example.horoscopoapp.domain.usecase.GetPrediccionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopoDetalleViewModel @Inject constructor(private val getPrediccionUseCase: GetPrediccionUseCase):ViewModel() {

    private var _state = MutableStateFlow<HoroscopoDetalleEstado>(HoroscopoDetalleEstado.Loading)
    val state: StateFlow<HoroscopoDetalleEstado> = _state
    lateinit var horoscopo: HoroscopoModel

    fun getHoroscopo(signo: HoroscopoModel, idioma:String){

        horoscopo = signo
        viewModelScope.launch {
            // Acá estoy trabajando en el hilo principal
            _state.value = HoroscopoDetalleEstado.Loading

            // Acá dentro estoy trabajando en el hilo secundario
            val result = withContext(Dispatchers.IO) {getPrediccionUseCase(signo.name,idioma)}

            // Acá sigo trabajando en el hilo principal
            if (result != null){
                _state.value = HoroscopoDetalleEstado.Success(result.horoscopo, result.signo, horoscopo)
            }else{
                _state.value = HoroscopoDetalleEstado.Error("Ha ocurrido un error al querer obtener el detalle.")
            }
        }
    }
}