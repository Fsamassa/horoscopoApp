package com.example.horoscopoapp.ui.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.ActivityHoroscopoDetalleBinding
import com.example.horoscopoapp.domain.model.HoroscopoModel
import com.example.horoscopoapp.domain.model.HoroscopoModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoDetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopoDetalleBinding
    private val horoscopoDetalleViewModel:HoroscopoDetalleViewModel by viewModels()

    private val arg:HoroscopoDetalleActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopoDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopoDetalleViewModel.getHoroscopo(arg.type)

    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoDetalleViewModel.state.collect{
                    when(it){
                        HoroscopoDetalleEstado.Loading -> loadingState()
                        is HoroscopoDetalleEstado.Error -> errorState()
                        is HoroscopoDetalleEstado.Success -> successState(it)

                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.progresBar.isVisible = true
    }
    private fun errorState() {
        binding.progresBar.isVisible = false
    }
    private fun successState(estado: HoroscopoDetalleEstado.Success) {

        binding.progresBar.isVisible = false
        binding.tvTituloDetalle.text = estado.signo
        binding.tvDetalle.text = estado.prediccion

        val imagen = when (estado.horoscopoModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(imagen)

    }
}