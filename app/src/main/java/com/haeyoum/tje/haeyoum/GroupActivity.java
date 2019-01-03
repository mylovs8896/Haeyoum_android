package com.haeyoum.tje.haeyoum;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GroupActivity extends AppCompatActivity {

    Button btn_search_g;
    Button btn_member_list;
    Button btn_post;
    Button btn_chat;
    Button btn_board;
    Button btn_plan;
    Button btn_vote;
    Button btn_setting;


    public void initRefs(){

        btn_search_g = findViewById(R.id.btn_search_g);
        btn_member_list = findViewById(R.id.btn_member_list);
        btn_post = findViewById(R.id.btn_post) ;
        btn_chat = findViewById(R.id.btn_chat);
        btn_board = findViewById(R.id.btn_board);
        btn_plan = findViewById(R.id.btn_plan);
        btn_vote = findViewById(R.id.btn_vote);
        btn_setting = findViewById(R.id.btn_setting);

    }

    public void setEvents() {

        btn_search_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Search_G_Activity.class);
                startActivity(intent);

            }
        });
        btn_member_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Member_List_Activity.class);
                startActivity(intent);

            }
        });
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                startActivity(intent);

            }
        });
        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);

            }
        });
        btn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);

            }
        });
        btn_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlanActivity.class);
                startActivity(intent);

            }
        });
        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VoteActivity.class);
                startActivity(intent);

            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        initRefs();
        setEvents();
    }
}
