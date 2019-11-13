package com.login.radsapolaznicima;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.login.radsapolaznicima.database.DatabaseHelper;

import java.util.ArrayList;

public class PrikazStudenata extends AppCompatActivity {

    SQLiteDatabase db;
    DatabaseHelper dbHelper;

    ListView listView;

    ArrayList<Student>arrayList;
    StudentAdapter studentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prikaz_studenata);


        listView = (ListView) findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(this);

        arrayList = new ArrayList<Student>();
        loadContentInListView();




        }

    private void loadContentInListView() {

        arrayList = dbHelper.getAllData();
        studentAdapter = new StudentAdapter(this, arrayList);
        listView.setAdapter(studentAdapter);

        studentAdapter.notifyDataSetChanged();

    }


}
