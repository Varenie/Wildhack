package com.varenie.wildhack.ui.FirstForm

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

        val reglayout = binding.llReg
        reglayout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_checkFragment_to_navigation_main_data)
        }
        return root
    }

}