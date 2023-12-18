package com.example.exam_5.fragment.NewCourses

import com.squareup.moshi.Json

data class NewCoursesType(
    val id: String,
    @Json(name = "icon_type")
    val iconType: String,
    val duration: String,
    val title: String,
    val question: String,
    @Json(name = "main_color")
    val mainColor: String
)


//        "id": "1",
//        "icon_type": "settings",
//        "duration": "43423",
//        "title": "Introduce",
//        "question": "What is it?",
//        "main_color": "3DD598"
//    }