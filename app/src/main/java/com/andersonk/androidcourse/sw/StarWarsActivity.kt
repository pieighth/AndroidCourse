package com.andersonk.androidcourse.sw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.sw.adapters.PeoplesAdapter
import com.andersonk.androidcourse.sw.models.People
import com.andersonk.androidcourse.sw.models.Peoples
import com.andersonk.androidcourse.sw.services.JediApi
import kotlinx.android.synthetic.main.activity_star_wars.*
import kotlinx.android.synthetic.main.content_stack.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class StarWarsActivity : AppCompatActivity() {

    val peoplesAdapter = PeoplesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_wars)
        val layoutManager = LinearLayoutManager(this)
        id_sw_rv.layoutManager = layoutManager
        id_sw_rv.adapter = peoplesAdapter

        getData()
    }

    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val jediApi = retrofit.create<JediApi>(JediApi::class.java)

        val call = jediApi.getPeoples()

        call.enqueue(object: Callback<Peoples>{
            override fun onFailure(call: Call<Peoples>, t: Throwable) {
                Log.d("NETWORK",t.message)
            }

            override fun onResponse(call: Call<Peoples>, response: Response<Peoples>) {
                Log.d("NETWORK", response.code().toString())
                when (response.code()){
                    200 -> {
                        val body = response.body()
                        body?.let{
                            Log.d("NETWORK", response.body().toString())
                            peoplesAdapter.setPeoples(it.results as MutableList<People>)
                        }
                    }
                    204 -> Log.d("NETWORK", "Deu ruim pra caramba(204)")

                }
            }

        }
        )
    }
}
