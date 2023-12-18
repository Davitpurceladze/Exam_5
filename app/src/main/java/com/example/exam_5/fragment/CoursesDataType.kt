package com.example.exam_5.fragment

import com.example.exam_5.fragment.NewCourses.NewCoursesType
import com.example.exam_5.fragment.activeCourses.ActiveCoursesType
import com.squareup.moshi.Json

data class CoursesDataType(
    @Json(name = "new_courses")
    val newCoursesType: List<NewCoursesType>,
    @Json(name = "active_courses")
    val activeCourses: List<ActiveCoursesType>
)
