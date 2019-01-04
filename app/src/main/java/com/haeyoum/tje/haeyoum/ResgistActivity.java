package com.haeyoum.tje.haeyoum;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ResgistActivity extends AppCompatActivity {

    private static final String LOG_TAG = "register";

    Button btn_reset;
    Button btn_submit;

    TextView str_pw;
    TextView str_name;
    TextView str_email;
    TextView str_output;

    Gson gson = new Gson();

    public void initRefs() {

        str_pw = findViewById(R.id.str_pw);
        str_name = findViewById(R.id.str_name);
        str_email = findViewById(R.id.str_email);

        btn_reset = findViewById(R.id.btn_reset);
        btn_submit = findViewById(R.id.btn_submit);
    }

    public void setEvents() {
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_pw.setText("");
                str_name.setText("");
                str_email.setText("");
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                        try {
                            // Create URL
                            URL endPoint = new URL("http://192.168.10.78:8080/A_Haeyoum/m/member/regist");
                            // Create connection
                            HttpURLConnection myConnection =
                                    (HttpURLConnection) endPoint.openConnection();
                            // 메소드 방식 변경
                            myConnection.setRequestMethod("POST");

                            Mem mem = new Mem();
                            mem.setM_password(str_pw.getText().toString().trim());
                            mem.setM_name(str_name.getText().toString().trim());
                            mem.setM_email(str_email.getText().toString().trim());

                            String out = mem.toServer();
                            Log.d(LOG_TAG, out);
//                            String requestParam =
//                                    String.format(
//                                            "message=%s" +
//                                            "&age=%d",
//                                            "Hello", 22);

//                            String myData1 = "message=Hello";
//                            String myData2 = "&age=22";
                            // 출력스트림을 사용하여 POST 방식의 파라메터 전달
                            myConnection.setDoOutput(true);
                            myConnection.getOutputStream().write(out.getBytes());

                            if (myConnection.getResponseCode() == 200) {
                                // Success
                                BufferedReader in =
                                        new BufferedReader(
                                                new InputStreamReader(
                                                        myConnection.getInputStream()));
                                StringBuffer buffer = new StringBuffer();
                                String temp = null;
                                while((temp = in.readLine())!=null)
                                    buffer.append(temp);

                                Map<String, Integer> map = gson.fromJson(buffer.toString(), new TypeToken<Map<String, Integer>>(){}.getType());
                                Integer result = map.get("result");
                                Intent intent =
                                        new Intent(getApplicationContext(), MainActivity.class);
                                if( result == null || result == 0 ){
                                    Log.d(LOG_TAG, "여긴 널 위한곳 : " + result);
                                    setResult(RESULT_CANCELED, intent);
                                    finish();

                                } else {
                                    Log.d(LOG_TAG, result + " : 여긴 성공값");
                                    setResult(RESULT_OK, intent);
                                    finish();
                                }
                            } else {
                                // Error
//                                str_output.append("서버 연결 및 메세지 읽기 실패\n");
//                                str_output.append("응답 코드 : " + myConnection.getResponseCode() + "\n");
                                Log.d(LOG_TAG, myConnection.getResponseCode() + "\n");

                            }

                        } catch (Exception e) {
                            Log.d(LOG_TAG, e.getMessage());
//                            str_output.append("서버 연결 및 메세지 읽기 실패\n");
                        }


                    }
                });

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        int permission_internet =
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.INTERNET);

        if (permission_internet == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    112);
        }

        initRefs();
        setEvents();
    }
}