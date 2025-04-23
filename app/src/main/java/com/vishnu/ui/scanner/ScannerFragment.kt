package com.vishnu.ui.scanner

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageProxy
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import com.vishnu.ProductItem
import com.vishnu.ibwscse227miniproject.databinding.FragmentScannerBinding
import com.vishnu.ui.scanner.viewmodel.ScannerViewModel
import java.util.concurrent.Executors

class ScannerFragment : Fragment() {

    private var _binding: FragmentScannerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ScannerViewModel by viewModels()
    private var scannedProduct: ProductItem? = null
    private lateinit var barcodeScanner: BarcodeScanner
    private var cameraProvider: ProcessCameraProvider? = null
    private val cameraExecutor = Executors.newSingleThreadExecutor()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            startCamera()
        } else {
            Toast.makeText(requireContext(), "Camera permission required", Toast.LENGTH_SHORT).show()
            requireActivity().onBackPressed()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ML Kit Barcode Scanner
        val options = BarcodeScannerOptions.Builder()
            .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
            .build()
        barcodeScanner = BarcodeScanning.getClient(options)

        setupObservers()
        setupButtons()
        checkCameraPermission()
    }

    private fun setupObservers() {
        viewModel.product.observe(viewLifecycleOwner) { product ->
            product?.let {
                scannedProduct = it.copy(quantity = 1)
                binding.apply {
                    previewView.visibility = View.GONE
                    productDetailsLayout.visibility = View.VISIBLE
                    productName.text = it.name
                    productPrice.text = "₹${it.price}"
                    productQuantity.text = "1"
                }
            } ?: run {
                Toast.makeText(requireContext(), "Product not found", Toast.LENGTH_SHORT).show()
                resetScanner()
            }
        }

        viewModel.addToReceivedStatus.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(requireContext(), "Item added to received orders", Toast.LENGTH_SHORT).show()
                resetScanner()
            } else {
                Toast.makeText(requireContext(), "Failed to add item", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupButtons() {
        binding.btnIncrease.setOnClickListener {
            scannedProduct?.let { product ->
                val newQuantity = product.quantity + 1
                scannedProduct = product.copy(quantity = newQuantity)
                binding.productQuantity.text = newQuantity.toString()
            }
        }

        binding.btnDecrease.setOnClickListener {
            scannedProduct?.let { product ->
                if (product.quantity > 1) {
                    val newQuantity = product.quantity - 1
                    scannedProduct = product.copy(quantity = newQuantity)
                    binding.productQuantity.text = newQuantity.toString()
                }
            }
        }

        binding.btnAddToReceived.setOnClickListener {
            scannedProduct?.let { product ->
                viewModel.addToReceivedItems(product)
            } ?: run {
                Toast.makeText(requireContext(), "No product scanned", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnScanAgain.setOnClickListener {
            resetScanner()
        }
    }

    private fun checkCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                startCamera()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                Toast.makeText(requireContext(),
                    "Camera permission is required for barcode scanning",
                    Toast.LENGTH_LONG).show()
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            try {
                cameraProvider = cameraProviderFuture.get()
                bindCameraUseCases()
            } catch(exc: Exception) {
                Log.e("ScannerFragment", "Camera initialization failed", exc)
                Toast.makeText(requireContext(),
                    "Camera initialization failed",
                    Toast.LENGTH_SHORT).show()
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    private fun bindCameraUseCases() {
        val cameraProvider = cameraProvider ?: return

        // Unbind existing use cases first
        cameraProvider.unbindAll()

        // Camera selector - back camera
        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        // Preview
        val preview = Preview.Builder()
            .build()
            .also {
                it.setSurfaceProvider(binding.previewView.surfaceProvider)
            }

        // Image analyzer
        val imageAnalyzer = ImageAnalysis.Builder()
            .setTargetResolution(Size(1280, 720))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
            .also {
                it.setAnalyzer(cameraExecutor) { imageProxy ->
                    processImageProxy(imageProxy)
                }
            }

        try {
            cameraProvider.bindToLifecycle(
                viewLifecycleOwner,
                cameraSelector,
                preview,
                imageAnalyzer
            )
        } catch(exc: Exception) {
            Log.e("ScannerFragment", "Use case binding failed", exc)
        }
    }

    private fun processImageProxy(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(
                mediaImage,
                imageProxy.imageInfo.rotationDegrees
            )

            barcodeScanner.process(image)
                .addOnSuccessListener { barcodes ->
                    if (barcodes.isNotEmpty()) {
                        val barcode = barcodes.first()
                        barcode.rawValue?.let { barcodeValue ->
                            activity?.runOnUiThread {
                                if (scannedProduct == null) { // Prevent multiple scans
                                    viewModel.fetchProductByBarcode(barcodeValue)
                                }
                            }
                        }
                    }
                }
                .addOnFailureListener { e ->
                    Log.e("ScannerFragment", "Barcode scanning failed", e)
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        } else {
            imageProxy.close()
        }
    }

    private fun resetScanner() {
        scannedProduct = null
        binding.previewView.visibility = View.VISIBLE
        binding.productDetailsLayout.visibility = View.GONE
        startCamera()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cameraExecutor.shutdown()
        barcodeScanner.close()
        cameraProvider?.unbindAll()
        _binding = null
    }
}