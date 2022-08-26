package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.data.databasesqlite;
import com.example.project.data.user_info;


public class sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_in);
    }

    public void go_to_signup(View view) {
        Intent intent = new Intent(sign_in.this, sign_up.class);
        startActivity(intent);
    }

    public void sign_in(View view ) {

        databasesqlite dt = new databasesqlite(this);
        EditText email_user = (EditText) findViewById(R.id.login_email);
        EditText password_user = (EditText) findViewById(R.id.password_login);
        boolean r = dt.check_data(email_user,password_user);
        if (r == false)
        {
            Toast.makeText(this, "Invaild data! Try again", Toast.LENGTH_SHORT).show();
            email_user.getText().clear();
            password_user.getText().clear();
        }
        else
        {
            Toast.makeText(this, "Login Successfully! Welcome " + user_info.user.getString(1), Toast.LENGTH_SHORT).show();
            email_user.getText().clear();
            password_user.getText().clear();
            Intent intent = new Intent(sign_in.this, MainActivity.class);
            sign_in.this.finish();
            startActivity(intent);
        }
    }
}