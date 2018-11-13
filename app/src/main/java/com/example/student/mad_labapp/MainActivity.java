package com.example.student.mad_labapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button insert;
    Button call;
    EditText name, usn, phone;
    List<String> studentList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        db = new DBHelper(this).getWritableDatabase();
        db = openOrCreateDatabase("studentDB", MODE_PRIVATE, null);
        db.execSQL("create table if not exists student ( name, usn primary key, phone )");
        insert = findViewById(R.id.insertButton);
        call = findViewById(R.id.call);
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
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callUSN = usn.getText().toString();
                if (callUSN.equals(""))
                    Toast.makeText(getApplicationContext(), "Enter USN", Toast.LENGTH_SHORT).show();
                else {
                    Cursor cursor = db.rawQuery("select * from student where usn = '" + callUSN + "'", null);
                    if (cursor.getCount() != 1)
                        Toast.makeText(getApplicationContext(), "Student USN:" + callUSN + " not found!", Toast.LENGTH_SHORT).show();
                    else {
                        cursor.moveToNext();
                        String phNumber = cursor.getString(2);
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + phNumber));
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Cannot call! " + phNumber, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


    }

}