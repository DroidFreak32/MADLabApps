package com.example.student.mad_labapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String[] mobileArray = {
            "Biotechnology",
            "Civil Engineering",
            "Computer Science and Engineering",
            "Electronics & Communications Engineering",
            "Electrical & Electronics Engineering",
            "Information Science and Engineering",
            "Mechanical Engineering"
    };
    ArrayAdapter adapter;
    DatePicker date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this, R.layout.course_item, mobileArray);

        date = findViewById(R.id.datePicker);

        ListView listView = findViewById(R.id.courseList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String course = (String) adapter.getItem(position);
                String dateString = date.getDayOfMonth() + "/" + ( 1 + date.getMonth() ) + "/" +
                        date.getYear();
                String toastString = "Joined on : " + dateString + "\ncourse : " + course;
                Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_SHORT).show();
            }
        });

    }
}