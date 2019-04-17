package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.spacetrader.R;

/**
 * The type Start screen activity.
 */
public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    /**
     * Go to create character.
     *
     * @param view the view
     */
    public void goToCreateCharacter(View view){
        Intent intent = new Intent(this, CreateCharacterBasicInfoActivity.class);
        startActivity(intent);
    }
}
