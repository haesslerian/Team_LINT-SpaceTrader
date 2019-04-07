package com.example.spacetrader.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.CreateCharacterBasicInfoViewModel;

import java.util.Set;

public class CreateCharacterBasicInfoActivity extends AppCompatActivity {

    private EditText nameField;
    private Spinner difficultySpinner;
    private CreateCharacterBasicInfoViewModel mCreateCharacterBasicInfoViewModel;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character_basic_info);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mCreateCharacterBasicInfoViewModel = ViewModelProviders.of(this).get(CreateCharacterBasicInfoViewModel.class);
        mCreateCharacterBasicInfoViewModel.init();
        nameField = findViewById(R.id.player_name_input);
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        Button button = findViewById(R.id.next_button);

        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Difficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

        //viewModel = ViewModelProviders.of(this).get(newUserViewModel.class);
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

    public void onNextPressed(View view) {
        mCreateCharacterBasicInfoViewModel.setPlayerData(nameField.getText().toString(), (Difficulty)difficultySpinner.getSelectedItem());
        Intent intent = new Intent(this, SetSkillsActivity.class);
        startActivity(intent);
    }
}
