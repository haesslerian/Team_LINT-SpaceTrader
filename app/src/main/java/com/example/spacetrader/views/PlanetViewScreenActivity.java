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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.PlanetViewScreenViewModel;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Displays the planet the user is currently on
 */
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

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

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


        Toast.makeText(this, "A random event has occurred in the market!",
            Toast.LENGTH_LONG).show();
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

    private void updateValues(Repository repository){
        SolarSystem currentSystem = repository.getUniverse().getSolarSystemHashMap().get(repository.getCurrentLocation());
        planetName.setText(currentSystem.getName());
        planetResources.setText(currentSystem.getResources().toString());
        planetTechLevel.setText(currentSystem.getTechLevel().toString());
    }

    /**
     * Allows the user to go to the market for the planet
     *
     * @param view the screen to display
     */
    public void goToMarket(View view){
        Intent marketScreen = new Intent(this, BuyGoodsActivity.class);
        startActivity(marketScreen);
    }

    /**
     * Allows the user to go to the travel screen
     *
     * @param view the screen to display
     */
    public void goToTravel(View view){
        Intent travelScreen = new Intent(this, TravelScreenActivity.class);
        startActivity(travelScreen);
    }


}
