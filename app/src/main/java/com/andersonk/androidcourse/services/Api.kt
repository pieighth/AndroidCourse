package com.anderson.jsonparser.services

import com.andersonk.androidcourse.models.QuestionList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface Api {
    @GET("questions")
    fun getBadges(@QueryMap params: Map<String, String>): Call<QuestionList>
}