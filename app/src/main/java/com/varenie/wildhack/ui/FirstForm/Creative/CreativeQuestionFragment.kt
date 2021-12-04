package com.varenie.wildhack.ui.FirstForm.Creative

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentCreativeQuestionBinding

class CreativeQuestionFragment : Fragment() {
    private var _binding: FragmentCreativeQuestionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreativeQuestionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(it).apply {
                popBackStack()
            }
        }

        val cbYes = binding.cbYes
        val cbNo = binding.cbNo

        cbYes.setOnCheckedChangeListener { compoundButton, b ->
            if (cbYes.isChecked) {
                cbNo.isChecked = false
            }
        }
        cbNo.setOnCheckedChangeListener { compoundButton, b ->
            if (cbNo.isChecked) {
                cbYes.isChecked = false
            }
        }

        binding.btnFinish.setOnClickListener {
            cbYes.setOnCheckedChangeListener { compoundButton, b ->
                var isPublish = false
                if (b) {
                    isPublish = true
                }

                val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                val id = sharedPref.getInt("FormId", 0)

                with(sharedPref.edit()) {
                    putBoolean("CreativeDone", true)
                    apply()
                }

                val table = FirstFormDAO(requireContext())
                table.addPublish(id, isPublish.toString())

                Navigation.findNavController(it).navigate(R.id.action_creativeQuestion_to_checkFragment)
            }
        }
        return root
    }

}