package com.example.tangxiao.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.tangxiao.FoodBank.RecommendContent
import com.example.tangxiao.R

class RecommendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)
        val recommend=findViewById<TextView>(R.id.text2)
        val appbar=findViewById<Toolbar>(R.id.topAppBar)
        recommend.text=RecommendContent
        appbar.setNavigationOnClickListener {
            finish()
        }
    }
}