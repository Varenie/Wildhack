package com.varenie.wildhack.ui.FirstForm.Test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.varenie.wildhack.databinding.FragmentTestWorkPieceBinding

class TestPagerAdapter: RecyclerView.Adapter<TestPagerAdapter.PagerVH>() {
    var _binding: FragmentTestWorkPieceBinding? = null
    private val binding get() = _binding!!

    private val questions = arrayOf(
        "Легко переношу полевые условия, холод, неудобство, комаров и прочее.",
        "Предпочитаю находиться в одиночестве, а не в шумной компании.",
        "Люблю быть лидером, хочу менять мир и вести людей за собой!",
        "Могу и люблю работать физически. Не боюсь поднимать тяжести или испачкать одежду.")

    class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        val inflater = LayoutInflater.from(parent.context)
        _binding = FragmentTestWorkPieceBinding.inflate(inflater, parent, false)

        return PagerVH(binding.root)
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        binding.tvQuestionText.text = questions[position]
        binding.tvPage.text = "${position+1}/${questions.size}"
    }

    override fun getItemCount(): Int {
        return questions.size
    }


}