package com.example.spacetrader.views;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.model.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapScreenActivity extends AppCompatActivity {

    private Spinner planetSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);

        planetSpinner = findViewById(R.id.travelSpinner);

        //doesn't this violate the Law of Demeter?
        final List<SolarSystem> solarSystemList = Model.getInstance().getRepository().getValue().getUniverse().getSystemList();
        List<String> systemNames = new ArrayList<>();

        for (SolarSystem system : solarSystemList) {
            systemNames.add(system.getName());
        }

        //What is resource?
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, systemNames);
      planetSpinner.setAdapter(adapter);

//    planetSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            SolarSystem system = solarSystemList.get(position);
//
//            final AlertDialog alertDialog;
//            alertDialog = new AlertDialog.Builder(MapScreenActivity.this).create();
//            alertDialog.setTitle("Dialog Button");
//            alertDialog.setMessage("This is a three-button dialog!");
//            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Travel", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int id) {
//                    //...
//                } });
//            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Close window", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int id) {
//                    alertDialog.dismiss();
//                }});
//            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Button 3 Text", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int id) {
//                    //...
//                }});
//        }
//    });


    }

    //select an item from the spinner
    //we get ahold of that object that is associated with the String name
    //we display the instance data for that Solar System
    //we calculate the hypotenuse between the two Point locations (between Player's current Point and the Solary System's)
    //if fuel is sufficient we can travel when Travel button is selected
    //if not, hitting the button pops up an error message saying "not enough fuel"
}