package com.varenie.wildhack.ui.FirstForm.Creative

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import androidx.navigation.Navigation
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentCreativeBinding
import com.varenie.wildhack.databinding.FragmentLetsMeetBinding
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream

class CreativeFragment : Fragment() {
    private var _binding: FragmentCreativeBinding? = null

    val REQUEST_CODE = 100
    private val PERMISSION_ID = 101

    lateinit var sharedPref: SharedPreferences

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreativeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(it).apply {
                popBackStack()
            }
        }

        if (!checkPermission())
            requestPermission()

        binding.btnUploadFile.setOnClickListener {
            openGalleryForImage()
            val uri = sharedPref.getString("URI", null)
            val id = sharedPref.getInt("FormId", 0)

            var myArr: ByteArray? = null
            uri?.let {
                val iStream = requireActivity().contentResolver.openInputStream(uri.toUri())
                myArr = getBytes(iStream!!)
            }

            val table = FirstFormDAO(requireContext())
            table.addCreative(id, myArr!!)
        }

        binding.btnSaveAndNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_creativeFragment_to_creativeQuestion)
        }
        return root
    }

    private fun getBytes(iStream: InputStream): ByteArray {
        val byteBuffer = ByteArrayOutputStream()
        val bufferSize = 1024
        val buffer = ByteArray(bufferSize)

        var len = 0
        while (iStream.read(buffer).also { len = it } != -1) {
            byteBuffer.write(buffer, 0, len)
        }
        return byteBuffer.toByteArray()
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            when(requestCode) {
                REQUEST_CODE -> {
                    with(sharedPref.edit()) {
                        putString("URI", data.data.toString())
                        apply()
                    }
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun checkPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE),
            PERMISSION_ID
        )
    }


}