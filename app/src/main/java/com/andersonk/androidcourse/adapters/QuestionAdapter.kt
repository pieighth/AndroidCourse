package com.andersonk.androidcourse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.models.Question
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.question_item.view.*

class QuestionAdapter: RecyclerView.Adapter<QuestionAdapter.QuestionHolder>() {

    val questions = mutableListOf<Question>()


    fun  setQuestions(questions : MutableList<Question>){
        this.questions.addAll(questions)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater
            .inflate(R.layout.question_item, parent, false)
        return QuestionHolder(view)
    }

    override fun getItemCount(): Int {
        return  questions.size
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {

        holder.setQuestion(questions[position])
    }

    class QuestionHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun setQuestion(question: Question){

            view.owner_img.load(question.owner?.profile_image) {
                crossfade(true)
                placeholder(R.mipmap.ic_launcher)
                transformations(CircleCropTransformation())
            }
            view.owner_name.text = question.owner?.display_name
            view.question_published.text = "6 hours ago"
            view.title.text = question.title

            view.views_label.text = question?.view_count.toString()
            view.votes_label.text = question?.score.toString()
            view.answers_label.text = question?.answer_count.toString()

            question.tags?.forEach {

                val chip = Chip(view.context)

                chip.apply {
                    chip.isClickable = false
                    chip.isCheckable = false
                    chip.chipCornerRadius = maxOf(.0f, .0f)
                    chip.text = it
                    view.labels.addView(chip)
                }
            }

        }
    }
}