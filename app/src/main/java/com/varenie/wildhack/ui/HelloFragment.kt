package com.varenie.wildhack.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentHelloBinding


class HelloFragment : Fragment() {
    private var _binding: FragmentHelloBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var sharedPref: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelloBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnStart = binding.btnStartForm

        sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val firstFormDone = sharedPref.getBoolean("FirstFormDone", false)
        btnStart.setOnClickListener {
            if (firstFormDone) {
                Navigation.findNavController(it).navigate(R.id.action_helloFragment_to_tutorials)
            } else {
                Navigation.findNavController(it)
                    .navigate(R.id.action_helloFragment_to_checkFragment)
            }
        }
        binding.llReg1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_helloFragment_to_faq)
        }
        binding.llReg2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_helloFragment_to_equipments)
        }
        binding.llReg3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_helloFragment_to_documents)
        }
        binding.llReg4.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_helloFragment_to_acommodation_options)
        }
        return root
    }

    override fun onResume() {
        super.onResume()

        val firstFormDone = sharedPref.getBoolean("FirstFormDone", false)

        if (firstFormDone) {
            binding.btnStartForm.text = "Продолжить"
        }
    }


}