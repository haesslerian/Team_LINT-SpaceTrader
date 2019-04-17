package com.example.spacetrader.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.spacetrader.entity.SkillTypes;
import com.example.spacetrader.model.Model;
import com.example.spacetrader.model.Repository;

import java.util.Objects;

/**
 * The type Set skills view model.
 */
public class SetSkillsViewModel extends RepositoryLinkedViewModel {
    private MutableLiveData<Integer> mTotalPoints;
    private final int DEFAULT_POINTS = 16;

    /**
     * Init.
     */
    @Override
    public void init(){
        if(mTotalPoints == null){
            mTotalPoints = new MutableLiveData<>();
            mTotalPoints.setValue(DEFAULT_POINTS);
        }
        if(mRepository != null){
            return;
        }
        Model mModel = Model.getInstance();
        mRepository = mModel.getRepository();
    }

    /**
     * Gets skill pilot.
     *
     * @return the skill pilot
     */
    public int getSkillPilot() {
        return getRepositoryValue().getSkillPilot();
    }

    /**
     * Gets skill fighter.
     *
     * @return the skill fighter
     */
    public int getSkillFighter() {
        return getRepositoryValue().getSkillFighter();
    }

    /**
     * Gets skill engineer.
     *
     * @return the skill engineer
     */
    public int getSkillEngineer() {
        return getRepositoryValue().getSkillEngineer();
    }

    /**
     * Gets skill trader.
     *
     * @return the skill trader
     */
    public int getSkillTrader() {
        return getRepositoryValue().getSkillTrader();
    }
    /**
     * Get repository live data.
     *
     * @return the live data
     */
    @Override
    public LiveData<Repository> getRepository(){
        return mRepository;
    }

    /**
     * Get total points live data.
     *
     * @return the live data
     */
    public LiveData<Integer> getTotalPoints(){
        return mTotalPoints;
    }

// --Commented out by Inspection START (4/14/19, 7:43 PM):
//    public void setTotalPoints(Integer newTotal){
//        mTotalPoints.setValue(newTotal);
//    }
// --Commented out by Inspection STOP (4/14/19, 7:43 PM)

    /**
     * Update player skills.
     *
     * @param type     the type
     * @param newValue the new value
     */
    public void updatePlayerSkills(SkillTypes type, Integer newValue){
            Repository changes = mRepository.getValue();
            switch (type){
                case PILOT: {
                    if(newValue > Objects.requireNonNull(changes).getSkillPilot()){
                        if(Objects.requireNonNull(mTotalPoints.getValue()) > 0 ){
                            mTotalPoints.setValue(
                                    Objects.requireNonNull(mTotalPoints.getValue()) - 1);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if((Objects.requireNonNull(
                                mTotalPoints.getValue()) >= DEFAULT_POINTS) || (
                                        changes.getSkillPilot() == 1)){
                            break;
                        }
                        else{
                            mTotalPoints.setValue(mTotalPoints.getValue() + 1);
                        }
                    }
                    changes.setSkillPilot(newValue);
                    mRepository.setValue(changes);
                    break;
                }
                case TRADER:{
                    if(newValue > Objects.requireNonNull(changes).getSkillTrader()){
                        if(Objects.requireNonNull(mTotalPoints.getValue()) > 0 ) {
                            mTotalPoints.setValue(mTotalPoints.getValue() - 1);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if((Objects.requireNonNull(
                                mTotalPoints.getValue()) >= DEFAULT_POINTS) ||
                                (changes.getSkillTrader() == 1)){
                            break;
                        }
                        else{
                            mTotalPoints.setValue(mTotalPoints.getValue() + 1);
                        }
                    }
                    changes.setSkillTrader(newValue);
                    mRepository.setValue(changes);
                    break;
                }
                case FIGHTER: {
                    if(newValue > Objects.requireNonNull(changes).getSkillFighter()){
                        if(Objects.requireNonNull(mTotalPoints.getValue()) > 0 ) {
                            mTotalPoints.setValue(mTotalPoints.getValue() - 1);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if((Objects.requireNonNull(
                                mTotalPoints.getValue()) >= DEFAULT_POINTS) ||
                                (changes.getSkillFighter() == 1)){
                            break;
                        }
                        else{
                            mTotalPoints.setValue(mTotalPoints.getValue() + 1);
                        }
                    }
                    changes.setSkillFighter(newValue);
                    mRepository.setValue(changes);
                    break;
                }
                case ENGINEER: {
                    if(newValue > Objects.requireNonNull(changes).getSkillEngineer()){
                        if(Objects.requireNonNull(mTotalPoints.getValue()) > 0 ) {
                            mTotalPoints.setValue(mTotalPoints.getValue() - 1);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if((Objects.requireNonNull(
                                mTotalPoints.getValue()) >= DEFAULT_POINTS) ||
                                (changes.getSkillEngineer() == 1)){
                            break;
                        }
                        else{
                            mTotalPoints.setValue(mTotalPoints.getValue() + 1);
                        }
                    }
                    changes.setSkillEngineer(newValue);
                    mRepository.setValue(changes);
                    break;
                }
                default: break;
            }
    }
}
