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
import com.example.project.data.user_info;

public class profile extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(profile.this, MainActivity.class);
        profile.this.finish();
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);

        EditText user_id = (EditText) findViewById(R.id.id_update);
        EditText na =(EditText) findViewById(R.id.name_update);
        EditText ph =(EditText) findViewById(R.id.phone_update);
        EditText dis =(EditText) findViewById(R.id.district_update);
        EditText em =(EditText) findViewById(R.id.email_update);
        EditText pass =(EditText) findViewById(R.id.password_update);
        RadioButton mal =(RadioButton) findViewById(R.id.r_b_mal_update);
        RadioButton fmal =(RadioButton) findViewById(R.id.r_b_fmal_update);

        user_id.setText(String.valueOf(user_info.user.getInt(0)));
        na.setText(user_info.user.getString(1));
        ph.setText(String.valueOf(user_info.user.getInt(2)));
        dis.setText(user_info.user.getString(3));
        em.setText(user_info.user.getString(4));
        pass.setText(user_info.user.getString(5));


        if(user_info.user.getString(6).equals("Male")) {
            mal.setChecked(true);
        }
        else
            fmal.setChecked(true);

    }


    public void to_main(View view) {
        Intent intent = new Intent(profile.this, MainActivity.class);
        profile.this.finish();
        startActivity(intent);
    }

    public void update(View view) {

        databasesqlite dt =new databasesqlite(this);
        String gender="";

        EditText na =(EditText) findViewById(R.id.name_update);
        EditText ph =(EditText) findViewById(R.id.phone_update);
        EditText dis =(EditText) findViewById(R.id.district_update);
        EditText em =(EditText) findViewById(R.id.email_update);
        EditText pass =(EditText) findViewById(R.id.password_update);
        RadioButton mal =(RadioButton) findViewById(R.id.r_b_mal_update);
        RadioButton fmal =(RadioButton) findViewById(R.id.r_b_fmal_update);

        String Name = na.getText().toString();
        String Phone = ph.getText().toString();
        String District = dis.getText().toString();
        String Email = em.getText().toString();
        String Password = pass.getText().toString();

        String Valid_email = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String text = "[a-zA-Z0-9._-]+";

        if (mal.isChecked())
            gender = mal.getText().toString();
        else
            gender = fmal.getText().toString();


        if (Name.isEmpty()|| Phone.isEmpty() ||Password.isEmpty() || District.isEmpty() || Email.isEmpty() || gender =="")
        {
            Toast.makeText(this, "Invaild data", Toast.LENGTH_LONG).show();
        }

        else if (Email.matches(Valid_email) && Name.matches(text) && District.matches(text))
        {
            String result = dt.update_Data(Name, Integer.parseInt(Phone), District, Email, Password, gender);
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
            dt.select_data(user_info.user.getInt(0));
        }
        else
        {
            Toast.makeText(this, "Please enter correct data", Toast.LENGTH_LONG).show();
        }
    }
    public void delete(View view)
    {
        databasesqlite dt = new databasesqlite(this);
        int r = dt.deleteData(user_info.user.getInt(0));
        if (r >0) {
            Toast.makeText(this, "Account Removed", Toast.LENGTH_LONG).show();
            user_info.user.moveToFirst();
            Intent intent = new Intent(profile.this, Goodbye.class);
            profile.this.finish();
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Failed to remove Account", Toast.LENGTH_LONG).show();

        }
    }

}