package com.example.tangxiao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.tangxiao.activity.BaseActivity;
import com.example.tangxiao.activity.InfoActivity;
import com.example.tangxiao.adapter.FragAdapterForMainActivity;
import com.example.tangxiao.fragment.AssessmentFragment;
import com.example.tangxiao.fragment.AttentionFragment;
import com.example.tangxiao.fragment.HomeFragment;
import com.example.tangxiao.fragment.InfoFragment;
import com.example.tangxiao.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //底部导航栏
    private BottomNavigationView navigationView;
    //用于存储碎片的集合
    private List<Fragment> fragmentList;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //绑定控件
        viewPager = (ViewPager) findViewById(R.id.vp_fragment);
        //对底部导航栏的初始化
        navigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        //设置默认
        navigationView.getMenu().getItem(0).setChecked(true);
        //初始化fragment集合
        fragmentList = new ArrayList<>();
        fragmentList.add(new InfoFragment());
        fragmentList.add(new SearchFragment());
        fragmentList.add(new HomeFragment());
        fragmentList.add(new AssessmentFragment());
        fragmentList.add(new AttentionFragment());
        //初始化适配器，向ViewPager添加页面
        FragAdapterForMainActivity adapter = new FragAdapterForMainActivity(
                getSupportFragmentManager()
                , this
                , fragmentList);
        viewPager.setAdapter(adapter);
        //
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_1:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.nav_2:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.nav_3:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.nav_4:
                        viewPager.setCurrentItem(3);
                        return true;
                    case R.id.nav_5:
                        viewPager.setCurrentItem(4);
                        return true;
                }
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //注意这个方法滑动时会调用多次，下面是参数解释：
            //position当前所处页面索引,滑动调用的最后一次绝对是滑动停止所在页面
            //positionOffset:表示从位置的页面偏移的[0,1]的值。
            //positionOffsetPixels:以像素为单位的值，表示与位置的偏移
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}