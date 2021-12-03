package com.varenie.wildhack.ui.FirstForm.Registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
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

        val btnNext = binding.btnSaveAndNext
        btnNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_connect_to_navigation_living_place)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}