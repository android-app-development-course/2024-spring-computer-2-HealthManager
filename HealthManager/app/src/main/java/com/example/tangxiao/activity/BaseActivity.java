package com.example.tangxiao.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.tangxiao.MainActivity;
import com.example.tangxiao.R;
import com.example.tangxiao.activity.InfoActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseActivity extends AppCompatActivity {
    void changePage(Context context){
        Intent intent = new Intent();
        intent.setClass(context, InfoActivity.class);
        // intent.setClass(context,c);
        context.startActivity(intent);
    }
//    protected BottomNavigationView navigationView;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_info);
//        init(this);
//    }

//    protected void init(AppCompatActivity activity){
//        navigationView = (BottomNavigationView) findViewById(R.id.nav_view);
//        navigationView.setItemIconTintList(null);
//        //设置默认
//        navigationView.getMenu().getItem(1).setChecked(true);
//        //
//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Intent intent = new Intent();
//                switch (item.getItemId()){
//                    case R.id.nav_1:
//                        intent.setClass(activity, InfoActivity.class);
//                        activity.startActivity(intent);
//                        return true;
//                    case R.id.nav_2:
//                        return true;
//
//                    case R.id.nav_3:
//
//                        return true;
//
//                    case R.id.nav_4:
//
//                        return true;
//                }
//                return false;
//            }
//        });
//    }


}

