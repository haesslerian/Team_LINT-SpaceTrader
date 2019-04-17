package com.example.spacetrader.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.Repository;

import java.io.File;

/**
 * The type Repository linked view model.
 */
public class RepositoryLinkedViewModel extends ViewModel {
    /**
     * The M repository.
     */
    MutableLiveData<Repository> mRepository;
    private Model Model;

    /**
     * Init.
     */
    public void init(){
        if(mRepository != null){
            return;
        }
        Model = com.example.spacetrader.model.Model.getInstance();
        mRepository = Model.getRepository();
    }

    /**
     * Get repository live data.
     *
     * @return the live data
     */
    public LiveData<Repository> getRepository(){
        return mRepository;
    }

    /**
     * Get repository value repository.
     *
     * @return the repository
     */
    public Repository getRepositoryValue(){
        return mRepository.getValue();
    }

    /**
     * Save model.
     *
     * @param file the file
     */
    void saveModel(File file){Model.saveRepo(file);}


    /**
     * Setm repository value.
     *
     * @param repo the repo
     */
    void setmRepositoryValue(Repository repo){
        mRepository.setValue(repo);
    }

// --Commented out by Inspection START (4/14/19, 10:50 PM):
//    /**
//     * Gets model.
//     *
//     * @return the model
//     */
//    LiveData<Model> getModel() {
//        MutableLiveData<Model> mutableModel = new MutableLiveData<>();
//        mutableModel.setValue(Model);
//        return mutableModel;
//    }
// --Commented out by Inspection STOP (4/14/19, 10:50 PM)
}
