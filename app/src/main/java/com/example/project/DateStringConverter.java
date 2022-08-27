package com.example.project;

import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;

public class DateStringConverter {
    public boolean checkdate(String StringDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(StringDate);
        Date current = Calendar.getInstance().getTime();
        String currentstring = sdf.format(current);
        current = sdf.parse(currentstring);
        if(date.after(current)) {
            return true;
        }
        else{
            return false;
        }
    }
}
