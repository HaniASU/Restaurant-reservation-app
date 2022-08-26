package com.example.project.data;

public class book_info_cursor
{

    private int booking_number, numberofpersons, userid;
    private String dateofbooking;

    public book_info_cursor (int booking_number,int numberofpersons,String dateofbooking,int userid )
    {
        this.booking_number = booking_number;
        this.numberofpersons = numberofpersons;
        this.dateofbooking = dateofbooking;
        this.userid = userid;
    }

    public int getBooking_number() {
        return booking_number;
    }

    public void setBooking_number(int booking_number) {
        this.booking_number = booking_number;
    }

    public int getNumberofpersons() {
        return numberofpersons;
    }

    public void setNumberofpersons(int numberofpersons) {
        this.numberofpersons = numberofpersons;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDateofbooking() {
        return dateofbooking;
    }

    public void setDateofbooking(String dateofbooking) {
        this.dateofbooking = dateofbooking;
    }
}
