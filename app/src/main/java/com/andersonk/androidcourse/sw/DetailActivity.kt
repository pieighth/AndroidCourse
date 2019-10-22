package com.andersonk.androidcourse.sw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.sw.models.People
import com.andersonk.androidcourse.sw.services.JediApi
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.*
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.Url as Retrofit2HttpUrl

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val peopleUrl = intent.getStringExtra("people")
        peopleUrl?.let{
            detail_url.text = it
            getData(it)
        }
    }


    fun getData(url: String){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val jediApi = retrofit.create<JediApi>(JediApi::class.java)
        val call = jediApi.getPeople(url)


        call.enqueue(object: Callback<People>{
            override fun onFailure(call: Call<People>, t: Throwable) {
                Log.d("NETWORK", "Deu ruim")
            }

            override fun onResponse(call: Call<People>, response: Response<People>) {
                when (response.code()){
                    200 ->{
                        val body = response.body()
                        body?.let {
                            detail_name.text = it.name
                        }
                    }
                }
            }

        })
    }
}
