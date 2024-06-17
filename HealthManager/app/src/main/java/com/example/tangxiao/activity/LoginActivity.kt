package com.example.tangxiao.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tangxiao.MainActivity
import com.example.tangxiao.R
import com.example.tangxiao.User
import com.example.tangxiao.database.DBHelper
import com.example.tangxiao.database.DBRepository

class LoginActivity : AppCompatActivity() {
    companion object {
        @JvmField
        var curUser = User("", "", "","")
    }

    @SuppressLint("MissingInflatedId")
    private val dbName = "HealthManager.db"
    private val tableName = "Users"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login = findViewById<Button>(R.id.button1)
        val register = findViewById<Button>(R.id.button2)
        val askName = findViewById<EditText>(R.id.askName)
        val askPassword = findViewById<EditText>(R.id.askPassword)
        curUser = User("", "", "","")
        login.setOnClickListener {
            val ipName = askName.text.toString()
            val ipPassword = askPassword.text.toString()
            if (ipName.isEmpty() || ipPassword.isEmpty()) {
                val tips = getString(R.string.errorTips)
                Toast.makeText(this, tips, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (DBRepository(this, dbName, tableName, 3).isInTable(User(ipName, ipPassword, "",""))) {
                Toast.makeText(this, "succeed", Toast.LENGTH_SHORT).show()
                curUser =
                    DBRepository(this, dbName, tableName, 3).getUsers(User(ipName, ipPassword, "",""))
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        }

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}