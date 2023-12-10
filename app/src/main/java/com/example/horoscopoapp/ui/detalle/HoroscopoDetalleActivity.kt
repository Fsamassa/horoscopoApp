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


        when (estado.horoscopoModel){
            Aries -> {
                binding.ivDetail.setImageResource(R.drawable.detail_aries)
                binding.tvFecha.text = getString(R.string.rango_aries)
            }
            Taurus -> {
                binding.ivDetail.setImageResource(R.drawable.detail_taurus)
                binding.tvFecha.text = getString(R.string.rango_tauro)
            }
            Gemini -> {
                binding.ivDetail.setImageResource(R.drawable.detail_gemini)
                binding.tvFecha.text = getString(R.string.rango_geminis)
            }
            Cancer -> {
                binding.ivDetail.setImageResource(R.drawable.detail_cancer)
                binding.tvFecha.text = getString(R.string.rango_cancer)
            }
            Leo -> {
                binding.ivDetail.setImageResource(R.drawable.detail_leo)
                binding.tvFecha.text = getString(R.string.rango_leo)
            }
            Virgo -> {
                binding.ivDetail.setImageResource(R.drawable.detail_virgo)
                binding.tvFecha.text =getString(R.string.rango_virgo)
            }
            Libra -> {
                binding.ivDetail.setImageResource(R.drawable.detail_libra)
                binding.tvFecha.text = getString(R.string.rango_libra)
            }
            Scorpio -> {
                binding.ivDetail.setImageResource(R.drawable.detail_scorpio)
                binding.tvFecha.text = getString(R.string.rango_escorpio)
            }
            Sagittarius -> {
                binding.ivDetail.setImageResource(R.drawable.detail_sagittarius)
                binding.tvFecha.text = getString(R.string.rango_sagitario)
            }
            Capricorn -> {
                binding.ivDetail.setImageResource(R.drawable.detail_capricorn)
                binding.tvFecha.text = getString(R.string.rango_capricornio)
            }
            Aquarius -> {
                binding.ivDetail.setImageResource(R.drawable.detail_aquarius)
                binding.tvFecha.text = getString(R.string.rango_aquario)
            }
            Pisces -> {
                binding.ivDetail.setImageResource(R.drawable.detail_pisces)
                binding.tvFecha.text = getString(R.string.rango_piscis)
            }
        }

    }
}