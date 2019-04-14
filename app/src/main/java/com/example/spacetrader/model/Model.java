package com.example.spacetrader.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Container for the TOTAL STATE of the application.
 * Singleton model (Only one instance of Model in total application)
 * Contains all Interactors for application
 */

public class Model implements Serializable {
    private Repository gameRepo;
    private final String SAVE_FILE_NAME = "data.bin";
    //Singleton instance
    private static Model instance;


    public static Model getInstance() {
        if(instance == null){
            instance = new Model();
        }
        return instance;
    }

    public boolean saveRepo(File file){
        boolean success = true;
        try {
            /*
               For binary, we use Serialization, so everything we write has to implement
               the Serializable interface.  Fortunately all the collection classes and APi classes
               that we might use are already Serializable.  You just have to make sure your
               classes implement Serializable.

               We have to use an ObjectOutputStream to write objects.

               One thing to be careful of:  You cannot serialize static data.
             */


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            // We basically can save our entire data model with one write, since this will follow
            // all the links and pointers to save everything.  Just save the top level object.
            out.writeObject(gameRepo);
            out.close();

        } catch (IOException e) {
            Log.e("UserManagerFacade", "Error writing an entry from binary file",e);
            success = false;
        }
        return success;
    }

    public Repository loadRepo(File file){
        boolean success = true;
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
            success = false;
        } catch (ClassNotFoundException e) {
            Log.e("UserManagementFacade", "Error casting a class from the binary file",e);
            success = false;
        }
        return this.gameRepo;
    }

    public void setGameRepo(Repository repo){
        this.gameRepo = repo;
    }

    //Initialize model
    private Model(){
        this.gameRepo = new Repository();
    }

    public MutableLiveData<Repository> getRepository(){
        MutableLiveData<Repository> data = new MutableLiveData<>();
        data.setValue(gameRepo);
        return data;
    }
}
