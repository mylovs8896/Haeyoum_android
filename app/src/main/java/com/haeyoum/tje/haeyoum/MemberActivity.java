package com.haeyoum.tje.haeyoum;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MemberActivity extends AppCompatActivity {

    Button btn_search_m;
    Button btn_alram;
    Button btn_create_group;
    Button btn_mypage;
    Button btn_group;


    public void initRefs() {
        btn_search_m = findViewById(R.id.btn_search_m);
        btn_alram = findViewById(R.id.btn_alram);
        btn_create_group = findViewById(R.id.btn_create_group);
        btn_mypage = findViewById(R.id.btn_mypage);
        btn_group = findViewById(R.id.btn_group);
    }

    public void setEvents() {
        btn_search_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Search_M_Activity.class);
                startActivity(intent);

            }
        });
        btn_alram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlramActivity.class);
                startActivity(intent);

            }
        });
        btn_create_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Create_GroupActivity.class);
                startActivity(intent);

            }
        });
        btn_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);

            }
        });
        btn_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GroupActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        initRefs();
        setEvents();
    }
}
