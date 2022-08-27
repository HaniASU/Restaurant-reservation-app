package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.data.databasesqlite;

public class Cancel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
    }

    public void to_user(View view) {
        Intent intent = new Intent(Cancel.this, MainActivity.class);
        Cancel.this.finish();
        startActivity(intent);
    }


    public void Cancel(View view){
        databasesqlite DB = new databasesqlite(this);
        EditText bnumtext = (EditText) findViewById(R.id.cancel_num);
        String bookingnum = bnumtext.toString();
        int bnumint = Integer.parseInt(bookingnum);

        if(bookingnum.isEmpty()){
            Toast.makeText(this,"Please Enter Booking Number !",Toast.LENGTH_LONG);
        }
        else{
            if(DB.delete_booking_info(bnumint)==-1){
                Toast.makeText(this,"The Number you inserted was not found !",Toast.LENGTH_LONG);
            }
            else{
                Toast.makeText(this,"Succefully Cancelled !",Toast.LENGTH_LONG);
            }
        }
    }
}