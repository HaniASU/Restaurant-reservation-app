package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.project.data.user_info;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }
    public void log_out(View view)
    {
        user_info.user_id = Integer.parseInt("");
        user_info.user_name = "";
        user_info.user_phone =Integer.parseInt("");
        user_info.user_district = "";
        user_info.user_email = "";
        user_info.user_password = "";
        user_info.user_gender = "";
        Intent intent = new Intent(MainActivity.this, sign_in.class);
        startActivity(intent);
    }
// abo 7med ysb7
}