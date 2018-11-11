package com.example.student.mad_labapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String prefName = "pName";
    String prefTag = "pTag";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editText);
        pref = getSharedPreferences(prefName, Context.MODE_PRIVATE);
        text.setText(pref.getString(prefTag, ""));

    }

    protected void onPause() {
        super.onPause();
        editor = pref.edit();
        editor.putString(prefTag, text.getText().toString()).apply();
    }

}