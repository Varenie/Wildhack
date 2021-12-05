package com.varenie.wildhack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentFaqBinding


class Faq : Fragment() {
    var _binding: FragmentFaqBinding? = null
    val header : MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFaqBinding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_faq_to_helloFragment)
        }

        header.add("Вопрос 1")
        header.add("Вопрос 2")
        header.add("Вопрос 3")
        val answer1: MutableList<String> = ArrayList()
        answer1.add("Ответ 1")
        val answer2: MutableList<String> = ArrayList()
        answer2.add("Ответ 2")
        val answer3: MutableList<String> = ArrayList()
        answer3.add("Ответ 3")
        body.add(answer1)
        body.add(answer2)
        body.add(answer3)

        binding.expandableListView.setAdapter(EListViewAdapter(requireContext(),header,body))
        return binding.root
    }



}