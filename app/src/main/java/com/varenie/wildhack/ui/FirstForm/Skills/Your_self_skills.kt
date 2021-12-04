package com.varenie.wildhack.ui.FirstForm.Skills

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentYourselfSkillsBinding
import com.varenie.wildhack.ui.FirstForm.SkillsAdapter


class Your_self_skills : Fragment() {
    lateinit var binding: FragmentYourselfSkillsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYourselfSkillsBinding.inflate(inflater, container, false)

        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.setHasFixedSize(true)
        val adapter = SkillsAdapter()
        binding.rcView.adapter = adapter

        binding.btnSaveAndNext.setOnClickListener {
            val result = adapter.getResult()

            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("skills", result)
                apply()
            }

            Navigation.findNavController(it).navigate(R.id.action_your_self_skills_to_other_skills)
        }

        // Inflate the layout for this fragment
        return binding.root
    }




}