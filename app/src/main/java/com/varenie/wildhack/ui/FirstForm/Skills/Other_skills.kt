package com.varenie.wildhack.ui.FirstForm.Skills

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentOtherSkillsBinding
import com.varenie.wildhack.databinding.FragmentYourselfSkillsBinding


class Other_skills : Fragment() {
    lateinit var binding: FragmentOtherSkillsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOtherSkillsBinding.inflate(inflater, container, false)

        binding.btnSaveAndNext.setOnClickListener {
            var addSkills = ""
            val edAddSkills = binding.textInputLayout

            if (!edAddSkills.text.isNullOrBlank()) {
                addSkills = edAddSkills.text.toString()
            }

            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context. MODE_PRIVATE)
            val id = sharedPref.getInt("FormId", 0)
            val result = sharedPref.getString("skills", "")

            with(sharedPref.edit()) {
                putBoolean("SkillsDone", true)
                apply()
            }

            addSkills = "$result$addSkills"

            val table = FirstFormDAO(requireContext())
            table.addHardSkills(id, addSkills)

            Navigation.findNavController(it).navigate(R.id.action_other_skills_to_checkFragment)
        }
        return binding.root
    }


}