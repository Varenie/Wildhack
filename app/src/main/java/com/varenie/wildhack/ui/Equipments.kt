package com.varenie.wildhack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentEquipmentsBinding


class Equipments : Fragment() {
    private var _binding: FragmentEquipmentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEquipmentsBinding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_equipments_to_helloFragment)
        }

        return binding.root
    }

}