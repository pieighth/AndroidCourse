package com.andersonk.androidcourse.sw.adapters

import android.app.Application
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.sw.DetailActivity
import com.andersonk.androidcourse.sw.models.People
import kotlinx.android.synthetic.main.content_sw_people_item.view.*

class PeoplesAdapter : RecyclerView.Adapter<PeoplesAdapter.PeoplesHolder>()
{
    val peoples = mutableListOf<People>()

    fun setPeoples(peoples: MutableList<People>){
        this.peoples.addAll(peoples)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeoplesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.content_sw_people_item, parent, false)
        return PeoplesHolder(view)
    }

    override fun getItemCount(): Int {
        return peoples.size
    }

    override fun onBindViewHolder(holder: PeoplesHolder, position: Int) {
        holder.onBindData(peoples[position])
    }


    class PeoplesHolder(private val view: View) : RecyclerView.ViewHolder(view){

        fun onBindData(people: People){
            view.id_people.text = people.name
            view.id_people.setOnClickListener {
                val intent = Intent(view.context, DetailActivity::class.java)
                intent.putExtra("people", people.url)
                view.context.startActivity(intent)

            }
        }
    }
}