package com.login.radsapolaznicima;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class StudentAdapter extends BaseAdapter {

    Context context;
    ArrayList<Student> arrayList;

    public StudentAdapter(Context context, ArrayList<Student> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.row_layout, null);
            TextView tname = (TextView)convertView.findViewById(R.id.sNameLV);
            TextView tlname = (TextView)convertView.findViewById(R.id.slNameLV);
            TextView tyear = (TextView)convertView.findViewById(R.id.sYearLV);
            TextView tpoints = (TextView)convertView.findViewById(R.id.sPointsLV);

            Student student = arrayList.get(position);

            tname.setText(student.getName());
            tlname.setText(student.getLname());
            tyear.setText(String.valueOf(student.getYear()));
            tpoints.setText(String.valueOf(student.getPoints()));

        return convertView;
    }
}
