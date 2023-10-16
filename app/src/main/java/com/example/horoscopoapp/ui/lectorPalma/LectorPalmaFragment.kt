package com.example.horoscopoapp.ui.lectorPalma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.horoscopoapp.databinding.FragmentLectorPalmaBinding

class LectorPalmaFragment : Fragment() {

    private var _binding: FragmentLectorPalmaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLectorPalmaBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

}