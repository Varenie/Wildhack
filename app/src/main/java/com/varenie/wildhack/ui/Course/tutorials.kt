package com.varenie.wildhack.ui.Course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentFirstPageBinding
import com.varenie.wildhack.databinding.FragmentLetsMeetBinding
import com.varenie.wildhack.databinding.FragmentTutorialsBinding

class tutorials : Fragment() {
    private var _binding: FragmentTutorialsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorialsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(it).apply { popBackStack() }
        }

        binding.llReg1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_tutorials_to_lesson1)
        }

        binding.llReg2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_tutorials_to_lesson1)
        }

        binding.llReg3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_tutorials_to_lesson1)
        }

        binding.llTest.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_tutorials_to_final_test)
        }
        return root
    }


}