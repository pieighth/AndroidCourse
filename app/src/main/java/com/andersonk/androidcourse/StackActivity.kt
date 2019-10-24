package com.andersonk.androidcourse

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
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

    private val mainNavController : NavController? by lazy {
        findNavController(R.id.container_fragment)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack)
        setSupportActionBar(toolbar)

        mainNavController?.let {
            nav.setupWithNavController(it)
        }
//        val stackFragment = StackFragment()
//        val helloFragment = HelloFragment()
//
//        nav.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.nav_stack ->{
//                    replaceFragment(stackFragment)
//                    return@setOnNavigationItemSelectedListener true
//                }R.id.nav_hello ->{
//                    replaceFragment(helloFragment)
//                    return@setOnNavigationItemSelectedListener true
//                }else ->{
//                    return@setOnNavigationItemSelectedListener false
//                }
//            }
//        }

    }

//    fun replaceFragment(fragment: Fragment){
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.container_fragment, fragment, fragment::javaClass.toString())
//            .commit()
//    }
}
