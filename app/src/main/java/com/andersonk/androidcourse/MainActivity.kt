package com.andersonk.androidcourse

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anderson.jsonparser.services.Api
import com.andersonk.androidcourse.adapters.QuestionAdapter
import com.andersonk.androidcourse.models.QuestionList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var questionAdapter: QuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        questionAdapter = QuestionAdapter()


        val layoutManager = LinearLayoutManager(this)

        recycler_questions.layoutManager = layoutManager
        recycler_questions.adapter = questionAdapter

        getData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun getData() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/2.2/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val service = retrofit.create<Api>(Api::class.java)

        val call = service.getBadges(
            mapOf(
                "order" to "desc",
                "sort" to "activity",
                "site" to "stackoverflow"
            )
        )

        call.enqueue(object : Callback<QuestionList> {

            override fun onFailure(call: Call<QuestionList>, t: Throwable) {
                Log.d("NETWORK", t.toString())
            }

            override fun onResponse(call: Call<QuestionList>, response: Response<QuestionList>) {
                when (response.code()) {
                    200 -> {

                        var body = response.body()
                        body?.let {
                            questionAdapter.setData(it.items)
                        }
                    }
                    204 -> Log.d("NETWORK", "Not content")
                }
            }
        })
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
