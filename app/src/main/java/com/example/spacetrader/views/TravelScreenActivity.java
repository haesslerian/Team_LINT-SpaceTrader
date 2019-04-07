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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.TravelScreenViewModel;

import java.util.List;

public class TravelScreenActivity extends AppCompatActivity {

    private Spinner planetSpinner;
    private TravelScreenViewModel mTravelScreenViewModel;
    private TextView fuelValue, locationValue, distanceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_screen);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        planetSpinner = findViewById(R.id.travelSpinner);
        fuelValue = findViewById(R.id.fuelValue);
        locationValue = findViewById(R.id.locationValue);
        distanceValue = findViewById(R.id.travelAmountValue);
        mTravelScreenViewModel = ViewModelProviders.of(this).get(TravelScreenViewModel.class);
        mTravelScreenViewModel.init();
        mTravelScreenViewModel.getRepository().observe(this, new Observer<Repository>() {
            @Override
            public void onChanged(@Nullable Repository repository) {
                updateValues(repository);
            }
        });
        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                planetSpinner.setSelection(position);
                updateSpinnerValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
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

    private void updateSpinnerValues(){
        locationValue.setText((String)planetSpinner.getSelectedItem());
        distanceValue.setText(Integer.toString(mTravelScreenViewModel.calculateDistance((String)planetSpinner.getSelectedItem())));
    }

    private void updateValues(Repository repository){
        fuelValue.setText(Integer.toString(repository.getUserPlayer().getCurrentShip().getCurrentFuel()));
        List<String> strings = mTravelScreenViewModel.getNearbySystems();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, strings);
        planetSpinner.setAdapter(adapter);
    }

    public void travel(View view){
        mTravelScreenViewModel.goToSystem((String)planetSpinner.getSelectedItem());
        goBack(view);
    }

    public void goBack(View view){
        Intent viewScreen = new Intent(this, PlanetViewScreenActivity.class);
        startActivity(viewScreen);
    }

    public void buyFuel(View view){
        mTravelScreenViewModel.buyFuel();
    }

}

