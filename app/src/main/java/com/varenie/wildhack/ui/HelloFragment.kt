package com.varenie.wildhack.ui

import android.content.Context
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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelloBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnStart = binding.btnStartForm

        btnStart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_helloFragment_to_checkFragment)
        }
        binding.llReg1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_helloFragment_to_faq)
        }
        return root
    }


}