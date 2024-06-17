package com.example.tangxiao.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.tangxiao.R
import com.example.tangxiao.User
import com.example.tangxiao.database.DBRepository

class RegisterActivity : AppCompatActivity() {
    private val dbName = "HealthManager.db"
    private val tableName = "Users"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val register = findViewById<Button>(R.id.button3)
        val askName = findViewById<EditText>(R.id.editView1)
        val askPassword = findViewById<EditText>(R.id.editView2)
        val back = findViewById<ImageView>(R.id.imageView3)
        register.setOnClickListener {
            val ipName = askName.text.toString()
            val ipPassword = askPassword.text.toString()
            if (ipName.isEmpty() || ipPassword.isEmpty()) {
                val tips = getString(R.string.errorTips)
                Toast.makeText(this, tips, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (DBRepository(this, dbName, tableName, 3).isInTable(User(ipName, ipPassword,"",""))) {
                val tips = getString(R.string.account_existed)
                Toast.makeText(this, tips, Toast.LENGTH_SHORT).show()
            } else {
                DBRepository(this, dbName, tableName, 3).insert(User(ipName, ipPassword,"",""))
                val tips = getString(R.string.registered)
                Toast.makeText(this, tips, Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        back.setOnClickListener {
            finish()
        }
    }
}