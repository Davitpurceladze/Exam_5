package com.example.exam_5.fragment

import android.content.Context
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.exam_5.BaseFragment
import com.example.exam_5.databinding.FragmentActiveCoursesBinding
import com.example.exam_5.fragment.NewCourses.NewCoursesRecyclerAdapter
import com.example.exam_5.fragment.activeCourses.ActiveCoursesFragmentViewModel
import com.example.exam_5.fragment.activeCourses.ActiveCoursesRecyclerAdapter
import kotlinx.coroutines.launch

class CoursesFragment : BaseFragment<FragmentActiveCoursesBinding>(FragmentActiveCoursesBinding::inflate) {

    private val viewModel: ActiveCoursesFragmentViewModel by viewModels()
    override fun setUp() {
        viewModel.getData()

    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                 viewModel.activeCoursesFlow.collect{
                     val adapter = ActiveCoursesRecyclerAdapter()
                     adapter.submitList(it)
                     binding.rvActiveCourses.adapter = adapter

                 }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.newCoursesFlow.collect{
                    val adapter = NewCoursesRecyclerAdapter()
                    adapter.submitList(it)
                    binding.rvNewCourses.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
                    binding.rvNewCourses.adapter = adapter
                }
            }
        }
    }
}