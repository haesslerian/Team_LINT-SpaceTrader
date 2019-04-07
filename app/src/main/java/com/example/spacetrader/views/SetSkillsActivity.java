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
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.SkillTypes;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.SetSkillsViewModel;

public class SetSkillsActivity extends AppCompatActivity {

    private SetSkillsViewModel mSetSkillsViewModel;
    private TextView totalPointsTextView;
    private TextView pilotPointsTextView;
    private TextView fighterPointsTextView;
    private TextView traderPointsTextView;
    private TextView engineerPointsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_skills);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        totalPointsTextView = findViewById(R.id.totalPointsNum);
        pilotPointsTextView = findViewById(R.id.pilotSkillAmount);
        fighterPointsTextView = findViewById(R.id.fighterSkillAmount);
        traderPointsTextView = findViewById(R.id.traderSkillAmount);
        engineerPointsTextView = findViewById(R.id.engineerSkillAmount);
        mSetSkillsViewModel = ViewModelProviders.of(this).get(SetSkillsViewModel.class);
        mSetSkillsViewModel.init();
        mSetSkillsViewModel.getRepository().observe(this, new Observer<Repository>() {
            @Override
            public void onChanged(@Nullable Repository repository) {
                if(repository != null){
                    updateValues(repository);
                }
            }
        });
        mSetSkillsViewModel.getTotalPoints().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                updateTotal(integer);
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

    public void goToSummary(View view){
        Intent intent = new Intent(this, CreateCharacterSummaryActivity.class);
        startActivity(intent);
    }


    private void updateValues(Repository values){
        pilotPointsTextView.setText(Integer.toString(values.getUserPlayer().getSkillPilot()));
        fighterPointsTextView.setText(Integer.toString(values.getUserPlayer().getSkillFighter()));
        traderPointsTextView.setText(Integer.toString(values.getUserPlayer().getSkillTrader()));
        engineerPointsTextView.setText(Integer.toString(values.getUserPlayer().getSkillEngineer()));
    }

    private void updateTotal(Integer total){
        totalPointsTextView.setText(total.toString());
    }

    public void incrementPilot(View view){
        mSetSkillsViewModel.updatePlayerSkills(SkillTypes.PILOT,mSetSkillsViewModel.getRepository().getValue().getUserPlayer().getSkillPilot() + 1);
    }

    public void incrementFighter(View view){
        mSetSkillsViewModel.updatePlayerSkills(SkillTypes.FIGHTER,mSetSkillsViewModel.getRepository().getValue().getUserPlayer().getSkillFighter() + 1);
    }

    public void incrementTrader(View view){
        mSetSkillsViewModel.updatePlayerSkills(SkillTypes.TRADER,mSetSkillsViewModel.getRepository().getValue().getUserPlayer().getSkillTrader() + 1);
    }

    public void incrementEngineer(View view){
        mSetSkillsViewModel.updatePlayerSkills(SkillTypes.ENGINEER,mSetSkillsViewModel.getRepository().getValue().getUserPlayer().getSkillEngineer() + 1);
    }

    public void decrementPilot(View view){
        mSetSkillsViewModel.updatePlayerSkills(SkillTypes.PILOT,mSetSkillsViewModel.getRepository().getValue().getUserPlayer().getSkillPilot() - 1);
    }

    public void decrementFighter(View view){
        mSetSkillsViewModel.updatePlayerSkills(SkillTypes.FIGHTER,mSetSkillsViewModel.getRepository().getValue().getUserPlayer().getSkillFighter() - 1);
    }

    public void decrementTrader(View view){
        mSetSkillsViewModel.updatePlayerSkills(SkillTypes.TRADER,mSetSkillsViewModel.getRepository().getValue().getUserPlayer().getSkillTrader() - 1);
    }

    public void decrementEngineer(View view){
        mSetSkillsViewModel.updatePlayerSkills(SkillTypes.ENGINEER,mSetSkillsViewModel.getRepository().getValue().getUserPlayer().getSkillEngineer() - 1);
    }
}
