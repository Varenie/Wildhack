package com.varenie.wildhack.ui.FirstForm.Registration

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentLivingPlaceBinding

class LivingPlaceFragment : Fragment() {

    private var _binding: FragmentLivingPlaceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLivingPlaceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(it).apply {
                popBackStack()
            }
        }

        binding.btnSaveAndNext.setOnClickListener {
            if (checkData()) {
                val table = FirstFormDAO(requireContext())
                table.checkDB()

                Navigation.findNavController(it).navigate(R.id.action_navigation_living_place_to_save_skills_answers)
            }
        }
        return root
    }

    private fun checkData(): Boolean {
        val etLivingPlace = binding.etLivingPlace
        val cbPrivacy = binding.privacyPolicy

        if (!etLivingPlace.text.isNullOrBlank() && cbPrivacy.isChecked) {
            val table = FirstFormDAO(requireContext())

            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            val id = sharedPref.getInt("FormId", 0)

            table.addLivingPlacePrivacy(id, etLivingPlace.text.toString())
            return true
        }

        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}