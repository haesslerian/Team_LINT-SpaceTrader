package com.example.spacetrader.model;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Container for the TOTAL STATE of the application.
 * Singleton model (Only one instance of Model in total application)
 * Contains all Interactors for application
 */
public final class Model implements Serializable {
    private Repository gameRepo;
    // --Commented out by Inspection (4/14/19, 7:43 PM)
    // :private final String SAVE_FILE_NAME = "data.bin";
    //Singleton instance
    private static Model instance;


    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Model getInstance() {
        if(instance == null){
            instance = new Model();
        }
        return instance;
    }

    /**
     * Save repo.
     *
     * @param file the file
     */
    public void saveRepo(File file){
        try {
            /*
               For binary, we use Serialization, so everything we write has to implement
               the Serializable interface.  Fortunately all the collection classes and APi classes
               that we might use are already Serializable.  You just have to make sure your
               classes implement Serializable.

               We have to use an ObjectOutputStream to write objects.

               One thing to be careful of:  You cannot serialize static data.
             */


            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            // We basically can save our entire data model with one write, since this will follow
            // all the links and pointers to save everything.  Just save the top level object.
            out.writeObject(gameRepo);
            out.close();

        } catch (IOException e) {
            Log.e("UserManagerFacade", "Error writing an entry from binary file",e);
        }
    }

    /**
     * Load repo repository.
     *
     * @param file the file
     * @return the repository
     */
    public Repository loadRepo(File file){
        try {
            /*
              To read, we must use the ObjectInputStream since we want to read our model in with
              a single read.
             */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // assuming we saved our top level object, we read it back in with one line of code.
            Repository savedGame = (Repository) in.readObject();
            in.close();
            return savedGame;
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Error reading an entry from binary file",e);
        } catch (ClassNotFoundException e) {
            Log.e("UserManagementFacade", "Error casting a class from the binary file",e);
        }
        return this.gameRepo;
    }

    /**
     * Set game repo.
     *
     * @param repo the repo
     */
    public void setGameRepo(Repository repo){
        this.gameRepo = repo;
    }

    //Initialize model
    private Model(){
        this.gameRepo = new Repository();
    }

    /**
     * Get repository mutable live data.
     *
     * @return the mutable live data
     */
    public MutableLiveData<Repository> getRepository(){
        MutableLiveData<Repository> data = new MutableLiveData<>();
        data.setValue(gameRepo);
        return data;
    }
}
