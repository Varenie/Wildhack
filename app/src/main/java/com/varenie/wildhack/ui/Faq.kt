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
            Navigation.findNavController(it).apply { popBackStack() }
        }

        header.add("Когда начинается приём заявок?")
        header.add("Какие сроки выполнения работ?")
        header.add("Связь на кордонах?")
        val answer1: MutableList<String> = ArrayList()
        answer1.add("Прием заявок на 2022 год начинается с 05.12.2021 год")
        val answer2: MutableList<String> = ArrayList()
        answer2.add("Минимальный срок работы на охраняемых территориях-3 недели.")
        val answer3: MutableList<String> = ArrayList()
        answer3.add("На всех кордонах есть электрогенераторы и солнечные батареи, то есть, возможность заряжать гаджеты у вас будет.\n" +
                "Сотовой связи нет нигде. На многих кордонах утром и вечером есть интернет (очень медленный, но весточку родным\n" +
                "отправить возможно).")
        body.add(answer1)
        body.add(answer2)
        body.add(answer3)

        binding.expandableListView.setAdapter(EListViewAdapter(requireContext(),header,body))
        return binding.root
    }



}