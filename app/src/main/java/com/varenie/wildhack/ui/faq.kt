package com.varenie.wildhack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import com.varenie.wildhack.R


class faq : Fragment() {
    private lateinit var listViewAdapter: eListViewAdapter
    private lateinit var chapterList: List<String>
    private lateinit var topicList: HashMap<String,List<String>>
    private lateinit var eListView: ExpandableListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showList()
        eListView = view?.findViewById(R.id.eListView)!!
        listViewAdapter = eListViewAdapter(requireContext(), chapterList,topicList)
        eListView.setAdapter(listViewAdapter)
        // Inflate the layout for this fragment
        return eListView
    }

    private fun showList() {
        chapterList = ArrayList()
        topicList = HashMap()
        (chapterList as ArrayList<String>).add("Вопрос 1")
        (chapterList as ArrayList<String>).add("Вопрос 2")
        (chapterList as ArrayList<String>).add("Вопрос 3")

        val topic1 : MutableList<String> = ArrayList()
        topic1.add("Необходимо пройти регистрацию")
        val topic2 : MutableList<String> = ArrayList()
        topic2.add("Необходимо заполнить анкету")
        val topic3 : MutableList<String> = ArrayList()
        topic3.add("Необходимо пройти тест")

        topicList[chapterList[0]]=topic1
        topicList[chapterList[1]]=topic2
        topicList[chapterList[2]]=topic3


    }

}