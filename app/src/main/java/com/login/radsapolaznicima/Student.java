package com.login.radsapolaznicima;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.login.radsapolaznicima.database.DataBaseContract;


public class Student {

    private String name;
    private String lname;
    private int year;
    private int points;

    private Context context;
    private DataBaseContract dataBaseContract;
    private SQLiteDatabase data;


    public Student(String name, String lname, int year, int points) {
        this.name = name;
        this.lname = lname;
        this.year = year;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
