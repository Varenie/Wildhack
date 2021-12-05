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

        header.add("Озерный")
        header.add("Травяной")
        header.add("Долина гейзеров")
        val answer1: MutableList<String> = ArrayList()
        answer1.add("Для женщин-волонтеров предусмотрены\n" +
                "следующие виды работ: уборка в туалетах,\n" +
                "душевых, бане. Помощь на кухне: \n" +
                "приготовление пищи, мытье полов и посуды.\n" +
                "Уборка модулей после туристов. Малярные \n" +
                "работы.\n" +
                "Мытье окон.\n" +
                "Мужчины-волонтеры выполняют \n" +
                "следующие виды работ: сжигание \n" +
                "мусора, помощь в строительных и \n" +
                "хозяйственных работах. Погрузка\\разгрузка \n" +
                "вертолетов. Очистка туристических троп.\n" +
                "На Камчат-НИРО проводится очищение\n" +
                "рыбоучетного заграждения.")
        val answer2: MutableList<String> = ArrayList()
        answer2.add("Вид работ добровольцев такой же как на \n" +
                "Озерном. ")
        val answer3: MutableList<String> = ArrayList()
        answer3.add("Долину гейзеров ежедневно посещают десятки\n" +
                "туристов, поэтому работы для добровольцев \n" +
                "очень много. Девушки будут заняты уборкой \n" +
                "помещений (жилых комнат, кухни-столовой, \n" +
                "туалетов), помогать повару на кухне, заниматься\n" +
                "продажей сувенирной продукции. Мужчины \n" +
                "разгружают/загружают вертолеты, ремонтируют\n" +
                "вертолетные площадки, настильные тропы,\n" +
                "сжигают мусор и задействуются во всех \n" +
                "хозяйственных и строительных работах. ")
        body.add(answer1)
        body.add(answer2)
        body.add(answer3)

        binding.expandableListView.setAdapter(EListViewAdapter(requireContext(),header,body))
        return binding.root
    }

}