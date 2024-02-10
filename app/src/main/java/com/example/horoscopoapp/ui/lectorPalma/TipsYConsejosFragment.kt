package com.example.horoscopoapp.ui.lectorPalma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.FragmentTipsYConsejosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TipsYConsejosFragment : Fragment() {
    private var _binding: FragmentTipsYConsejosBinding? = null
    private val binding get() = _binding!!
    private val arg: TipsYConsejosFragmentArgs by navArgs()

            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTipsYConsejosBinding.inflate(layoutInflater, container,false)

        return binding.root
    }

}