package com.example.spacetrader.viewmodel;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.model.Repository;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Records the name and difficulty chosen by the user
 */
public class CreateCharacterBasicInfoViewModel extends RepositoryLinkedViewModel {

    /**
     * Sets initial player data
     *
     * @param name the name entered by the user
     * @param difficulty the difficulty selected by the user from the difficulty spinner
     */
    public void setPlayerData(String name, Difficulty difficulty){
        Repository changes = mRepository.getValue();
        changes.getUserPlayer().setName(name.trim());
        changes.getUserPlayer().setDifficulty(difficulty);
        mRepository.setValue(changes);
    }
}
