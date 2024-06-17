package com.example.tangxiao.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.tangxiao.R
import com.example.tangxiao.User
import com.example.tangxiao.activity.LoginActivity.Companion.curUser
import com.example.tangxiao.database.DBRepository

class EditActivity : AppCompatActivity() {
    private val dbName = "HealthManager.db"
    private val tableName = "Users"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val save=findViewById<Button>(R.id.button)
        val editText=findViewById<EditText>(R.id.editView)
        save.setOnClickListener {
            val content=editText.text.toString()
            if(content.isEmpty()){
                Toast.makeText(this,"此处不能为空！",Toast.LENGTH_SHORT).show()
            }else{
                val id=DBRepository(this,dbName,tableName,3).getId(curUser)
                when(intent.getIntExtra("tag",1)){
                    2->{
                        curUser.name=content
                        DBRepository(this, dbName,tableName,3).update(curUser,id)
                    }
                    3->{
                        curUser.nickname=content
                        DBRepository(this, dbName,tableName,3).update(curUser,id)
                    }
                    4->{
                        curUser.password=content
                        DBRepository(this, dbName,tableName,3).update(curUser,id)
                    }
                    5->{
                        curUser.contact=content
                        DBRepository(this, dbName,tableName,3).update(curUser,id)
                    }
                }
                val intent= Intent()
                intent.putExtra("back",content)
                setResult(RESULT_OK,intent)
                finish()
            }
        }
        val appbar=findViewById<Toolbar>(R.id.topAppBar)
        appbar.setNavigationOnClickListener {
            finish()
        }
    }
}