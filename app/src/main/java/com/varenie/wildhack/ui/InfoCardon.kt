package com.varenie.wildhack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentFaqBinding
import com.varenie.wildhack.databinding.FragmentInfoCardonBinding

class InfoCardon : Fragment() {
    var _binding: FragmentInfoCardonBinding? = null
    val header : MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoCardonBinding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(it).apply { popBackStack() }
        }

        header.add("Связь и электричество")
        header.add("Здоровье")
        header.add("Питание")
        val answer1: MutableList<String> = ArrayList()
        answer1.add("На всех кордонах есть электрогенераторы и солнечные батареи, то есть, возможность заряжать гаджеты у вас будет.\n" +
                "Сотовой связи нет нигде. На многих кордонах утром и вечером есть интернет (очень медленный, но весточку родным\n" +
                "отправить возможно).")
        val answer2: MutableList<String> = ArrayList()
        answer2.add("Смерть")
        val answer3: MutableList<String> = ArrayList()
        answer3.add("Лучший шведский стол в мире")
        body.add(answer1)
        body.add(answer2)
        body.add(answer3)

        binding.expandableListView.setAdapter(EListViewAdapter(requireContext(),header,body))
        return binding.root
    }

}