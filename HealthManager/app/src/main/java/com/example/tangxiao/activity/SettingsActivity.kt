package com.example.tangxiao.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.tangxiao.R
import com.example.tangxiao.User
import com.example.tangxiao.activity.LoginActivity.Companion.curUser

class SettingsActivity : AppCompatActivity() {
    private var lastTouch = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val linearLayout2 = findViewById<LinearLayout>(R.id.linearLayout2)
        val linearLayout3 = findViewById<LinearLayout>(R.id.linearLayout3)
        val linearLayout4 = findViewById<LinearLayout>(R.id.linearLayout4)
        val linearLayout5 = findViewById<LinearLayout>(R.id.linearLayout5)
        val userID=findViewById<TextView>(R.id.userID)
        val username = findViewById<TextView>(R.id.username)
        val contact=findViewById<TextView>(R.id.link)
        val reload=findViewById<LinearLayout>(R.id.load)
        userID.text=curUser.name
        username.text= curUser.nickname
        contact.text= curUser.contact
        linearLayout2.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("tag",2)
            startActivityForResult(intent, 1)
            lastTouch=2
        }
        linearLayout3.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("tag",3)
            startActivityForResult(intent, 1)
            lastTouch=3
        }
        linearLayout4.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("tag",4)
            startActivityForResult(intent, 1)
            lastTouch=4
        }
        linearLayout5.setOnClickListener{
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("tag",5)
            startActivityForResult(intent, 1)
            lastTouch=5
        }
        reload.setOnClickListener {
            userID.text=curUser.name
            username.text= curUser.nickname
            contact.text= curUser.contact
        }
        val appbar=findViewById<Toolbar>(R.id.topAppBar)
        appbar.setNavigationOnClickListener {
            finish()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val result = data?.getStringExtra("back")
                when(lastTouch){
                    2->{
                        val userID=findViewById<TextView>(R.id.userID)
                        userID.text=result
                    }
                    3->{
                        val username = findViewById<TextView>(R.id.username)
                        username.text=result
                    }
                    5->{
                        val link=findViewById<TextView>(R.id.link)
                        link.text=result
                    }
                }
            }
        }
    }
}