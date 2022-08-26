package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.data.databasesqlite;
import com.example.project.data.user_info;

public class book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_book);
    }

    public void go_to_user(View view) {
        Intent intent = new Intent(book.this, MainActivity.class);
        startActivity(intent);
    }

    public void save_info(View view)
    {
        databasesqlite b= new databasesqlite(this);

        EditText numberofpersons = (EditText) findViewById(R.id.num_of_persons);
        EditText dateofbooking = (EditText) findViewById(R.id.date_of_booking);
        int UserId = user_info.user.getInt(0);

        String NumberOfPersons = numberofpersons.getText().toString();
        String DateOfBooking = dateofbooking.getText().toString();


        if ( NumberOfPersons.isEmpty() ||DateOfBooking.isEmpty() )
        {
            Toast.makeText(this, " Invaild data", Toast.LENGTH_LONG).show();
        }
        else {
            long final_res = b.insert_booking_info(Integer.parseInt(NumberOfPersons) ,DateOfBooking ,UserId);
            if (final_res == -1) {
                Toast.makeText(this, " Invaild data", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText( this, "Your Reservation is " +final_res, Toast.LENGTH_LONG).show();
                numberofpersons.getText().clear();
                dateofbooking.getText().clear();
            }


        }
    }
}