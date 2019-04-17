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
import com.example.spacetrader.entity.SkillTypes;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.SetSkillsViewModel;

import java.util.Objects;

/**
 * The type Set skills activity.
 */
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
                updateTotal(Objects.requireNonNull(integer));
            }
        });
    }

    /**
     * Go to summary.
     *
     * @param view the view
     */
    public void goToSummary(View view){
        Intent intent = new Intent(this, CreateCharacterSummaryActivity.class);
        startActivity(intent);
    }


    private void updateValues(Repository values){
        pilotPointsTextView.setText(Integer.toString(values.getSkillPilot()));
        fighterPointsTextView.setText(Integer.toString(values.getSkillFighter()));
        traderPointsTextView.setText(Integer.toString(values.getSkillTrader()));
        engineerPointsTextView.setText(Integer.toString(values.getSkillEngineer()));
    }

    private void updateTotal(Integer total){
        totalPointsTextView.setText(total.toString());
    }

    /**
     * Increment pilot.
     *
     * @param view the view
     */
    public void incrementPilot(View view){
        mSetSkillsViewModel.updatePlayerSkills(
                SkillTypes.PILOT, mSetSkillsViewModel.getSkillPilot() + 1);
    }

    /**
     * Increment fighter.
     *
     * @param view the view
     */
    public void incrementFighter(View view){
        mSetSkillsViewModel.updatePlayerSkills(
                SkillTypes.FIGHTER, mSetSkillsViewModel.getSkillFighter() + 1);
    }

    /**
     * Increment trader.
     *
     * @param view the view
     */
    public void incrementTrader(View view){
        mSetSkillsViewModel.updatePlayerSkills(
                SkillTypes.TRADER, mSetSkillsViewModel.getSkillTrader() + 1);
    }

    /**
     * Increment engineer.
     *
     * @param view the view
     */
    public void incrementEngineer(View view){
        mSetSkillsViewModel.updatePlayerSkills(
                SkillTypes.ENGINEER,mSetSkillsViewModel.getSkillEngineer() + 1);
    }

    /**
     * Decrement pilot.
     *
     * @param view the view
     */
    public void decrementPilot(View view){
        mSetSkillsViewModel.updatePlayerSkills(
                SkillTypes.PILOT, mSetSkillsViewModel.getSkillPilot() - 1);
    }

    /**
     * Decrement fighter.
     *
     * @param view the view
     */
    public void decrementFighter(View view){
        mSetSkillsViewModel.updatePlayerSkills(
                SkillTypes.FIGHTER, mSetSkillsViewModel.getSkillFighter() - 1);
    }

    /**
     * Decrement trader.
     *
     * @param view the view
     */
    public void decrementTrader(View view){
        mSetSkillsViewModel.updatePlayerSkills(
                SkillTypes.TRADER, mSetSkillsViewModel.getSkillTrader() - 1);
    }

    /**
     * Decrement engineer.
     *
     * @param view the view
     */
    public void decrementEngineer(View view){
        mSetSkillsViewModel.updatePlayerSkills(
                SkillTypes.ENGINEER, mSetSkillsViewModel.getSkillEngineer() - 1);
    }
}
