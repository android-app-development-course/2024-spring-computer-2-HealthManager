package com.example.tangxiao.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tangxiao.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class InfoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
    }
}