package com.example.horoscopoapp.ui.lectorPalma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.FragmentQuiromanciaBinding
import com.example.horoscopoapp.ui.detalle.HoroscopoDetalleActivityArgs
import dagger.hilt.android.AndroidEntryPoint
import hilt_aggregated_deps._com_example_horoscopoapp_ui_lectorPalma_QuiromanciaFragment_GeneratedInjector

@AndroidEntryPoint
class QuiromanciaFragment : Fragment() {

    private var _binding: FragmentQuiromanciaBinding? = null
    private val binding get() = _binding!!
    private val arg: QuiromanciaFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuiromanciaBinding.inflate(layoutInflater, container,false)

        initUI()

        return binding.root
    }


    private fun initUI() {

        when(arg.tipoLinea){
            "Cinturón de Venus" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_girdle_of_venus)
                binding.tvTituloLinea.text = getString(R.string.titulo_cinturon_venus)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_cinturon_venus)
            }
            "Línea del Destino" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_destiny)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_destino)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_destino)

            }
            "Línea de la Cabeza" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_head)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_cabeza)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_cabeza)

            }
            "Línea de la Salud" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_health)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_salud)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_salud)

            }
            "Línea del Corazón" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_heart)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_corazon)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_corazon)

            }
            "Línea de la Intuición" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_intuition)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_intuicion)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_intuicion)

            }
            "Línea de la Vida" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_life)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_vida)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_vida)

            }
            "Línea del Matrimonio" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_marriage)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_matrimonio)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_matrimonio)

            }
            "Línea del Marte" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_mars)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_marte)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_marte)

            }
            "Línea del Sol" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_sun)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_sol)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_sol)

            }
            "Líneas del Brazalete" ->{
                binding.ivLineaConsultada.setImageResource(R.drawable.the_bracelets)
                binding.tvTituloLinea.text = getString(R.string.titulo_linea_brazalete)
                binding.tvDetalleLinea.text = getString(R.string.Detalles_linea_brazalete)

            }

        }

    }

}