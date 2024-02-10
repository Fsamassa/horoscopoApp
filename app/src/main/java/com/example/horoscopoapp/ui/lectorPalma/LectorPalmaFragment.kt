package com.example.horoscopoapp.ui.lectorPalma

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.FragmentLectorPalmaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LectorPalmaFragment : Fragment(), AdapterView.OnItemClickListener {
    companion object{
        private const val CAMERA_PERMISSION = Manifest.permission.CAMERA
    }

    private var _binding: FragmentLectorPalmaBinding? = null
    private val binding get() = _binding!!

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted ->
        if (isGranted){
            startCamera()
        }else{
            Toast.makeText(
                requireContext(),
                "Acepta permisos para poder usar el lector de manos.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener({
            val cameraProvider:ProcessCameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
                }
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, cameraSelector, preview)
            }catch (e:Exception){
                Log.e("Facu", "Hubo un error con la camara ${e.message}")
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (checkCameraPermission()){
            startCamera()
        }else{
            requestPermissionLauncher.launch(CAMERA_PERMISSION)
        }
    }

    fun checkCameraPermission(): Boolean{
        return PermissionChecker.checkSelfPermission(requireContext(), CAMERA_PERMISSION) == PermissionChecker.PERMISSION_GRANTED // android.Manifest.permission.CAMERA
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLectorPalmaBinding.inflate(layoutInflater, container,false)

        initUI()

        return binding.root
    }
    private fun initUI() {
        initListeners()
        seleccionDeLineas()

    }
    private fun initListeners() {
        binding.ivInfo.setOnClickListener {
            val tipo_linea = "Consejos, tips y algo más…"
            findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToTipsYConsejosFragment(tipo_linea))

        }
    }

    override fun onResume() {
        super.onResume()
        seleccionDeLineas()
    }
    private fun seleccionDeLineas() {

        val lineasArray = resources.getStringArray(R.array.lineas_mano)
        val arrayAdapter = ArrayAdapter(binding.tilDropDown.context, R.layout.drop_down_lineas, lineasArray)
        binding.acLineas.setAdapter(arrayAdapter)

        with(binding.acLineas){
            onItemClickListener = this@LectorPalmaFragment
        }
    }
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val contexto = binding.ivInfo.context
        var linea_seleccionada = ""

        val itemLinea = parent!!.getItemAtPosition(position).toString()

        when(itemLinea){
            "Consejos, tips y algo más…" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.info))
                linea_seleccionada = "Consejos, tips y algo más…"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToTipsYConsejosFragment(linea_seleccionada))
                }
            }
            "Cinturón de Venus" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_girdle_of_venus)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.venus))
                linea_seleccionada = "Cinturón de Venus"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea del Destino" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_destiny)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.destiny))
                linea_seleccionada = "Línea del Destino"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea de la Cabeza" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_head)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.head))
                linea_seleccionada = "Línea de la Cabeza"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea de la Salud" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_health)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.health))
                linea_seleccionada = "Línea de la Salud"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea del Corazón" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_heart)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.heart))
                linea_seleccionada = "Línea del Corazón"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea de la Intuición" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_intuition)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.intuition))
                linea_seleccionada = "Línea de la Intuición"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea de la Vida" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_life)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.life))
                linea_seleccionada = "Línea de la Vida"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea del Matrimonio" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_marriage)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.marrige))
                linea_seleccionada = "Línea del Matrimonio"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea del Marte" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_mars)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.mars))
                linea_seleccionada = "Línea del Marte"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Línea del Sol" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.palmistry_line_of_sun)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.sun))
                linea_seleccionada = "Línea del Sol"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }
            "Líneas del Brazalete" -> {
                binding.ivLectorPalma.setImageResource(R.drawable.the_bracelets)
                DrawableCompat.setTint(binding.ivInfo.drawable,ContextCompat.getColor(contexto, R.color.bracelete))
                linea_seleccionada = "Líneas del Brazalete"
                binding.ivInfo.setOnClickListener {
                    findNavController().navigate(LectorPalmaFragmentDirections.actionLectorPalmaFragmentToQuiromanciaFragment(linea_seleccionada))
                }
            }

        }
    }
}