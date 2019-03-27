package com.example.spacetrader.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.PlanetViewScreenViewModel;

public class PlanetViewScreenActivity extends AppCompatActivity {

    private TextView planetName;
    private TextView planetTechLevel;
    private TextView planetResources;
    private Button goToMarket;
    private PlanetViewScreenViewModel mPlanetViewScreenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_view_screen);
        planetName = findViewById(R.id.nameValue);
        planetTechLevel = findViewById(R.id.techLevelValue);
        planetResources = findViewById(R.id.resourceValue);
        goToMarket = findViewById(R.id.goToMarket);
        mPlanetViewScreenViewModel = ViewModelProviders.of(this).get(PlanetViewScreenViewModel.class);
        mPlanetViewScreenViewModel.init();
        mPlanetViewScreenViewModel.getRepository().observe(this, new Observer<Repository>() {
            @Override
            public void onChanged(@Nullable Repository repository) {
                updateValues(repository);
            }
        });
    }

    private void updateValues(Repository repository){
        SolarSystem currentSystem = repository.getUniverse().getSolarSystemHashMap().get(repository.getCurrentLocation());
        planetName.setText(currentSystem.getName());
        planetResources.setText(currentSystem.getResources().toString());
        planetTechLevel.setText(currentSystem.getTechLevel().toString());
    }



    public void goToMarket(View view){
        Intent marketScreen = new Intent(this, BuyGoodsActivity.class);
        startActivity(marketScreen);
    }

    public void goToMap(View view){
        Intent intent = new Intent(this, MapScreenActivity.class);
        startActivity(intent);
    }


}
