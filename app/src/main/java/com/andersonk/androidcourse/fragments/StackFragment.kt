package com.andersonk.androidcourse.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.adapters.QuestionAdapter
import com.andersonk.androidcourse.models.Question
import com.andersonk.androidcourse.models.QuestionList
import com.andersonk.androidcourse.services.Api
import kotlinx.android.synthetic.main.stack_fragments.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class StackFragment : Fragment() {

    val questionAdapter = QuestionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.stack_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
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

        val valor = "desc"


        val call = service.getQuestions(
            mapOf(
                "order" to valor,
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
}