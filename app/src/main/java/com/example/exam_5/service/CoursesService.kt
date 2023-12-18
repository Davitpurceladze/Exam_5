package com.example.exercise_18.service

import com.example.exam_5.fragment.CoursesDataType
import retrofit2.Response
import retrofit2.http.GET

interface CoursesService {

    @GET("83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getCoursesData(): Response<CoursesDataType>
}