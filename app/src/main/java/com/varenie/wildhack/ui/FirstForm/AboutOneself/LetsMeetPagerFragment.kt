package com.varenie.wildhack.ui.FirstForm.AboutOneself

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.varenie.wildhack.databinding.FragmentLetsMeetPagerBinding


class LetsMeetPagerFragment : Fragment() {
    private var _binding: FragmentLetsMeetPagerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLetsMeetPagerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.letsMeetPager.adapter = LetsMeetPagerAdapter()

        return root
    }


}