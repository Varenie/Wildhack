package com.varenie.wildhack.ui.Course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentFinalTestBinding
import com.varenie.wildhack.databinding.FragmentSkillsHelloBinding
import com.varenie.wildhack.databinding.FragmentYourselfSkillsBinding
import com.varenie.wildhack.ui.FirstForm.SkillsAdapter


class final_test : Fragment() {
    lateinit var binding: FragmentFinalTestBinding
    private var questions = mutableListOf<String>()
    private var answers1 = mutableListOf<String>()
    private var answers2 = mutableListOf<String>()
    private var answers3 = mutableListOf<String>()
    private var answers4 = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        postToList()
        binding = FragmentFinalTestBinding.inflate(inflater, container, false)

        binding.viewPager2.adapter= ViewPagerAdapter(questions,answers1,answers2,answers3,answers4)
        binding.indicator.setViewPager(binding.viewPager2)


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun addToList(question: String, answer1: String, answer2: String, answer3: String, answer4: String){
        questions.add(question)
        answers1.add(answer1)
        answers2.add(answer2)
        answers3.add(answer3)
        answers4.add(answer4)
    }


    private fun postToList(){
        addToList("Как жить","сложно", "легко", "нормально", "странно")
        addToList("Как жить","сложно", "легко", "нормально", "странно")
        addToList("Как жить","сложно", "легко", "нормально", "странно")
    }
}