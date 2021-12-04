package com.varenie.wildhack.ui.FirstForm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.SkillItemBinding

class Skill_adapter:RecyclerView.Adapter<Skill_adapter.Skill_Holder>() {
    val skill_list = arrayOf("Умею рисовать или занимаюсь каким-то рукоделием, вижу мир как художник",
        "Имею опыт и знания в развитии малого предпринимтельства")
    class Skill_Holder(item: View): RecyclerView.ViewHolder(item) {
        //val binding = SkillItemBinding.bind(item)
        val cbSkills = item.findViewById<CheckBox>(R.id.cb_skills)
        fun bind(skill: String){
            cbSkills.text=skill
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Skill_Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skill_item, parent,false)
        return Skill_Holder(view)
    }

    override fun onBindViewHolder(holder: Skill_Holder, position: Int) {
        holder.bind(skill_list[position])
    }

    override fun getItemCount(): Int {
        return skill_list.size
    }

}