package com.example.horoscopoapp.ui.suerte

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.FragmentSuerteBinding
import com.example.horoscopoapp.ui.core.listeners.OnSwipeTouchListener
import com.example.horoscopoapp.ui.providers.RandomCartasProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Objects
import java.util.Random
import javax.inject.Inject

@AndroidEntryPoint
class SuerteFragment : Fragment() {

    private var _binding: FragmentSuerteBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var randomCartasProvider: RandomCartasProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        prepararPrediccion()
        initListeners()
    }

    private fun prepararPrediccion() {
        val suerte = randomCartasProvider.getSuerte()
        suerte?.let { suerteActual ->

            val textoPrediccion = getString(suerteActual.texto)
            binding.tvSuerte.text = textoPrediccion
            binding.ivCartaSuerte.setImageResource(suerteActual.imagen)
            binding.tvShare.setOnClickListener {compartirSuerte(textoPrediccion)

            }
        }
    }

    private fun compartirSuerte(prediccion:String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, prediccion)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListeners() {
        binding.ivRuleta.setOnTouchListener(object : OnSwipeTouchListener(requireContext()){
            override fun onSwipeRight() {
                girarRuleta()
            }

            override fun onSwipeLeft() {
                girarRuleta()
            }
        })
    }

    private fun girarRuleta() {
        val random = Random()
        val grados = random.nextInt(1440) + 360
        val animator = ObjectAnimator.ofFloat(binding.ivRuleta, View.ROTATION, 0f, grados.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { deslizarCarta() }
        animator.start()
    }

    private fun deslizarCarta() {
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)

        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                binding.ivCartaElegida.isVisible = true
            }
            override fun onAnimationEnd(p0: Animation?) {
                agrandarCarta()
            }
            override fun onAnimationRepeat(p0: Animation?) { }
        })
        binding.ivCartaElegida.startAnimation(slideUpAnimation)

    }

    private fun agrandarCarta() {
        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.agrandar_carta)

        growAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                binding.ivCartaElegida.isVisible = false
                mostrarPrediccionView()
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
        binding.ivCartaElegida.startAnimation(growAnimation)
    }

    private fun mostrarPrediccionView() {
        val desaparecerAnimacion = AlphaAnimation(1.0f, 0.0f)
        desaparecerAnimacion.duration = 200

        val aparecerAnimacion = AlphaAnimation(0.0f, 1.0f)
        aparecerAnimacion.duration = 1000

        desaparecerAnimacion.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                binding.preview.isVisible = false
                binding.prediccion.isVisible = true

            }
            override fun onAnimationRepeat(p0: Animation?) {}
        })

        binding.preview.startAnimation(desaparecerAnimacion)
        binding.prediccion.startAnimation(aparecerAnimacion)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSuerteBinding.inflate(layoutInflater, container,false)
        return binding.root
    }


}