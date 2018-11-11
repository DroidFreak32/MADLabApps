package com.example.student.mad_labapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    MediaPlayer music;

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        music = MediaPlayer.create(this, R.raw.music); //music file location
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        music.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        music.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
