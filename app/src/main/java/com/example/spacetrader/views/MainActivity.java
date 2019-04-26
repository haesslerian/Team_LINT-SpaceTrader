package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.spacetrader.R;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Starts up the game and goes to the title screen
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, TitleScreenActivity.class);
        startActivity(intent);
    }
}
