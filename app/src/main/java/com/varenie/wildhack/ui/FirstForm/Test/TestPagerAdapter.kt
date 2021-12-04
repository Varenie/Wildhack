package com.varenie.wildhack.ui.FirstForm.Test

import android.content.Context
import android.view.ContentInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.varenie.wildhack.R
import com.varenie.wildhack.databinding.FragmentTestWorkPieceBinding

class TestPagerAdapter(val context: Context): RecyclerView.Adapter<TestPagerAdapter.PagerVH>() {
    var _binding: FragmentTestWorkPieceBinding? = null
    private val binding get() = _binding!!

    private val questions = arrayOf(
        "Легко переношу полевые условия, холод, неудобство, комаров и прочее.",
        "Предпочитаю находиться в одиночестве, а не в шумной компании.",
        "Люблю быть лидером, хочу менять мир и вести людей за собой!",
        "Могу и люблю работать физически. Не боюсь поднимать тяжести или испачкать одежду.")

    private var testQuery = ""
    class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        val inflater = LayoutInflater.from(parent.context)
        _binding = FragmentTestWorkPieceBinding.inflate(inflater, parent, false)

        return PagerVH(binding.root)
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        binding.tvQuestionText.text = questions[position]
        binding.tvPage.text = "${position+1}/${questions.size}"

        val cbYes = binding.cbYes
        val cbNo = binding.cbNo

        if (cbYes.isChecked) {
            if (position == 0) {
                testQuery = "true"
            }

            testQuery = "$testQuery;true"


            if (position == questions.size - 1) {
                val sharedPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putBoolean("TestDone", true)
                    apply()
                }
                Navigation.findNavController(cbYes).navigate(R.id.action_testPagerFragment_to_checkFragment)
            }

        }

        if (cbNo.isChecked) {
            if (position == 0) {
                testQuery = "false"
            }

            testQuery = "$testQuery;false"


            if (position == questions.size - 1) {
                val sharedPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putBoolean("TestDone", true)
                    apply()
                }
                Navigation.findNavController(cbNo).navigate(R.id.action_testPagerFragment_to_checkFragment)
            }
        }


//        if (position == questions.size - 1)
    }

    override fun getItemCount(): Int {
        return questions.size
    }


}