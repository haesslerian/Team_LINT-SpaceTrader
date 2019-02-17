package com.example.spacetrader.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.SkillTypes;
import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.Repository;

public class SetSkillsViewModel extends ViewModel {

    private MutableLiveData<Repository> mRepository;
    private MutableLiveData<Integer> mTotalPoints;
    private Model mModel;

    public void init(){
        if(mTotalPoints == null){
            mTotalPoints = new MutableLiveData<>();
            mTotalPoints.setValue(16);
        }
        if(mRepository != null){
            return;
        }
        mModel = Model.getInstance();
        mRepository = mModel.getRepository();
    }

    public LiveData<Repository> getRepository(){
        return mRepository;
    }

    public LiveData<Integer> getTotalPoints(){
        return mTotalPoints;
    }

    public void setTotalPoints(Integer newTotal){
        mTotalPoints.setValue(newTotal);
    }

    public void updatePlayerSkills(SkillTypes type, Integer newValue){
            Repository changes = mRepository.getValue();
            switch (type){
                case PILOT: {
                    if(newValue > changes.getUserPlayer().getSkillPilot()){
                        if(mTotalPoints.getValue() > 0 ){
                            mTotalPoints.setValue(mTotalPoints.getValue() - 1);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(mTotalPoints.getValue() > 15 || changes.getUserPlayer().getSkillPilot() == 1){
                            break;
                        }
                        else{
                            mTotalPoints.setValue(mTotalPoints.getValue() + 1);
                        }
                    }
                    changes.getUserPlayer().setSkillPilot(newValue);
                    mRepository.setValue(changes);
                    break;
                }
                case TRADER:{
                    if(newValue > changes.getUserPlayer().getSkillTrader()){
                        if(mTotalPoints.getValue() > 0 ) {
                            mTotalPoints.setValue(mTotalPoints.getValue() - 1);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(mTotalPoints.getValue() > 15 || changes.getUserPlayer().getSkillTrader() == 1){
                            break;
                        }
                        else{
                            mTotalPoints.setValue(mTotalPoints.getValue() + 1);
                        }
                    }
                    changes.getUserPlayer().setSkillTrader(newValue);
                    mRepository.setValue(changes);
                    break;
                }
                case FIGHTER: {
                    if(newValue > changes.getUserPlayer().getSkillFighter()){
                        if(mTotalPoints.getValue() > 0 ) {
                            mTotalPoints.setValue(mTotalPoints.getValue() - 1);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(mTotalPoints.getValue() > 15 || changes.getUserPlayer().getSkillFighter() == 1){
                            break;
                        }
                        else{
                            mTotalPoints.setValue(mTotalPoints.getValue() + 1);
                        }
                    }
                    changes.getUserPlayer().setSkillFighter(newValue);
                    mRepository.setValue(changes);
                    break;
                }
                case ENGINEER: {
                    if(newValue > changes.getUserPlayer().getSkillEngineer()){
                        if(mTotalPoints.getValue() > 0 ) {
                            mTotalPoints.setValue(mTotalPoints.getValue() - 1);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(mTotalPoints.getValue() > 15 || changes.getUserPlayer().getSkillEngineer() == 1){
                            break;
                        }
                        else{
                            mTotalPoints.setValue(mTotalPoints.getValue() + 1);
                        }
                    }
                    changes.getUserPlayer().setSkillEngineer(newValue);
                    mRepository.setValue(changes);
                    break;
                }
                default: break;
            }
    }
}
