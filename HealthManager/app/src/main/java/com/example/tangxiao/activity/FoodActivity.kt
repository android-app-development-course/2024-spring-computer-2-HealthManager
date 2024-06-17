package com.example.tangxiao.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.tangxiao.Food
import com.example.tangxiao.FoodAdapter
import com.example.tangxiao.FoodBank.allFoodList
import com.example.tangxiao.R
import com.google.android.material.appbar.AppBarLayout

class FoodActivity : AppCompatActivity() {

    private val foodList = ArrayList<Food>()
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val listView = findViewById<ListView>(R.id.listView)
        init()
        val adapter = FoodAdapter(this, R.layout.food_item, foodList)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, _, _ ->

        }
        listView.setOnItemClickListener { _, _, position, _ ->
            val food = foodList[position]
            val intent= Intent(this,FoodInfoActivity::class.java)
            val data= arrayOf(food.name,food.efficacy,food.caveat)
            intent.putExtra("img",food.imgId)
            intent.putExtra("item",data)
            startActivity(intent)
        }
        val appbar=findViewById<Toolbar>(R.id.topAppBar)
        appbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun init() {
        foodList.addAll(allFoodList)
    }
}