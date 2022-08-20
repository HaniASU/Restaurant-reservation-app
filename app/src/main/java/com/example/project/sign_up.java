package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.project.data.databasesqlite;

public class sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);
    }

    public void go_to_signin(View view) {
        Intent intent = new Intent(sign_up.this, sign_in.class);
        startActivity(intent);
    }

    public void save_data(View view) {
        databasesqlite dt =new databasesqlite(this);
        String gender=null;


        EditText t1 =(EditText) findViewById(R.id.fullname);
        EditText t2 =(EditText) findViewById(R.id.phone);
        EditText t3 =(EditText) findViewById(R.id.District);
        EditText t4 =(EditText) findViewById(R.id.Email);
        EditText t5 =(EditText) findViewById(R.id.password);

        RadioButton t6 =(RadioButton) findViewById(R.id.r_b_male);
        RadioButton t7 =(RadioButton) findViewById(R.id.r_b_female);

        if (t6.isChecked())
            gender = t6.getText().toString();
        else if (t7.isChecked())
            gender = t7.getText().toString();

        Toast.makeText(this, "hi", Toast.LENGTH_LONG).show();

        String result = dt.insert_data(t1.getText().toString(),Integer.parseInt(t2.getText().toString()),t3.getText().toString(),t4.getText().toString(),t5.getText().toString(),gender);
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

    }
}