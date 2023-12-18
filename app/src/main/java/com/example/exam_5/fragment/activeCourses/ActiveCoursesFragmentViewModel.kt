package com.example.exam_5.fragment.activeCourses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam_5.fragment.NewCourses.NewCoursesType
import com.example.exercise_18.network.Network
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ActiveCoursesFragmentViewModel: ViewModel() {

    private val _activeCoursesFlow = MutableStateFlow<List<ActiveCoursesType>?>(null)
    val activeCoursesFlow: SharedFlow<List<ActiveCoursesType>?> get() = _activeCoursesFlow

    private val _newCoursesFlow = MutableStateFlow<List<NewCoursesType>?>(null)
    val newCoursesFlow: SharedFlow<List<NewCoursesType>?> get() = _newCoursesFlow

    fun getData() {

        viewModelScope.launch {
            val response = Network.getCoursesData().getCoursesData()
            println(response.body())
            _activeCoursesFlow.value = response.body()!!.activeCourses
            _newCoursesFlow.value = response.body()!!.newCoursesType
        }

    }

}