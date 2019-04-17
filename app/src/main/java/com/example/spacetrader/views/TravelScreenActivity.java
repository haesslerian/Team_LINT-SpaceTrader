package com.example.spacetrader.views;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.TravelScreenViewModel;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Travel screen activity.
 */
public class TravelScreenActivity extends AppCompatActivity {

    private Spinner planetSpinner;
    private TravelScreenViewModel mTravelScreenViewModel;
    private TextView fuelValue;
    private TextView locationValue;
    private TextView distanceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_screen);
        planetSpinner = findViewById(R.id.travelSpinner);
        fuelValue = findViewById(R.id.fuelValue);
        locationValue = findViewById(R.id.locationValue);
        distanceValue = findViewById(R.id.travelAmountValue);
        mTravelScreenViewModel = ViewModelProviders.of(this).get(TravelScreenViewModel.class);
        mTravelScreenViewModel.init();
        mTravelScreenViewModel.getRepository().observe(this, new Observer<Repository>() {
            @Override
            public void onChanged(@Nullable Repository repository) {
                updateValues(Objects.requireNonNull(repository));
            }
        });
        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parentView, View selectedItemView, int position, long id) {
                planetSpinner.setSelection(position);
                updateSpinnerValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    private void updateSpinnerValues(){
        locationValue.setText((String)planetSpinner.getSelectedItem());
        distanceValue.setText(Integer.toString(
                mTravelScreenViewModel.calculateDistance(
                        (String)planetSpinner.getSelectedItem())));
    }

    private void updateValues(Repository repository){
        fuelValue.setText(Integer.toString(repository.getCurrentShipFuel()));
        List<String> strings = mTravelScreenViewModel.getNearbySystems();
        SpinnerAdapter adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, strings);
        planetSpinner.setAdapter(adapter);
    }

    /**
     * Travel.
     *
     * @param view the view
     */
    public void travel(final View view){
        if(ThreadLocalRandom.current().nextInt(0, 4) == 0) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Pocket Change! You find 200 credits lying around your ship.");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            mTravelScreenViewModel.goToSystem(
                                    (String)planetSpinner.getSelectedItem(), true);
                            goBack();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        else{
            mTravelScreenViewModel.goToSystem((String)planetSpinner.getSelectedItem(), false);
            goBack();
        }
    }

    private void goBack(){
        Intent viewScreen = new Intent(this, PlanetViewScreenActivity.class);
        startActivity(viewScreen);
    }

    /**
     * Go back button.
     *
     * @param view the view
     */
    public void goBackButton(View view){
        Intent viewScreen = new Intent(this, PlanetViewScreenActivity.class);
        startActivity(viewScreen);
    }

    /**
     * Buy fuel.
     *
     * @param view the view
     */
    public void buyFuel(View view){
        mTravelScreenViewModel.buyFuel();
    }

}

