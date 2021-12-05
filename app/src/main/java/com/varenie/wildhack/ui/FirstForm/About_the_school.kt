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
import com.varenie.wildhack.databinding.FragmentCheckBinding

class About_the_school : Fragment() {
    private var _binding: FragmentAboutTheSchoolBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutTheSchoolBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnStartForm.setOnClickListener {
            var result = ""

            binding.cbSocialNetwork.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    result = binding.cbSocialNetwork.text.toString()
                    binding.cdDobroRu.isChecked = false
                    binding.cbGoodSurfing.isChecked = false
                    binding.cbGreenBoard.isChecked = false
                    binding.cbFromFriends.isChecked = false
                    binding.cbOther.isChecked = false
                }
            }

            binding.cdDobroRu.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    result = binding.cdDobroRu.text.toString()
                    binding.cbSocialNetwork.isChecked = false
                    binding.cbGoodSurfing.isChecked = false
                    binding.cbGreenBoard.isChecked = false
                    binding.cbFromFriends.isChecked = false
                    binding.cbOther.isChecked = false
                }
            }

            binding.cbGoodSurfing.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    result = binding.cbGoodSurfing.text.toString()
                    binding.cdDobroRu.isChecked = false
                    binding.cbSocialNetwork.isChecked = false
                    binding.cbGreenBoard.isChecked = false
                    binding.cbFromFriends.isChecked = false
                    binding.cbOther.isChecked = false
                }
            }

            binding.cbGreenBoard.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    result = binding.cbGreenBoard.text.toString()
                    binding.cdDobroRu.isChecked = false
                    binding.cbGoodSurfing.isChecked = false
                    binding.cbSocialNetwork.isChecked = false
                    binding.cbFromFriends.isChecked = false
                    binding.cbOther.isChecked = false
                }
            }

            binding.cbFromFriends.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    result = binding.cbFromFriends.text.toString()
                    binding.cdDobroRu.isChecked = false
                    binding.cbGoodSurfing.isChecked = false
                    binding.cbGreenBoard.isChecked = false
                    binding.cbSocialNetwork.isChecked = false
                    binding.cbOther.isChecked = false
                }
            }

            binding.cbOther.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    result = binding.etOther.text.toString()
                    binding.cdDobroRu.isChecked = false
                    binding.cbGoodSurfing.isChecked = false
                    binding.cbGreenBoard.isChecked = false
                    binding.cbFromFriends.isChecked = false
                    binding.cbSocialNetwork.isChecked = false
                }
            }

            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            val id = sharedPref.getInt("FormId", 0)

            val table = FirstFormDAO(requireContext())
            table.addAboutSchool(id, result)

            Navigation.findNavController(it).navigate(R.id.action_about_the_school_to_dataAgreement)

        }
        return root
    }


}