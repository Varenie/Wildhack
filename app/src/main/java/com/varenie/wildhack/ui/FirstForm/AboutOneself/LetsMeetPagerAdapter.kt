package com.varenie.wildhack.ui.FirstForm.AboutOneself

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.varenie.wildhack.databinding.FragmentFirstPageBinding
import com.varenie.wildhack.databinding.FragmentMeetWorkPieceBinding
import com.varenie.wildhack.databinding.FragmentSecondPageBinding
import com.varenie.wildhack.databinding.FragmentTestWorkPieceBinding

class LetsMeetPagerAdapter: RecyclerView.Adapter<LetsMeetPagerAdapter.PagerVH>() {
    var bindingMeetWorkPiece: FragmentMeetWorkPieceBinding? = null
    var bindingFirstPage: FragmentFirstPageBinding? = null
    var bindingSecondPage: FragmentSecondPageBinding? = null

    class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LetsMeetPagerAdapter.PagerVH {

       val view = when (viewType) {
            0 -> {
                bindingFirstPage = FragmentFirstPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                bindingFirstPage?.root
            }
            1 -> {
                bindingSecondPage = FragmentSecondPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                bindingSecondPage?.root
            }
            else -> {
                bindingMeetWorkPiece = FragmentMeetWorkPieceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                bindingMeetWorkPiece?.root
            }
        }

        return PagerVH(view!!.rootView)
    }

    override fun onBindViewHolder(holder: LetsMeetPagerAdapter.PagerVH, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }
}