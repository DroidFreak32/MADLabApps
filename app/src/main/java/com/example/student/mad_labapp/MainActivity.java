package com.example.student.mad_labapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mBatteryLevelText;
    ProgressBar mBatteryLevelProgress;
    BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBatteryLevelText = findViewById(R.id.textView);
        mBatteryLevelProgress = findViewById(R.id.progressBar);
        mReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                mBatteryLevelText.setText("Battery Level : " + level);
                mBatteryLevelProgress.setProgress(level);
                RelativeLayout rl = findViewById(R.id.rl);
                if (level > 60)
                    rl.setBackgroundColor(Color.GREEN);
                else if (level > 30)
                    rl.setBackgroundColor(Color.BLUE);
                else
                    rl.setBackgroundColor(Color.RED);
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        unregisterReceiver(mReceiver);
        super.onStop();
    }
}