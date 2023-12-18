package com.example.exam_5.fragment.NewCourses

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam_5.R
import com.example.exam_5.databinding.ItemNewCoursesBinding

class NewCoursesRecyclerAdapter :
    ListAdapter<NewCoursesType, NewCoursesRecyclerAdapter.NewCoursesViewHolder>(
        DiffUtilCallback()
    ) {

    inner class NewCoursesViewHolder(private val binding: ItemNewCoursesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = currentList[adapterPosition]
            with(binding) {
                tvTitle.text = item.title
                tvDuration.text = item.duration
                tvQuestion.text = item.question
                val backgroundColor = Color.parseColor("#${item.mainColor}")
                newCoursesContainer.setBackgroundColor(backgroundColor)
            }

            if (item.iconType == "settings") {
                binding.imgIcon.setImageResource(R.drawable.ic_settings)
            }


        }

    }

    private class DiffUtilCallback : DiffUtil.ItemCallback<NewCoursesType>() {
        override fun areItemsTheSame(
            oldItem: NewCoursesType,
            newItem: NewCoursesType
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NewCoursesType,
            newItem: NewCoursesType
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCoursesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewCoursesBinding.inflate(layoutInflater, parent, false)
        return NewCoursesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewCoursesViewHolder, position: Int) {
        holder.bind()
    }
}