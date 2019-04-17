package com.example.spacetrader.viewmodel;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.model.Repository;

import java.util.Objects;

/**
 * The type Create character basic info view model.
 */
public class CreateCharacterBasicInfoViewModel extends RepositoryLinkedViewModel {

    /**
     * Set player data.
     *
     * @param name       the name
     * @param difficulty the difficulty
     */
    public void setPlayerData(String name, Difficulty difficulty){
        Repository changes = getRepositoryValue();
        Objects.requireNonNull(changes).setName(name.trim());
        changes.setDifficulty(difficulty);
        setmRepositoryValue(changes);
    }
}
