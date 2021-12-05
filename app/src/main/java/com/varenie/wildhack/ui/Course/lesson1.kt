package com.varenie.wildhack.ui.Course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentLesson1Binding
import com.varenie.wildhack.databinding.FragmentTutorialsBinding

class lesson1 : Fragment() {
    private var _binding: FragmentLesson1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLesson1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(it).apply {
                popBackStack()
            }
        }

        return root
    }

}