package com.example.student.mad_labapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button play, stop, color;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.Play);
        stop = findViewById(R.id.Stop);
        color = findViewById(R.id.ChangeColor);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MusicService.class));
            }

        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MusicService.class));
            }
        });
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl = findViewById(R.id.layout);
                Random gen = new Random();
                rl.setBackgroundColor(Color.rgb(
                        gen.nextInt(255),
                        gen.nextInt(255),
                        gen.nextInt(255)
                        )
                );
            }
        });
    }
}