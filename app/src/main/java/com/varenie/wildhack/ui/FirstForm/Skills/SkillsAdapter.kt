package com.varenie.wildhack.ui.FirstForm.Skills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.varenie.wildhack.R

class SkillsAdapter: RecyclerView.Adapter<SkillsAdapter.SkillVH>() {
    val skill_list = arrayOf("Умею рисовать или занимаюсь каким-то рукоделием, вижу мир как художник",
        "Имею опыт и знания в развитии малого предпринимтельства")

    class SkillVH(view: View): RecyclerView.ViewHolder(view) {
        val cbSkill = view.findViewById<CheckBox>(R.id.cb_skills)

        fun bind(skill: String) {
            cbSkill.setText(skill)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skill_item, parent, false)

        return SkillVH(view)
    }

    override fun onBindViewHolder(holder: SkillVH, position: Int) {
        holder.bind(skill_list[position])
    }

    override fun getItemCount(): Int {
        return skill_list.size
    }
}