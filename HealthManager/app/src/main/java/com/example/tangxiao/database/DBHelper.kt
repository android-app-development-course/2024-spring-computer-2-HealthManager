package com.example.tangxiao.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(context: Context, dbName: String, dbVersion: Int) :
    SQLiteOpenHelper(context, dbName, null, dbVersion) {

    private val createTable = "CREATE TABLE Users (" +
            "id integer primary key autoincrement," +
            "name text," +
            "nickname text,"+
            "contact text,"+
            "password text)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Users")
        onCreate(db)
    }
}