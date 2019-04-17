package com.example.spacetrader.viewmodel;

import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.Repository;

import java.io.File;

/**
 * The type Planet view screen view model.
 */
public class PlanetViewScreenViewModel extends RepositoryLinkedViewModel {

    /**
     * Save game.
     *
     * @param file the file
     */
    public void saveGame(File file) {
        saveModel(file);
    }

    /**
     * Load game.
     *
     * @param file the file
     */
    public void loadGame(File file){
        Model model = com.example.spacetrader.model.Model.getInstance();
        Repository repo = model.loadRepo(file);
        mRepository.setValue(repo);
        model.setGameRepo(repo);
    }
}
