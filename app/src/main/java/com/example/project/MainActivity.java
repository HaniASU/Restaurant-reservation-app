package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;

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
        user_info.user.moveToFirst();
        Intent intent = new Intent(MainActivity.this, sign_in.class);
        startActivity(intent);
    }
    public void to_profile(View view)
    {
        Intent intent = new Intent(MainActivity.this, profile.class);
        startActivity(intent);
    }
    public void to_booking(View view)
    {
        Intent intent = new Intent(MainActivity.this, book.class);
        startActivity(intent);
    }
}