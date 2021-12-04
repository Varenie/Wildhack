package com.varenie.wildhack.ui.FirstForm

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentCheckBinding
import com.varenie.wildhack.databinding.FragmentHelloBinding

class CheckFragment : Fragment() {
    private var _binding: FragmentCheckBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val regLayout = binding.llReg
        val aboutLayout = binding.llAboutOneself
        val testLayout = binding.llTest
        val skillsLayout = binding.llSkills
        val creativeLayout = binding.llCreative

        val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val regDone = sharedPref.getBoolean("RegDone", false)
        val aboutDone = sharedPref.getBoolean("AboutDone", false)

        if (regDone) {
            binding.cbReg.isChecked = true
            regLayout.isClickable = false
        }

        if (aboutDone) {
            binding.cbAboutOneself.isChecked = true
            binding.llAboutOneself.isClickable = false
        }

        regLayout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_checkFragment_to_navigation_main_data)
        }
        aboutLayout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_checkFragment_to_letsMeet)
        }
        testLayout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_checkFragment_to_testHelloFragment)
        }
        skillsLayout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_checkFragment_to_skillsHelloFragment)
        }
        creativeLayout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_checkFragment_to_creativeFragment)
        }

        return root
    }

    override fun onResume() {
        super.onResume()

        val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val regDone = sharedPref.getBoolean("RegDone", false)
        val aboutDone = sharedPref.getBoolean("AboutDone", false)

        if (regDone) {
            binding.cbReg.isChecked = true
            binding.llReg.isClickable = false
        }

        if (aboutDone) {
            binding.cbAboutOneself.isChecked = true
            binding.llAboutOneself.isClickable = false
        }
    }

}