package com.example.horoscopoapp.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.horoscopoapp.databinding.FragmentHoroscopoBinding

class HoroscopoFragment : Fragment() {

    // Se suele utilizar guin bajo para identificar variables que no queremos que accedan
    private var _binding:FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container,false)
        return binding.root
    }
}