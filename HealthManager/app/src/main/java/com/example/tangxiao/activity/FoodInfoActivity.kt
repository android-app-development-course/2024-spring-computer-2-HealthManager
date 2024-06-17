package com.example.tangxiao.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.tangxiao.R
import com.google.android.material.appbar.AppBarLayout

class FoodInfoActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_info)
        val imageView = findViewById<ImageView>(R.id.imageView1)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val array = intent.getStringArrayExtra("item")
        val id = intent.getIntExtra("img", 0)
        imageView.setImageResource(id)
        textView1.text = array?.get(0)
        textView2.text = array?.get(1)
        textView3.text = array?.get(2)

        val appbar=findViewById<Toolbar>(R.id.topAppBar)
        appbar.setNavigationOnClickListener {
            finish()
        }
    }
}