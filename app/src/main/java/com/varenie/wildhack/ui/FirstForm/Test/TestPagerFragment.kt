package com.varenie.wildhack.ui.FirstForm.Test

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentTestPagerBinding
import com.varenie.wildhack.databinding.FragmentTestWorkPieceBinding

class TestPagerFragment : Fragment() {
    private var _binding: FragmentTestPagerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestPagerBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.testPager.adapter = TestPagerAdapter(requireContext())

        return root
    }

    override fun onResume() {
        super.onResume()


    }

}