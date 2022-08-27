package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
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
        sign_up.this.finish();
        startActivity(intent);
    }

    public void save_data(View view) {
        databasesqlite dt =new databasesqlite(this);
        String gender="";

        EditText name =(EditText) findViewById(R.id.name_signup);
        EditText phone =(EditText) findViewById(R.id.phone_signup);
        EditText district =(EditText) findViewById(R.id.District_signup);
        EditText email =(EditText) findViewById(R.id.email_signup);
        EditText password =(EditText) findViewById(R.id.password_signup);

        RadioButton male =(RadioButton) findViewById(R.id.r_b_mal_update);
        RadioButton female =(RadioButton) findViewById(R.id.r_b_fmal_update);

        if (male.isChecked())
            gender = male.getText().toString();
        else if (female.isChecked())
            gender = female.getText().toString();

        String Name = name.getText().toString();
        String Phone = phone.getText().toString();
        String District = district.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();

        if (Name.isEmpty()|| Phone.isEmpty() ||Password.isEmpty() || District.isEmpty() || Email.isEmpty() || gender =="")
        {
            Toast.makeText(this, "Invaild data", Toast.LENGTH_LONG).show();
        }
        else {
            String result = dt.insert_data(Name, Integer.parseInt(Phone), District, Email, Password, gender);
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();

            name.getText().clear();
            phone.getText().clear();
            district.getText().clear();
            email.getText().clear();
            password.getText().clear();
            male.setChecked(false);
            female.setChecked(false);
            Intent intent = new Intent(sign_up.this, sign_in.class);
            sign_up.this.finish();
            startActivity(intent);
        }
    }

}