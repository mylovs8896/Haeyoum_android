package com.haeyoum.tje.haeyoum;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_regist;
    Button btn_main_login;

    public void initRefs() {
        btn_regist = (Button) findViewById(R.id.btn_regist);
        btn_main_login = (Button) findViewById(R.id.btn_main_login);
    }
    public void setEvents() {
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResgistActivity.class);
                startActivity(intent);
            }
        });

        btn_main_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRefs();
        setEvents();
    }
}