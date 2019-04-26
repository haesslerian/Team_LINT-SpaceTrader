package com.example.spacetrader.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.Repository;

public class RepositoryLinkedViewModel extends ViewModel {
    MutableLiveData<Repository> mRepository;
    private Model Model;

    public void init(){
        if(mRepository != null){
            return;
        }
        Model = com.example.spacetrader.model.Model.getInstance();
        mRepository = Model.getRepository();
    }

    public LiveData<Repository> getRepository(){
        return mRepository;
    }

    public LiveData<Model> getModel() {
        MutableLiveData<Model> mutableModel = new MutableLiveData<>();
        mutableModel.setValue(Model);
        return mutableModel;
    }
}
