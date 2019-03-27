package com.example.spacetrader.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.CreateCharacterSummaryViewModel;

public class CreateCharacterSummaryActivity extends AppCompatActivity {

    private TextView playerName;
    private TextView difficulty;
    private TextView pilotSkill;
    private TextView fighterSkill;
    private TextView traderSkill;
    private TextView engineerSkill;
    private TextView credits;
    private TextView shipType;
    private CreateCharacterSummaryViewModel mCreateCharacterSummaryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character_summary);
        playerName = findViewById(R.id.nameDisplay);
        difficulty = findViewById(R.id.difficultyDisplay);
        pilotSkill = findViewById(R.id.pilotDisplay);
        fighterSkill = findViewById(R.id.fighterDisplay);
        traderSkill = findViewById(R.id.traderDisplay);
        engineerSkill = findViewById(R.id.engineerDisplay);
        credits = findViewById(R.id.creditsDisplay);
        shipType = findViewById(R.id.shipDisplay);
        mCreateCharacterSummaryViewModel = ViewModelProviders.of(this).get(CreateCharacterSummaryViewModel.class);
        mCreateCharacterSummaryViewModel.init();
        mCreateCharacterSummaryViewModel.getRepository().observe(this, new Observer<Repository>() {
            @Override
            public void onChanged(@Nullable Repository repository) {
                updateValues(repository);
            }
        });
    }

    public void updateValues(Repository newValues){
        playerName.setText(newValues.getUserPlayer().getName());
        difficulty.setText(newValues.getUserPlayer().getDifficulty().toString());
        pilotSkill.setText(Integer.toString(newValues.getUserPlayer().getSkillPilot()));
        fighterSkill.setText(Integer.toString(newValues.getUserPlayer().getSkillFighter()));
        traderSkill.setText(Integer.toString(newValues.getUserPlayer().getSkillTrader()));
        engineerSkill.setText(Integer.toString(newValues.getUserPlayer().getSkillEngineer()));
        credits.setText(Integer.toString(newValues.getUserPlayer().getCredits()));
        shipType.setText(newValues.getUserPlayer().getCurrentShip().getCurrentType().toString());
    }

    public void exitGame(View view){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    public void generateUniverse(View view){
        mCreateCharacterSummaryViewModel.generateUniverse();
        Intent nextScreen = new Intent(this, PlanetViewScreenActivity.class);
        startActivity(nextScreen);
    }
}
