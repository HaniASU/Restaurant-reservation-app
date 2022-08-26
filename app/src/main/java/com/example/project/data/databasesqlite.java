package com.example.project.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

public class databasesqlite extends SQLiteOpenHelper {

    public static final String databaseName ="app.db";

    public databasesqlite(Context con)
    {
        super(con,databaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase Database) {
        Database.execSQL("create table booking (booking_number INTEGER primary key AUTOINCREMENT,NumberOfPersons INTEGER,DateOfBooking TEXT,UserId INTEGER)");
        Database.execSQL("create table user (Id INTEGER primary key AUTOINCREMENT ,Name TEXT ,Phone INTEGER, District TEXT ,Email TEXT,Password TEXT ,Gender TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase Database, int i, int i1) {
        Database.execSQL("DROP TABLE IF EXISTS booking");
        Database.execSQL("DROP TABLE IF EXISTS user");

        onCreate(Database);

    }

    public String insert_data(String name, int phone , String dis , String email, String pass, String gender)
    {
        SQLiteDatabase sdata =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name",name);
        values.put("Phone",phone);
        values.put("District",dis);
        values.put("Email",email);
        values.put("Password",pass);
        values.put("Gender",gender);
        long r = sdata.insert("user",null,values);
        if (r == -1)
            return "Invaild data";
        else
            return "Data Saved";
    }

    public String insert_booking_info(int numberofpersons, String dateofbooking, int userid)
    {
        SQLiteDatabase bdata =this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("NumberOfPersons",numberofpersons);
        content.put("DateOfBooking",dateofbooking);
        content.put("UserId",userid);

        long c = bdata.insert("booking",null,content);
        if(c ==-1)
        {
            return " Invaild data";
        }
        else {
            book_info.booking_number = c;
            book_info.dateofbooking = dateofbooking;
            book_info.numberofpersons = numberofpersons;
            return "Your Reservation is " + c;
        }
    }

    public long delete_booking_info(String bookingnum)
    {
        SQLiteDatabase mydata =this.getWritableDatabase();

        long v = mydata.delete("booking","booking_number = "+bookingnum,null);
        return v;
    }

    public Boolean check_data(EditText email, EditText pass)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cu = database.rawQuery("SELECT * FROM user WHERE Email = ? and Password = ?", new String[]{email.getText().toString(),pass.getText().toString()});
        if(cu.moveToFirst()) {
            user_info.user = cu;
            return true;
        }
        return false;
    }

    public Boolean check_id(int id)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM booking WHERE UserId = ?",new String[]{String.valueOf(user_info.user.getInt(0))});
        if(c.moveToFirst())
        {
            user_info.c_display = c;
            return true;
        }
        return false;
    }
}