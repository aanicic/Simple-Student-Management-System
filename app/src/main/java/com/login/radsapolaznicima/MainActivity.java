package com.login.radsapolaznicima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.login.radsapolaznicima.database.DataBaseContract;
import com.login.radsapolaznicima.database.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    EditText imeStudenta, prezimeStudenta, godinaStudiranja, brojBodova;
    Button dodajStudenta, prikaziStudente, brisiBazu;

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // database
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();


        imeStudenta = findViewById(R.id.imeStudenta);
        prezimeStudenta = findViewById(R.id.prezimeStudenta);
        godinaStudiranja = findViewById(R.id.skolskaGodina);
        brojBodova = findViewById(R.id.brojBodova);
        dodajStudenta = findViewById(R.id.dodajStudenta);
        prikaziStudente = findViewById(R.id.listaStudanata);
        brisiBazu = findViewById(R.id.izbrisiBazu);

        dodajStudenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudnets();
            }
        });

        prikaziStudente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrikazStudenata.class);
                startActivity(intent);
            }
        });


        brisiBazu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAll();
            }
        });


    }


    private void addStudnets(){

        // ako je ovo tačno ne dodaji ništa u bazu
        if (imeStudenta.getText().toString().trim().length() == 0 || prezimeStudenta.getText().toString().trim().length() == 0 || godinaStudiranja.getText().toString().length() == 0 || brojBodova.getText().toString().trim().length() == 0){
            return;
        }




        String name = imeStudenta.getText().toString();
        String  lname = prezimeStudenta.getText().toString();
        String year = godinaStudiranja.getText().toString();
        String points = brojBodova.getText().toString();





        // Add Content values
        ContentValues cv = new ContentValues();
        cv.put(DataBaseContract.StudenTable.COLUMN_NAME_FIRST_NAME, name);
        cv.put(DataBaseContract.StudenTable.COLUMN_NAME_LAST_NAME, lname);
        cv.put(DataBaseContract.StudenTable.COLUMN_NAME_STUDENT_YEAR, year);
        cv.put(DataBaseContract.StudenTable.COLUMN_NAME_STUDENT_POINTS, points);

        //iNSERT INTO DATABASE
        db.insert(DataBaseContract.StudenTable.TABLE_NAME, null, cv);

        imeStudenta.getText().clear();
        prezimeStudenta.getText().clear();
        godinaStudiranja.getText().clear();
        brojBodova.getText().clear();



    }


    public void deleteAll()
    {
        db.execSQL("delete from "+ DataBaseContract.StudenTable.TABLE_NAME);
        db.close();
    }

}
