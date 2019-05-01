package com.example.spacetrader.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.spacetrader.R;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySong = MediaPlayer.create(MainActivity.this, R.raw.music);
        mySong.start();
        Intent intent = new Intent(this, TitleScreenActivity.class);
        startActivity(intent);

    }
}
