package com.example.student.mad_labapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button insert;
    Button select;
    EditText name, usn, phone;
    List<String> studentList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this).getWritableDatabase();
        insert = findViewById(R.id.insertButton);
        select = findViewById(R.id.getValues);
        name = findViewById(R.id.name_input);
        usn = findViewById(R.id.usn_input);
        phone = findViewById(R.id.phone_input);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inpName, inpUSN, inpPhone;
                inpName = name.getText().toString();
                inpUSN = usn.getText().toString();
                inpPhone = phone.getText().toString();
                if (inpName.equals("") || inpUSN.equals("") || inpPhone.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Enter all values", Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("name", inpName);
                    values.put("usn", inpUSN);
                    values.put("phone", inpPhone);
                    db.insert("student", null, values);
                    Toast.makeText(getApplicationContext(), "Inserted!", Toast.LENGTH_SHORT).show();

                }
            }

        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList = new ArrayList<>();
                Cursor cursor = db.rawQuery("select * from student", null);
                if (cursor.getCount() <= 0) {
                    studentList.add("No values were present");

                } else {
                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToNext();
                        String stud = "";
                        stud += " Name : " + cursor.getString(0);
                        stud += "\n USN : " + cursor.getString(1);
                        stud += "\n Phone Number: " + cursor.getString(2);
                        studentList.add(stud);

                    }

                }
                cursor.close();
                adapter = new ArrayAdapter<String>(
                        getApplicationContext(), R.layout.student_list, studentList);
                ListView listView = findViewById(R.id.studentList);
                listView.setAdapter(adapter);

            }

        });
    }

}