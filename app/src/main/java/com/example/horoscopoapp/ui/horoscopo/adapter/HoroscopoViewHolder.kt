package com.example.horoscopoapp.ui.horoscopo.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.databinding.ItemHoroscopoBinding
import com.example.horoscopoapp.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)
    fun render(horoscopoInfo: HoroscopoInfo, onItemSelected: (HoroscopoInfo) -> Unit){
        val contexto = binding.tvTitulo.context

        binding.ivHoroscopo.setImageResource(horoscopoInfo.imagen)
        binding.tvTitulo.text = contexto.getString(horoscopoInfo.name)
        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscopo, otraFunLambda = {onItemSelected(horoscopoInfo)})
//      onItemSelected(horoscopoInfo)
        }
    }

    private fun startRotationAnimation(view: View, otraFunLambda:()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationYBy(360f)
            withEndAction{otraFunLambda()}
            start()
        }

    }
}
