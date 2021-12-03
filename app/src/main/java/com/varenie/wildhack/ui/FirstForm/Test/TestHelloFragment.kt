package com.varenie.wildhack.ui.FirstForm.Test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentCheckBinding
import com.varenie.wildhack.databinding.FragmentTestHelloBinding

class TestHelloFragment : Fragment() {
    private var _binding: FragmentTestHelloBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestHelloBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


}