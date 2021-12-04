package com.varenie.wildhack.ui.FirstForm.Skills

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentSaveRegAnswersBinding
import com.varenie.wildhack.databinding.FragmentSkillsHelloBinding

class save_skills_answers : Fragment() {
    private var _binding: FragmentSaveRegAnswersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSaveRegAnswersBinding.inflate(inflater, container, false)

        val root = binding.root

        binding.btnStartTest.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("RegDone", true)
                apply()
            }
            Navigation.findNavController(it).navigate(R.id.action_save_skills_answers_to_checkFragment)
        }
        return root
    }


}