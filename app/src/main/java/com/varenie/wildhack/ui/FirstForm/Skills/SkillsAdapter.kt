package com.varenie.wildhack.ui.FirstForm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.SkillItemBinding

class SkillsAdapter:RecyclerView.Adapter<SkillsAdapter.Skill_Holder>() {
    val skill_list = arrayOf("Умею рисовать или занимаюсь каким-то рукоделием, вижу мир как художник",
        "Имею опыт и знания в развитии малого предпринимательства",
        "Виртуозно  управляюсь с киркой и лопатой. Или просто умею работатть с инструментом",
        "Люблю разрешать конфликтные ситуации зная, что правда на моей стороне",
        "Околопрофессионально фотографирую и/или снимаю видео",
        "Свободно и грамотно говорю, уверенно держусь на публике",
        "Умею управлять дроном",
        "Имею опыт в проектной деятельности: придумал видео, собрал команду, нашёл ресурсы и воплотил",
        "Умею зажечь других людей своей идеей",
        "Имею опыт и знания в социологии, урбанистике, развитии территорий",
        "Имею допуск к работе с бензопилой",
        "Свободно говорю на английском"
    )
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