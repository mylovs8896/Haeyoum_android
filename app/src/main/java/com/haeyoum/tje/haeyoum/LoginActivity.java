package com.haeyoum.tje.haeyoum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button btn_Login;

    public void initRefs() {
        btn_Login = (Button) findViewById(R.id.btn_Login);
    }

    public void setEvents() {
        btn_Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MemberActivity.class);
                    startActivity(intent);
                }
            });
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            initRefs();
            setEvents();
        }

    }

