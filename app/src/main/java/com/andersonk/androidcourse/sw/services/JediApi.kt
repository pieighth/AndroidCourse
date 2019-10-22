package com.andersonk.androidcourse.sw.services

import com.andersonk.androidcourse.sw.models.People
import com.andersonk.androidcourse.sw.models.Peoples
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import retrofit2.http.Url


interface JediApi {

    @GET("people")
    fun getPeoples() : Call<Peoples>


    //@GET("people/{id}")
    @GET("{fullUrl}")
    fun getPeople(@Path(value = "fullUrl", encoded = true) fullUrl: String ) : Call<People>


}