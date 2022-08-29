package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Goodbye extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Goodbye.this, sign_in.class);
        Goodbye.this.finish();
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_goodbye);
    }

    public void exit(View view)
    {
        System.exit(0);
    }
}