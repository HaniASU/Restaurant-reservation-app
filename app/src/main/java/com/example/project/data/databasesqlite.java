package com.example.project.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

    public ArrayList<user> get_data()
    {
        ArrayList<user> arrayList =new ArrayList<user>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cu = database.rawQuery("select * from user",null);
        cu.moveToFirst();
        while (cu.isAfterLast() == false)
        {
            arrayList.add(new user(cu.getInt(0),cu.getString(1),cu.getInt(2),cu.getString(3),cu.getString(4), cu.getString(5), cu.getString(6)));
            cu.moveToNext();
        }
        return arrayList;
    }
}
