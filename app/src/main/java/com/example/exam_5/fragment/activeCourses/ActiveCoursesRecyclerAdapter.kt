package com.example.exam_5.fragment.activeCourses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam_5.databinding.ItemActiveCoursesBinding

class ActiveCoursesRecyclerAdapter :
    ListAdapter<ActiveCoursesType, ActiveCoursesRecyclerAdapter.RecyclerActiveCoursesViewHolder>(
        DiffUtilCallback()
    ) {



    inner class RecyclerActiveCoursesViewHolder(private val binding: ItemActiveCoursesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = currentList[adapterPosition]
            with(binding) {
                etTitle.text = item.title
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerActiveCoursesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActiveCoursesBinding.inflate(layoutInflater, parent, false)
        return RecyclerActiveCoursesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerActiveCoursesViewHolder, position: Int) {
        holder.bind()
    }

    private class DiffUtilCallback : DiffUtil.ItemCallback<ActiveCoursesType>() {
        override fun areItemsTheSame(
            oldItem: ActiveCoursesType,
            newItem: ActiveCoursesType
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ActiveCoursesType,
            newItem: ActiveCoursesType
        ): Boolean {
            return oldItem == newItem
        }
    }
}