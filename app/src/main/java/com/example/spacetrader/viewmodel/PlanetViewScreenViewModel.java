package com.example.spacetrader.viewmodel;

import android.content.Context;

import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.Repository;

import java.io.File;

public class PlanetViewScreenViewModel extends RepositoryLinkedViewModel {

    public boolean saveGame(File file) {
        return this.getModel().getValue().saveRepo(file);
    }

    public boolean loadGame(File file){
        Model model = com.example.spacetrader.model.Model.getInstance();
        Repository repo = model.loadRepo(file);
        mRepository.setValue(repo);
        model.setGameRepo(repo);
        return true;
    }
}
