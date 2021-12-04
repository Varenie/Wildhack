package com.varenie.wildhack.ui.FirstForm.Registration

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.varenie.wildhack.Database.DAO.FirstFormDAO
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentConnectBinding

class ConnectFragment : Fragment() {

    private var _binding: FragmentConnectBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentConnectBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.btnSaveAndNext.setOnClickListener {
            if(checkData()) {
                val table = FirstFormDAO(requireContext())
                table.checkDB()

                Navigation.findNavController(it)
                    .navigate(R.id.action_navigation_connect_to_navigation_living_place)
            }
        }
        binding.btnBack.setOnClickListener {
            Navigation.findNavController(it).apply {
                popBackStack()
            }
        }

        return root
    }

    private fun checkData(): Boolean {
        val etEmail = binding.etEmail
        val etSocialNetwork = binding.etSocialNetwork
        val etPhone = binding.etPhone

        if (!etEmail.text.isNullOrBlank() && !etSocialNetwork.text.isNullOrBlank() && !etPhone.text.isNullOrBlank()) {
            val table = FirstFormDAO(requireContext())

            val sharedPref = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            val id = sharedPref.getInt("FormId", 0)

            table.addMailSocilaPhone(id,
                etEmail.text.toString(),
                etSocialNetwork.text.toString(),
                etPhone.text.toString())
            return true
        }

        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}