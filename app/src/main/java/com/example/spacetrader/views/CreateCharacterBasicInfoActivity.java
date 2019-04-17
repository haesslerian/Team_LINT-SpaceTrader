package com.example.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.viewmodel.CreateCharacterBasicInfoViewModel;

/**
 * The type Create character basic info activity.
 */
public class CreateCharacterBasicInfoActivity extends AppCompatActivity {

    private EditText nameField;
    private Spinner difficultySpinner;
    private CreateCharacterBasicInfoViewModel mCreateCharacterBasicInfoViewModel;

    // --Commented out by Inspection (4/14/19, 7:43 PM):private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character_basic_info);
        mCreateCharacterBasicInfoViewModel = ViewModelProviders.of(this).get(
                CreateCharacterBasicInfoViewModel.class);
        mCreateCharacterBasicInfoViewModel.init();
        nameField = findViewById(R.id.player_name_input);
        difficultySpinner = findViewById(R.id.difficulty_spinner);

        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, Difficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

        //viewModel = ViewModelProviders.of(this).get(newUserViewModel.class);
    }

    /**
     * On next pressed.
     *
     * @param view the view
     */
    public void onNextPressed(View view) {
        mCreateCharacterBasicInfoViewModel.setPlayerData(
                nameField.getText().toString(), (Difficulty) difficultySpinner.getSelectedItem());
        Intent intent = new Intent(this, SetSkillsActivity.class);
        startActivity(intent);
    }
}
