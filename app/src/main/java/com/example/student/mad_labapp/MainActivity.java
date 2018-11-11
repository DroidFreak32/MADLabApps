package com.example.student.mad_labapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText id, sub, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.mail_id);

        sub = findViewById(R.id.subject);
        message = findViewById(R.id.message);

        Button send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
//                i.setType("text/plain"); Not needed here
                i.putExtra(Intent.EXTRA_SUBJECT, sub.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                i.setData(Uri.parse("mailto:" + id.getText().toString()));
                startActivity(i);

            }
        });
    }
}