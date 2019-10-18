package com.andersonk.androidcourse

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.adapters.QuestionAdapter
import com.andersonk.androidcourse.models.Question
import com.andersonk.androidcourse.models.QuestionList
import com.andersonk.androidcourse.services.Api

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class MainActivity : AppCompatActivity() {

    val questionAdapter = QuestionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        val layoutManager = LinearLayoutManager(this)
        recycler_question.layoutManager = layoutManager
        recycler_question.adapter = questionAdapter

        getData()
    }

    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/2.2/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val service = retrofit.create<Api>(Api::class.java)

        val call = service.getQuestions(
            mapOf(
                "order" to "desc",
                "sort" to "activity",
                "site" to "stackoverflow"
            )
        )

        call.enqueue(object: Callback<QuestionList> {
            override fun onFailure(call: Call<QuestionList>, t: Throwable) {
                Log.d("NETWORK", t.toString())
            }

            override fun onResponse(call: Call<QuestionList>, response: Response<QuestionList>) {
                when(response.code()){
                    200 ->{
                        val body = response.body()
                        body?.let {
                            questionAdapter.setQuestions(it.items as MutableList<Question>)
                        }
                    }
                    204 -> {
                        Log.d("NETWORK", "Ta vazio irmao")
                    }

                }
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
