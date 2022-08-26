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
        String UserId = user_info.user.getString(0);

        String NumberOfPersons = numberofpersons.getText().toString();
        String DateOfBooking = dateofbooking.getText().toString();


        if ( NumberOfPersons.isEmpty() ||DateOfBooking.isEmpty() )
        {
            Toast.makeText(this, " Invaild data", Toast.LENGTH_LONG).show();
        }
        else {
            String final_res = b.insert_booking_info(Integer.parseInt(NumberOfPersons) ,DateOfBooking ,Integer.parseInt(UserId));
            Toast.makeText( this, "Book Successfully\n" + "And\n" + "Your Booking Number is ", Toast.LENGTH_LONG).show();
//            + user_info.book_info_cursor.getString(0)
            numberofpersons.getText().clear();
            dateofbooking.getText().clear();

        }
    }
}