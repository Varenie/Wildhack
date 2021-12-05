package com.varenie.wildhack.ui.FirstForm

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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

        binding.btnContinue.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_checkFragment_to_about_the_school)
        }

        return root
    }

    override fun onResume() {
        super.onResume()

        val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val regDone = sharedPref.getBoolean("RegDone", false)
        val aboutDone = sharedPref.getBoolean("AboutDone", false)
        val testDone = sharedPref.getBoolean("TestDone", false)
        val skillsDone = sharedPref.getBoolean("SkillsDone", false)
        val creativeDone = sharedPref.getBoolean("CreativeDone", false)

        if (regDone) {
            binding.cbReg.isChecked = true
            binding.llReg.isClickable = false
        }

        if (aboutDone) {
            binding.cbAboutOneself.isChecked = true
            binding.llAboutOneself.isClickable = false
        }

        if (testDone) {
            binding.cbTest.isChecked = true
            binding.llTest.isClickable = false
        }

        if (skillsDone) {
            binding.cbSkills.isChecked = true
            binding.llSkills.isClickable = false
        }

        if (creativeDone) {
            binding.cbCreative.isChecked = true
            binding.llCreative.isClickable = false
        }

        if (regDone && aboutDone && testDone && skillsDone && creativeDone) {
            binding.btnContinue.isVisible = true
        }
    }

}