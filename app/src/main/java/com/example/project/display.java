package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.data.databasesqlite;
import com.example.project.data.user_info;

public class display extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.display);

        ListView View =(ListView) findViewById(R.id.lview);
        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        View.setAdapter(listAdapter);

        databasesqlite dbs = new databasesqlite(this);
        int id = user_info.user.getInt(0);
        boolean r = dbs.check_id(id);

        if (r == true)
        {
            String num =String.valueOf(user_info.c_display.getInt(0));
            listAdapter.add("Number of Reservation : "+num);
            String num_persons =String.valueOf(user_info.c_display.getInt(1));
            listAdapter.add("Number of persons : "+num_persons);
            String date = user_info.c_display.getString(2);
            listAdapter.add("Date : " + date);
        }
        else
        {
            Toast.makeText(this, "you don't have Reservations", Toast.LENGTH_SHORT).show();
        }
    }

    public void to_main(View view)
    {
        Intent intent = new Intent(display.this, MainActivity.class);
        startActivity(intent);
    }

}