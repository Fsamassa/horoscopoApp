package com.example.horoscopoapp.ui.horoscopo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horoscopoapp.databinding.FragmentHoroscopoBinding
import com.example.horoscopoapp.domain.model.HoroscopoInfo
import com.example.horoscopoapp.domain.model.HoroscopoModel
import com.example.horoscopoapp.ui.horoscopo.adapter.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()
    private lateinit var horoscopoAdapter:HoroscopoAdapter

    // Se suele utilizar guin bajo para identificar variables que no queremos que accedan
    private var _binding:FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }
    private fun initList(){
        horoscopoAdapter = HoroscopoAdapter(onItemSelected = {

            val type = when(it){
                HoroscopoInfo.Aquario -> HoroscopoModel.Aquarius
                HoroscopoInfo.Aries -> HoroscopoModel.Aries
                HoroscopoInfo.Cancer -> HoroscopoModel.Cancer
                HoroscopoInfo.Capricornio -> HoroscopoModel.Capricorn
                HoroscopoInfo.Escorpio -> HoroscopoModel.Scorpio
                HoroscopoInfo.Geminis -> HoroscopoModel.Gemini
                HoroscopoInfo.Leo -> HoroscopoModel.Leo
                HoroscopoInfo.Libra -> HoroscopoModel.Libra
                HoroscopoInfo.Piscis -> HoroscopoModel.Pisces
                HoroscopoInfo.Sagitario -> HoroscopoModel.Sagittarius
                HoroscopoInfo.Tauro -> HoroscopoModel.Taurus
                HoroscopoInfo.Virgo -> HoroscopoModel.Virgo
            }
            val lang = it.idioma
            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToHoroscopoDetalleActivity(type,lang)
            )
        })


        binding.rvHoroscopo.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = horoscopoAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoViewModel.horoscopo.collect{
                    horoscopoAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container,false)
        return binding.root
    }
}