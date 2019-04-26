package com.example.spacetrader.model;

import android.arch.lifecycle.MutableLiveData;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Container for the TOTAL STATE of the application.
 * Singleton model (Only one instance of Model in total application)
 * Contains all interactors for application
 */

public class Model {
    private final Repository gameRepo;
    //Singleton instance
    private static Model instance;


    /**
     * Creates an new instance of game if none exists otherwise returns the existing instance
     *
     * @return an instance of the current game model being used
     */
    public static Model getInstance() {
        if(instance == null){
            instance = new Model();
        }
        return instance;
    }

    //Initialize model
    private Model(){
        this.gameRepo = new Repository();
    }

    /**
     * Creates a repository based off the current game
     *
     * @return the current game repository
     */
    public MutableLiveData<Repository> getRepository(){
        MutableLiveData<Repository> data = new MutableLiveData<>();
        data.setValue(gameRepo);
        return data;
    }
}
