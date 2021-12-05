package com.varenie.wildhack.ui.Course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.varenie.wildhack.R


class ViewPagerAdapter(private var question: List<String>,
                       private var answer1: List<String>,
                       private var answer2: List<String>,
                       private var answer3: List<String>,
                       private var answer4: List<String>) :RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>(){
    inner class Pager2ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.tv_question_text)
        val answer1: CheckBox = itemView.findViewById(R.id.cb_1)
        val answer2: CheckBox = itemView.findViewById(R.id.cb_2)
        val answer3: CheckBox = itemView.findViewById(R.id.cb_3)
        val answer4: CheckBox = itemView.findViewById(R.id.cb_4)


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page,parent,false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitle.text=question[position]
        holder.answer1.text=answer1[position]
        holder.answer2.text=answer2[position]
        holder.answer3.text=answer3[position]
        holder.answer4.text=answer4[position]

    }

    override fun getItemCount(): Int {
        return question.size
    }
}