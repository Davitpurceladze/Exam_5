package com.example.exam_5.fragment.activeCourses

import com.squareup.moshi.Json

data class ActiveCoursesType(
    val id: String,
    @Json(name ="booking_time")
    val bookingTime: String,
    val progress: String,
    val title: String,
    @Json(name ="main_color")
    val mainColor: String,
    @Json(name ="background_color_present")
    val backgroundColorPresent: String,
    @Json(name ="play_button_color_present")
    val playButtonColorPresent: String,
    val image: String
)

//        "id": "1",
//        "booking_time": "8 PM",
//        "progress": "87",
//        "title": "Android",
//        "main_color": "3DD598",
//        "background_color_present": "50",
//        "play_button_color_present": "60",
//        "image": "https://w7.pngwing.com/pngs/732/115/png-transparent-brand-logos-android-android-logo-grass-social-media.png"
//    }