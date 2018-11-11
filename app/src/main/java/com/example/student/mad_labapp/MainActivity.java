package com.example.student.mad_labapp;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar pgsBar;
    int i = 0;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pgsBar = findViewById(R.id.pBar);
        txtView = findViewById(R.id.tView);
        Button btn = findViewById(R.id.btnShow);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View v) {
                pgsBar.setProgress(0);

                new AsyncTask<String, Integer, String>() {
                    @Override
                    protected String doInBackground(String[] params) {
                        int i = 0;
                        int max = Integer.parseInt(params[0]);
                        while (i < max) {
                            try {
                                Thread.sleep(100);
                                i++;
                                publishProgress(i);
                            } catch (Exception ex) {
                                Log.e("error", ex.toString());
                            }
                        }
                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        super.onProgressUpdate(values);
                        pgsBar.setProgress(values[0]);
                        txtView.setText(values[0].toString());
                    }
                }.execute("100");
//                new MyClass().execute("100");
            }
        });
    }

//    static class MyClass extends AsyncTask<String, Integer, String>{
//
//        @Override
//        protected String doInBackground(String[] params) {
//            int i = 0;
//            int max = Integer.parseInt(params[0]);
//            while(i < max) {
//                try {
//                    Thread.sleep(100);
//                    i++;
//                    publishProgress(i);
//                } catch (Exception ex) {
//                    Log.e("error", ex.toString());
//                }
//            }
//            return null;
//        }
//        @Override
//        protected void onProgressUpdate(Integer... values)
//        {
//            super.onProgressUpdate(values);
//            pgsBar.setProgress(values[0]);
//            txtView.setText(values[0].toString());
//        }
//    }
}

