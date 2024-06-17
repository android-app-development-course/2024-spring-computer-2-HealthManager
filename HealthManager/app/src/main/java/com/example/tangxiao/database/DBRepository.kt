package com.example.tangxiao.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.tangxiao.User

class DBRepository(
    context: Context,
    dbName: String,
    private val tableName: String,
    dbVersion: Int
) {
    private val dbHelper = DBHelper(context, dbName, dbVersion)

    fun insert(user: User): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", user.name)
            put("password", user.password)
            put("nickname", user.nickname)
            put("contact",user.contact)
        }
        return db.insert(tableName, null, values)
    }

    fun delete(user: User): Int {
        val db = dbHelper.writableDatabase
        return db.delete(tableName, "name=?", arrayOf(user.name))
    }

    fun update(user: User,id:Int): Int {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", user.name)
            put("password", user.password)
            put("nickname", user.nickname)
            put("contact",user.contact)
        }
        return db.update(tableName, values, "id=?", arrayOf(id.toString()))
    }

    @SuppressLint("Recycle", "Range")
    fun getAllUsers(): List<User> {
        val users = mutableListOf<User>()
        val db = dbHelper.writableDatabase
        val cursor = db.query(tableName, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                val id=cursor.getString(cursor.getColumnIndex("id"))
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val password = cursor.getString(cursor.getColumnIndex("password"))
                val nickname = cursor.getString(cursor.getColumnIndex("nickname"))
                val contact=cursor.getString(cursor.getColumnIndex("contact"))
                users.add(User(name, password, nickname,contact))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return users
    }

    @SuppressLint("Recycle", "Range")
    fun getUsers(user: User): User {
        val target=User("","","","")
        val db = dbHelper.writableDatabase
        val cursor = db.query(tableName, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val password = cursor.getString(cursor.getColumnIndex("password"))
                val nickname = cursor.getString(cursor.getColumnIndex("nickname"))
                val contact=cursor.getString(cursor.getColumnIndex("contact"))
                if (user.name == name && user.password == password) {
                    target.name=name
                    target.password=password
                    target.nickname=nickname
                    target.contact=contact
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return target
    }

    @SuppressLint("Recycle", "Range")
    fun getId(user: User): Int {
        var target=1
        val db = dbHelper.writableDatabase
        val cursor = db.query(tableName, null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                val id=cursor.getInt(cursor.getColumnIndex("id"))
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val password = cursor.getString(cursor.getColumnIndex("password"))
                val nickname = cursor.getString(cursor.getColumnIndex("nickname"))
                val contact=cursor.getString(cursor.getColumnIndex("contact"))
                if (user.name == name && user.password == password) {
                    target=id
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return target
    }

    @SuppressLint("Recycle")
    fun isInTable(user: User): Boolean {
        val db = dbHelper.readableDatabase
        val cursor: Cursor? = db.query(
            tableName, arrayOf("name", "password"), "name=? AND password=?",
            arrayOf(user.name.toString(), user.password.toString()), null, null, null
        )
        return cursor != null && cursor.moveToFirst()
    }

}