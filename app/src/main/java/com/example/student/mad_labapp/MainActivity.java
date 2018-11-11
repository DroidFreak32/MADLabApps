package com.example.student.mad_labapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button colorButton;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorButton = findViewById(R.id.colorButton);
        rl = findViewById(R.id.rl);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random ranColor = new Random();
                rl.setBackgroundColor(Color.rgb(
                        ranColor.nextInt(256),  // R
                        ranColor.nextInt(256),  // G
                        ranColor.nextInt(256)   // B
                ));
            }
        });
    }
}
