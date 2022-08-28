package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import com.example.project.data.user_info;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, sign_in.class);
        MainActivity.this.finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        ImageButton Ib = (ImageButton) findViewById(R.id.profile);

        if(user_info.user.getString(6).equals("Male")) {
            Ib.setImageResource(R.drawable.male);
        }
        else
            Ib.setImageResource(R.drawable.female);
    }
    public void log_out(View view)
    {
        user_info.user.moveToFirst();
        Intent intent = new Intent(MainActivity.this, sign_in.class);
        MainActivity.this.finish();
        startActivity(intent);
    }
    public void Display_all_Tables(View view)
    {
        Intent intent = new Intent(MainActivity.this, display.class);
        MainActivity.this.finish();
        startActivity(intent);
    }
    public void to_profile(View view)
    {
        Intent intent = new Intent(MainActivity.this, profile.class);
        MainActivity.this.finish();
        startActivity(intent);
    }
    public void to_booking(View view)
    {
        Intent intent = new Intent(MainActivity.this, book.class);
        MainActivity.this.finish();
        startActivity(intent);
    }

    public void to_cancelling(View view)
    {
        Intent intent = new Intent(MainActivity.this, Cancel.class);
        MainActivity.this.finish();
        startActivity(intent);
    }
}