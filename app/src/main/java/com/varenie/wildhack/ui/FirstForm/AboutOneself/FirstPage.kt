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

class FirstPage: Fragment() {
    private var _binding: FragmentFirstPageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstPageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSaveAndNext.setOnClickListener {
            if (checkData()) {
                Navigation.findNavController(it).navigate(R.id.action_firstPage_to_secondPage)
            }
        }
        return root
    }

    private fun checkData(): Boolean {
        if (!binding.textInputLayout.text.isNullOrBlank()) {
            val table = FirstFormDAO(requireContext())

            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            val id = sharedPref.getInt("FormId", 0)

            table.addProfession(id, binding.textInputLayout.text.toString())

            return true
        }
        return false
    }
}