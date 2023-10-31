package com.example.horoscopoapp.ui.lectorPalma

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.example.horoscopoapp.databinding.FragmentLectorPalmaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LectorPalmaFragment : Fragment() {
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
        return binding.root
    }

}