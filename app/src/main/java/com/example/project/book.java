package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.example.project.data.databasesqlite;

public class book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_book);
    }
    public void save_info(View view)
    {
        databasesqlite b= new databasesqlite(this);

        EditText numberofpersons = (EditText) findViewById(R.id.num_of_persons);
        EditText dateofbooking = (EditText) findViewById(R.id.date_of_booking);
    }
}