package com.varenie.wildhack.ui.FirstForm

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.Database.Entities.FirstForm
import com.varenie.wildhack.Network.Common
import com.varenie.wildhack.Network.RetrofitService
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentCheckBinding
import com.varenie.wildhack.databinding.FragmentComleteBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Complete : Fragment() {
    private var _binding: FragmentComleteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var mService: RetrofitService
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComleteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        mService = Common.retrofitService

        binding.btnOk.setOnClickListener {
            val table = FirstFormDAO(requireContext())
            val form = table.getForm()

            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("FirstFormDone", true)
                apply()
            }
            uploadForm(form)

            Navigation.findNavController(it).navigate(R.id.action_complete_to_helloFragment)
        }
        return root
    }

    private fun uploadForm(form: FirstForm) {
        mService.uploadData(form).enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Toast.makeText(requireContext(), "SUCCESS", Toast.LENGTH_SHORT)
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(requireContext(), "FAILURE", Toast.LENGTH_SHORT)
            }

        })

    }

}