package com.example.spacetrader.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quit_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.quit_game) {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    public void generateUniverse(View view){
        mCreateCharacterSummaryViewModel.generateUniverse();
        Intent nextScreen = new Intent(this, PlanetViewScreenActivity.class);
        startActivity(nextScreen);
    }
}
