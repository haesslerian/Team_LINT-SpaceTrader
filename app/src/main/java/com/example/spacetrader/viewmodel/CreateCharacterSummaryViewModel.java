package com.example.spacetrader.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.Repository;

public class CreateCharacterSummaryViewModel extends ViewModel {
    private MutableLiveData<Repository> mRepository;
    private Model mModel;

    public void init(){
        if(mRepository != null){
            return;
        }
        mModel = Model.getInstance();
        mRepository = mModel.getRepository();
    }

    public LiveData<Repository> getRepository(){
        return mRepository;
    }
}
