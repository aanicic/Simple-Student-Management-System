package com.login.radsapolaznicima.database;

import android.provider.BaseColumns;

public class DataBaseContract {


    private DataBaseContract(){

    }

    public static class StudenTable implements BaseColumns {

        // tables rows
        public static final String TABLE_NAME = "students";

        public static final String COLUMN_NAME_FIRST_NAME = "fname";
        public static final String COLUMN_NAME_LAST_NAME = "lname";
        public static final String COLUMN_NAME_STUDENT_YEAR = "year";
        public static final String COLUMN_NAME_STUDENT_POINTS = "points";

        // create database
        public static final String SQL_CREATE_STUDENTS_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME_FIRST_NAME + " TEXT NOT NULL, " +
                        COLUMN_NAME_LAST_NAME + " TEXT NOT NULL, " +
                        COLUMN_NAME_STUDENT_YEAR + " INTEGER NOT NULL, " +
                        COLUMN_NAME_STUDENT_POINTS + " INTEGER);";


        // DELETE TABLES
        public static final String SQL_DELETE_TABLE_ITEMS =
            "DROP TABLE IF EXISTS " + TABLE_NAME;




    }


}
