package com.login.radsapolaznicima.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.login.radsapolaznicima.Student;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    // DB name and version
    public static final String DATABASE_NAME = "Students";
    public static final int DATABASE_VERSION = 1;


    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DataBaseContract.StudenTable.SQL_CREATE_STUDENTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DataBaseContract.StudenTable.SQL_DELETE_TABLE_ITEMS);
        onCreate(db);

    }


//    public Cursor getQueryListContents(){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor data = db.rawQuery("SELECT * FROM " + DataBaseContract.StudenTable.TABLE_NAME + " WHERE " + DataBaseContract.StudenTable.COLUMN_NAME_STUDENT_POINTS + " > 80 ORDER BY "  + DataBaseContract.StudenTable.COLUMN_NAME_STUDENT_POINTS +  " DESC LIMIT 5", null);
//
//
//        return data;
//
//    }

    public ArrayList<Student> getAllData(){

        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DataBaseContract.StudenTable.TABLE_NAME + " WHERE " + DataBaseContract.StudenTable.COLUMN_NAME_STUDENT_POINTS + " > 80 ORDER BY "  + DataBaseContract.StudenTable.COLUMN_NAME_STUDENT_POINTS +  " DESC LIMIT 5", null);

        while (cursor.moveToNext()){

            String fname = cursor.getString(1);
            String lname = cursor.getString(2);
            int year = cursor.getInt(3);
            int points = cursor.getInt(4);

            Student student = new Student(fname, lname, year, points);

            arrayList.add(student);

        }
        return arrayList;

    }




}
