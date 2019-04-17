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
import com.example.spacetrader.viewmodel.PlanetViewScreenViewModel;

import java.io.File;
import java.util.Objects;

/**
 * The type Planet view screen activity.
 */
public class PlanetViewScreenActivity extends AppCompatActivity {

    private TextView planetName;
    private TextView planetTechLevel;
    private TextView planetResources;
    private PlanetViewScreenViewModel mPlanetViewScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_view_screen);
        planetName = findViewById(R.id.nameValue);
        planetTechLevel = findViewById(R.id.techLevelValue);
        planetResources = findViewById(R.id.resourceValue);
        mPlanetViewScreenViewModel = ViewModelProviders.of(
                this).get(PlanetViewScreenViewModel.class);
        mPlanetViewScreenViewModel.init();
        mPlanetViewScreenViewModel.getRepository().observe(this, new Observer<Repository>() {
            @Override
            public void onChanged(@Nullable Repository repository) {
                updateValues(Objects.requireNonNull(repository));
            }
        });
    }

    private void updateValues(Repository repository){
        planetName.setText(repository.getCurrentSystemName());
        planetResources.setText(repository.getCurrentSystemResources());
        planetTechLevel.setText(repository.getCurrentSystemTechLevel());
    }


    /**
     * Go to market.
     *
     * @param view the view
     */
    public void goToMarket(View view){
        Intent marketScreen = new Intent(this, BuyGoodsActivity.class);
        startActivity(marketScreen);
    }

    /**
     * Save game.
     *
     * @param view the view
     */
    public void saveGame(View view){
        File file = new File(this.getFilesDir(), "data.bin");
        mPlanetViewScreenViewModel.saveGame(file);
    }

    /**
     * Load game.
     *
     * @param view the view
     */
    public void loadGame(View view){
        File file = new File(this.getFilesDir(), "data.bin");
        mPlanetViewScreenViewModel.loadGame(file);
    }


    /**
     * Go to travel.
     *
     * @param view the view
     */
    public void goToTravel(View view){
        Intent travelScreen = new Intent(this, TravelScreenActivity.class);
        startActivity(travelScreen);
    }


}
