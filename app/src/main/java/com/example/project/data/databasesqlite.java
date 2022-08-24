package com.example.project.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class databasesqlite extends SQLiteOpenHelper {
    public static final String databaseName ="app.db";

    public databasesqlite(Context con)
    {
        super(con,databaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase Database) {
        Database.execSQL("create table user (Id INTEGER primary key AUTOINCREMENT ,Name TEXT ,Phone INTEGER, District TEXT ,Email TEXT,Password TEXT ,Gender TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase Database, int i, int i1) {
        Database.execSQL("DROP TABLE IF EXISTS user");
        onCreate(Database);

    }

    public String insert_data(String name, int phone , String dis , String email, String pass, String gender)
    {
        SQLiteDatabase Sdata =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name",name);
        values.put("Phone",phone);
        values.put("District",dis);
        values.put("Email",email);
        values.put("Password",pass);
        values.put("Gender",gender);
        long r = Sdata.insert("user",null,values);
        if (r == -1)
            return "Invaild data";
        else
            return "Data Saved";

    }

    public Boolean check_data(EditText email, EditText pass)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cu = database.rawQuery("SELECT * FROM user WHERE Email = ? and Password = ?", new String[]{email.getText().toString(),pass.getText().toString()});
        if(cu.moveToFirst()) {
            user_info.user_id = cu.getInt(0);
            user_info.user_name = cu.getString(1);
            user_info.user_phone = cu.getInt(2);
            user_info.user_district = cu.getString(3);
            user_info.user_email = cu.getString(4);
            user_info.user_password = cu.getString(5);
            user_info.user_gender = cu.getString(6);
            return true;
        }

        return false;
    }
}
