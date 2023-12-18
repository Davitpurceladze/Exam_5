package com.example.exercise_18.network

import com.example.exercise_18.service.CoursesService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {

//    base url
    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
// function which creates retrofit object based on service
//    https://run.mocky.io/v3/83160a49-fe85-46ba-bcf8-3cf5aa09f92b
    fun getCoursesData(): CoursesService = retrofit.create(CoursesService::class.java)
}

//{
//    "new_courses": [
//    {
//        "id": "1",
//        "icon_type": "settings",
//        "duration": "43423",
//        "title": "Introduce",
//        "question": "What is it?",
//        "main_color": "3DD598"
//    },
//    {
//        "id": "2",
//        "icon_type": "card",
//        "duration": "43423",
//        "title": "Introduce",
//        "question": "What is it?",
//        "main_color": "FF565E"
//    },
//    {
//        "id": "3",
//        "icon_type": "card",
//        "duration": "43423",
//        "title": "Android",
//        "question": "What is it?",
//        "main_color": "FF565E"
//    }
//    ],
//    "active_courses": [
//    {
//        "id": "1",
//        "booking_time": "8 PM",
//        "progress": "87",
//        "title": "Android",
//        "main_color": "3DD598",
//        "background_color_present": "50",
//        "play_button_color_present": "60",
//        "image": "https://w7.pngwing.com/pngs/732/115/png-transparent-brand-logos-android-android-logo-grass-social-media.png"
//    },
//    {
//        "id": "2",
//        "booking_time": "8 AM",
//        "progress": "50",
//        "title": "IOS",
//        "main_color": "FFC542",
//        "background_color_present": "52",
//        "play_button_color_present": "63",
//        "image": "https://www.pinclipart.com/picdir/middle/571-5713706_transparent-ios-logo-png-clipart.png"
//    },
//    {
//        "id": "3",
//        "booking_time": "11 PM",
//        "progress": "20",
//        "title": "Jemala Course",
//        "main_color": "FF565E",
//        "background_color_present": "52",
//        "play_button_color_present": "63",
//        "image": "https://pbs.twimg.com/profile_images/955338390395813888/IgxoQ7po.jpg"
//    }
//    ]
//}
