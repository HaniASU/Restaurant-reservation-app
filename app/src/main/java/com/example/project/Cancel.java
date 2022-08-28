package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.data.databasesqlite;

public class Cancel extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Cancel.this, MainActivity.class);
        Cancel.this.finish();
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cancel);
    }

    public void to_user(View view) {
        Intent intent = new Intent(Cancel.this, MainActivity.class);
        Cancel.this.finish();
        startActivity(intent);
    }


    public void cancel(View view){
        databasesqlite d = new databasesqlite(this);
        EditText bnumtext = (EditText) findViewById(R.id.cancel_num);
        String bookingnum = bnumtext.getText().toString();


        if(bookingnum.isEmpty()){
            Toast.makeText(this,"Please Enter Reservation Number !",Toast.LENGTH_LONG).show();
        }
        else{
            if(d.delete_booking_info(bookingnum)==-1){
                Toast.makeText(this,"The Number you inserted was not found !",Toast.LENGTH_LONG).show();
                bnumtext.getText().clear();
            }
            else
            {
                Toast.makeText(this,"Succefully Cancelled !",Toast.LENGTH_LONG).show();
                bnumtext.getText().clear();
            }
        }
    }
}