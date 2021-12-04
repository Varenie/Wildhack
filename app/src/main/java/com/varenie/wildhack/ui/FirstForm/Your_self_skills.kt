package com.varenie.wildhack.ui.FirstForm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.ActivityMainBinding
import com.varenie.wildhack.databinding.FragmentYourselfSkillsBinding

class Your_self_skills : Fragment() {
    lateinit var binding: FragmentYourselfSkillsBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYourselfSkillsBinding.inflate(inflater, container, false)
        binding.rcView.setHasFixedSize(true)
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = Skill_adapter()

        // Inflate the layout for this fragment
        return binding.root
    }



}