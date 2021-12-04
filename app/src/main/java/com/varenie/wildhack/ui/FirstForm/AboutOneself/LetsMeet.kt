package com.varenie.wildhack.ui.FirstForm.AboutOneself

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentCheckBinding
import com.varenie.wildhack.databinding.FragmentLetsMeetBinding

class LetsMeet : Fragment() {
    private var _binding: FragmentLetsMeetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLetsMeetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnStartTest.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_letsMeet_to_firstPage)
        }

        return root
    }

}