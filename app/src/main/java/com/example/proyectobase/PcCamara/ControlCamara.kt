
package com.example.proyectobase.PcCamara
import android.provider.ContactsContract.Directory
import androidx.camera.camera2.internal.annotation.CameraExecutor
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.ExecutorService

object ControlCamara {
    private lateinit var imageCapture: ImageCapture
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    fun takephoto(){
        val imageCapture= imageCapture ?:return
        val photoFile=File(outputDirectory,SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US).format(System.currentTimeMillis())+"jpg")
        val outputOption = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        imageCapture.takePicture(
            outputOptions, cameraExecutor,
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    // Image saved successfully
                }
                override fun onError(exception: ImageCaptureException) {
                    // Handle error
                }
            })
    }
}
