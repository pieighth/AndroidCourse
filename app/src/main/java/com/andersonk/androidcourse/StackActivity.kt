package com.andersonk.androidcourse

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.adapters.FragmentTabs
import com.andersonk.androidcourse.adapters.QuestionAdapter
import com.andersonk.androidcourse.fragments.HelloFragment
import com.andersonk.androidcourse.fragments.StackFragment
import com.andersonk.androidcourse.models.Question
import com.andersonk.androidcourse.models.QuestionList
import com.andersonk.androidcourse.services.Api

import kotlinx.android.synthetic.main.activity_stack.*
import kotlinx.android.synthetic.main.content_stack.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class StackActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack)
        setSupportActionBar(toolbar)

        val fragmentTabs = FragmentTabs(supportFragmentManager)

        pages.adapter = fragmentTabs

//        var stackFragment = StackFragment()
//        var helloFragment = HelloFragment()
//
//
//        stack_button.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.stack_id, stackFragment, "stack")
//                .commit()
//        }
//
//        main_button.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.stack_id, helloFragment, "hello")
//                .commit()
//        }






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
