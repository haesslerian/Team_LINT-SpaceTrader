package com.example.spacetrader.viewmodel;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.model.Repository;

public class CreateCharacterBasicInfoViewModel extends RepositoryLinkedViewModel {

    public void setPlayerData(String name, Difficulty difficulty){
        Repository changes = mRepository.getValue();
        changes.getUserPlayer().setName(name.trim());
        changes.getUserPlayer().setDifficulty(difficulty);
        mRepository.setValue(changes);
    }
}
