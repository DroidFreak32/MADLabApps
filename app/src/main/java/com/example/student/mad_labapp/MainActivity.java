package com.example.student.mad_labapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    RadioGroup genderGroup;
    RadioButton selectedGender;
    CheckBox qual10, qual12, qualBE;
    EditText name, address;
    String qualifications;
    String resumeDetails;
    ArrayList<String> person;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        genderGroup = findViewById(R.id.gender);
        qual10 = findViewById(R.id.qual10);
        qual12 = findViewById(R.id.qual12);
        qualBE = findViewById(R.id.qualBE);
        button = findViewById(R.id.button);
        person = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                resumeDetails = new String[4]; // Name, Gender, Qual & Addr
                resumeDetails = "Name: " + name.getText().toString();
                int selectedGenderID = genderGroup.getCheckedRadioButtonId();
                selectedGender = findViewById(selectedGenderID);
                resumeDetails += "\nGender: " + selectedGender.getText().toString();
                qualifications = getQualification();
                resumeDetails += qualifications;
                resumeDetails += "\nAddress:\n" + address.getText().toString();
                person.add(resumeDetails);
                adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.resume_list, person);
                ListView resumeList = findViewById(R.id.resumeList);
                resumeList.setAdapter(adapter);

            }
        });

    }

    private String getQualification() {
        String temp = "\nQualifications are:";
        if (qual10.isChecked())
            temp += " 10th";
        if (qual12.isChecked())
            temp += " 12th";
        if (qualBE.isChecked())
            temp += " BE";
        return temp;
    }
}
