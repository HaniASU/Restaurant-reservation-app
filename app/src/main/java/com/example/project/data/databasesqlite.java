package com.example.project.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class databasesqlite extends SQLiteOpenHelper {
    public static final String databaseName ="app.db";

    public databasesqlite(Context con)
    {
        super(con,databaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase Database) {
        Database.execSQL("create table user (Id INTEGER primary key AUTOINCREMENT ,Name TEXT ,Phone INTEGER, District TEXT ,Email TEXT,Password TEXT ,Gender TEXT )");
        Database.execSQL("create table booking_info (booking_number INTEGER primary key AUTOINCREMENT,NumberOfPersons INTEGER,DateOfBooking TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase Database, int i, int i1) {
        Database.execSQL("DROP TABLE IF EXISTS user");
        Database.execSQL("DROP TABLE IF EXISTS booking_info");
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

    public String insert_booking_info(int numberofpersons,String dateofbooking)
    {
        SQLiteDatabase data =this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("NumberOfPersons",numberofpersons);
        content.put("DateOfBooking",dateofbooking);
        long c = data.insert("booking_info",null,content);
        if (c == -1)
            return "Invaild Data";
        else
            return "Book Successfully" +
                    "And" +
                    "Your Booking Number is " + "";
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
}
