package com.example.tangxiao.activity;

import android.os.Bundle;
import android.view.View;

import com.example.tangxiao.R;

public class UserActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        init();
    }

    private void init(){
        View arrow = (View)findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePage(UserActivity.this);
            }
        });
    }
}