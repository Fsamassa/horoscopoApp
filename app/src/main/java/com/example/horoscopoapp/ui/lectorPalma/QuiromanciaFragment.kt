package com.example.horoscopoapp.ui.lectorPalma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                binding.tvTituloTips.text = getString(R.string.titulo_cinturon_venus)
                binding.tvDetalleTips.text = getString(R.string.Detalles_cinturon_venus)
            }
            "Línea del Destino" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_destiny)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_destino)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_destino)

            }
            "Línea de la Cabeza" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_head)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_cabeza)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_cabeza)

            }
            "Línea de la Salud" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_health)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_salud)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_salud)

            }
            "Línea del Corazón" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_heart)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_corazon)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_corazon)

            }
            "Línea de la Intuición" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_intuition)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_intuicion)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_intuicion)

            }
            "Línea de la Vida" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_life)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_vida)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_vida)

            }
            "Línea del Matrimonio" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_marriage)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_matrimonio)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_matrimonio)

            }
            "Línea del Marte" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_mars)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_marte)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_marte)

            }
            "Línea del Sol" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry_line_of_sun)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_sol)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_sol)

            }
            "Líneas del Brazalete" ->{
                binding.ivLineaConsultada.setImageResource(R.drawable.the_bracelets)
                binding.tvTituloTips.text = getString(R.string.titulo_linea_brazalete)
                binding.tvDetalleTips.text = getString(R.string.Detalles_linea_brazalete)

            }
            "Consejos, tips y algo más…" -> {
                binding.ivLineaConsultada.setImageResource(R.drawable.palmistry)
                binding.tvTituloTips.text = getString(R.string.titulo_ayuda)
                binding.tvDetalleTips.text = getString(R.string.Consejos_y_tips)

            }
        }

    }

}