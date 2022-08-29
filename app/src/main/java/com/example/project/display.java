package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project.data.databasesqlite;
import com.example.project.data.user_info;

public class display extends AppCompatActivity{

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(display.this, MainActivity.class);
        display.this.finish();
        startActivity(intent);
    }

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

        Button next = (Button) findViewById(R.id.next);
        Button previous = (Button) findViewById(R.id.previous);

        ImageView reserveimage = (ImageView)findViewById(R.id.reservation);
        ImageView errorimage = (ImageView) findViewById(R.id.errorimage);

        if (r == true)
        {
            displayer(listAdapter);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(android.view.View view) {
                    listAdapter.clear();
                    if(!user_info.c_display.isLast()){
                        user_info.c_display.moveToNext();
                    }
                    else{
                        user_info.c_display.moveToFirst();
                    }
                    displayer(listAdapter);
                }
            });
            previous.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(android.view.View view) {
                    listAdapter.clear();
                    if(!user_info.c_display.isFirst()){
                        user_info.c_display.moveToPrevious();
                    }
                    else{
                        user_info.c_display.moveToLast();
                    }
                    displayer(listAdapter);
                }
            });

        }
        else
        {
            reserveimage.setVisibility(View.INVISIBLE);
            errorimage.setVisibility(View.VISIBLE);
            next.setVisibility(View.INVISIBLE);
            previous.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "you don't have Reservations", Toast.LENGTH_SHORT).show();
        }
    }

    public void to_main(View view)
    {
        Intent intent = new Intent(display.this, MainActivity.class);
        display.this.finish();
        startActivity(intent);
    }


    public void displayer(ArrayAdapter<String> listAdapter)
    {
        String num =String.valueOf(user_info.c_display.getInt(0));
        listAdapter.add("Booking Number :  "+num);
        String num_persons =String.valueOf(user_info.c_display.getInt(1));
        listAdapter.add("Number of persons : "+num_persons);
        String date = user_info.c_display.getString(2);
        listAdapter.add("Date : " + date);
    }

}