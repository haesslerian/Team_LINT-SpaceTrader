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

    public void generateUniverse(int seed){
        Repository changes = mRepository.getValue();
        changes.generateUniverse(seed);
        mRepository.setValue(changes);
    }

    public void generateUniverse(){
        Repository changes = mRepository.getValue();
        char[] chars = changes.getUserPlayer().getName().toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum += (int)chars[i];
        }
        sum = (sum / chars.length) * 34589;
        changes.generateUniverse(sum);
        mRepository.setValue(changes);
    }
}
