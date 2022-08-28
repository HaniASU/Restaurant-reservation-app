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

import java.text.ParseException;

public class book extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(book.this, MainActivity.class);
        book.this.finish();
        startActivity(intent);
    }

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

    public void save_info(View view) throws ParseException {
        databasesqlite b= new databasesqlite(this);

        EditText numberofpersons = (EditText) findViewById(R.id.num_of_persons);
        EditText dateofbooking = (EditText) findViewById(R.id.date_of_booking);
        int UserId = user_info.user.getInt(0);

        String NumberOfPersons = numberofpersons.getText().toString();
        String DateOfBooking = dateofbooking.getText().toString();
        String Valid_day = "";
        String Valid_month = "";

        DateStringConverter dsc = new DateStringConverter();

        if(!DateOfBooking.isEmpty())
        {
            try {
                Valid_day = Character.toString(DateOfBooking.charAt(0)) + Character.toString(DateOfBooking.charAt(1));
                Valid_month = Character.toString(DateOfBooking.charAt(3)) + Character.toString(DateOfBooking.charAt(4));
                if((DateOfBooking.length() < 8) || (((DateOfBooking.charAt(2) != '-')&&(DateOfBooking.charAt(5) != '-')) &&
                        ((DateOfBooking.charAt(1) != '-')&&(DateOfBooking.charAt(4) != '-')))||
                        (DateOfBooking.length() > 10) || (Counter(DateOfBooking) > 2) || (Integer.parseInt(Valid_day) > 31 || Integer.parseInt(Valid_month) > 12))
                {
                    Toast.makeText(this, "Invalid Pattern of Date", Toast.LENGTH_LONG).show();
                    if(NumberOfPersons.isEmpty())
                        Toast.makeText(this, "Please Complete Reservation requirments", Toast.LENGTH_LONG).show();
                    return;
                }
            }
            catch(Exception e) {
                Toast.makeText(this, "Invalid Pattern of Date", Toast.LENGTH_LONG).show();
                return;

        }

            if(!dsc.checkdate(DateOfBooking))
            {
                Toast.makeText(this, "Old Date", Toast.LENGTH_LONG).show();
                return;
            }
        }

        if(!NumberOfPersons.isEmpty())
        {
            if(Integer.parseInt(NumberOfPersons) > 10 || Integer.parseInt(NumberOfPersons) <= 0)
            {
                Toast.makeText(this, "Invalid number of Persons (Max is 10)", Toast.LENGTH_LONG).show();
                return;
            }
        }
        if (NumberOfPersons.isEmpty() || DateOfBooking.isEmpty())
        {
            Toast.makeText(this, "Please Complete Booking Requirements", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            String  final_res = b.insert_booking_info(Integer.parseInt(NumberOfPersons) ,DateOfBooking ,UserId);
            Toast.makeText( this, final_res, Toast.LENGTH_LONG).show();
            showMessage("Booking Information",final_res +"\n"+ "Number of Persons : "+NumberOfPersons +"\n" +"Date Of Booking : " +DateOfBooking);
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

    public int Counter(String s){
        int total = s.length();
        int removed = s.replace("-","").length();
        return total-removed;
    }
}