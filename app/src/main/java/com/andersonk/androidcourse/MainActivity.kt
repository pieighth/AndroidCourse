package com.andersonk.androidcourse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andersonk.androidcourse.sw.StarWarsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_old.setOnClickListener {


            startActivity(Intent(this, StackActivity::class.java))
        }

        btn_main_new.setOnClickListener {
            startActivity(Intent(this,StarWarsActivity::class.java))
        }
    }
}
