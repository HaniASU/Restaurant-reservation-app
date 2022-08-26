package com.example.project;

import androidx.appcompat.app.AlertDialog;
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
        book.this.finish();
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
            String  final_res = b.insert_booking_info(Integer.parseInt(NumberOfPersons) ,DateOfBooking ,UserId);
                Toast.makeText( this, final_res, Toast.LENGTH_LONG).show();
                showMessage("Booking Information",final_res +"\n"+ "Number of Persons : "+NumberOfPersons +"\n" +"Date : " +DateOfBooking);
                numberofpersons.getText().clear();
                dateofbooking.getText().clear();
        }
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}