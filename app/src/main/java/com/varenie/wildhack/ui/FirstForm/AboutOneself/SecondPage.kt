package com.varenie.wildhack.ui.FirstForm.AboutOneself

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentFirstPageBinding
import com.varenie.wildhack.databinding.FragmentSecondPageBinding

class SecondPage: Fragment() {
    private var _binding: FragmentSecondPageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondPageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSaveAndNext.setOnClickListener {
            if (checkData()) {
                Navigation.findNavController(it).navigate(R.id.action_secondPage_to_thirdPage)
            }
        }
        return root
    }

    private fun checkData(): Boolean {
        val edDistantPoint = binding.etDistantPlace
        val textLayout = binding.textInputLayout

        if (!edDistantPoint.text.isNullOrBlank() && !textLayout.text.isNullOrBlank()) {
            val table = FirstFormDAO(requireContext())

            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            val id = sharedPref.getInt("FormId", 0)

            table.addPointExperience(id, edDistantPoint.text.toString(), textLayout.text.toString())
            return true
        }

        return false
    }
}