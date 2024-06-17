package com.example.tangxiao.activity;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.tangxiao.R;
import com.example.tangxiao.fragment.AssessmentFragment;

public class Activity_run extends AppCompatActivity {

    ImageView b;
    TextView b2;
    ImageView b3;
    ImageView b4;
    ImageView b5;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);


        tableLayout = (TableLayout) findViewById(R.id.tably);
        tableLayout.setStretchAllColumns(true);

        b = findViewById(R.id.img_back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_run.this, AssessmentFragment.class);
                startActivity(intent);
            }
        });
        b2 = findViewById(R.id.txt_back);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Activity_run.this, AssessmentFragment.class);
                //startActivity(intent);
                finish();
            }
        });
        b3 = findViewById(R.id.sxlt);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row = new TableRow(getApplicationContext());
                TextView text = new TextView(getApplicationContext());
                text.setText("上下楼梯10分钟");
                text.setTextColor(Color.BLACK);
                text.setTextSize(25);
                text.setGravity(Gravity.CENTER);
                row.addView(text);
                tableLayout.addView(row);
                display(v);
            }
        });
        b4 = findViewById(R.id.tbls);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row = new TableRow(getApplicationContext());
                TextView text = new TextView(getApplicationContext());
                text.setText("腿部拉伸20分钟");
                text.setTextColor(Color.BLACK);
                text.setTextSize(25);
                text.setGravity(Gravity.CENTER);
                row.addView(text);
                tableLayout.addView(row);
                display(v);
            }
        });
        b5 = findViewById(R.id.nlp);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row = new TableRow(getApplicationContext());
                TextView text = new TextView(getApplicationContext());
                text.setText("耐力跑30分钟");
                text.setTextColor(Color.BLACK);
                text.setTextSize(25);
                text.setGravity(Gravity.CENTER);
                row.addView(text);
                tableLayout.addView(row);
                display(v);
            }
        });
    }
    public void display(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.round_corner_bottom)
                .setTitle("添加成功！")
                .setMessage("要努力完成哦")
                .create()
                .show();
    }
}