package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.data.databasesqlite;

public class book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_book);
    }



    public void save_info(View view)
    {
        databasesqlite b= new databasesqlite(this);

        EditText numberofpersons = (EditText) findViewById(R.id.num_of_persons);
        EditText dateofbooking = (EditText) findViewById(R.id.date_of_booking);

        String NumberOfPersons = numberofpersons.getText().toString();
        String DateOfBooking = dateofbooking.getText().toString();

        if ( NumberOfPersons.isEmpty()|| DateOfBooking.isEmpty() )
        {
            Toast.makeText(this, " Invaild data", Toast.LENGTH_LONG).show();
        }
        else {
            String result = b.insert_booking_info(Integer.parseInt(NumberOfPersons) ,DateOfBooking);
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();

            numberofpersons.getText().clear();
            dateofbooking.getText().clear();

        }
    }
}