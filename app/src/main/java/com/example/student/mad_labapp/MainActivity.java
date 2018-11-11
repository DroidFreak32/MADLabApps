package com.example.student.mad_labapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    Log.e(getPackageName(), "Exception in sleep");
                } finally {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        }.start();
    }
}
