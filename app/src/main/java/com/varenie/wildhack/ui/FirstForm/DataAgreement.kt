package com.varenie.wildhack.ui.FirstForm

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentAboutTheSchoolBinding
import com.varenie.wildhack.databinding.FragmentDataAgreementBinding

class DataAgreement : Fragment() {
    private var _binding: FragmentDataAgreementBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataAgreementBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.cbYes.setOnCheckedChangeListener { compoundButton, b ->
            if (binding.cbYes.isChecked) {
                binding.cbNo.isChecked = false
            }
        }
        binding.cbNo.setOnCheckedChangeListener { compoundButton, b ->
            if (binding.cbNo.isChecked) {
                binding.cbYes.isChecked = false
            }
        }

        binding.btnFinish.setOnClickListener {
            var isAgree = ""

            if (binding.cbYes.isChecked || binding.cbNo.isChecked) {
                if (binding.cbYes.isChecked) {
                    isAgree = "true"
                }
                if (binding.cbNo.isChecked) {
                    isAgree = "false"
                }

                val sharedPref =
                    requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                val id = sharedPref.getInt("FormId", 0)

                val table = FirstFormDAO(requireContext())
                table.addCollectionData(id, isAgree)

                Navigation.findNavController(it).navigate(R.id.action_dataAgreement_to_complete)
            }
        }
        return root
    }
}