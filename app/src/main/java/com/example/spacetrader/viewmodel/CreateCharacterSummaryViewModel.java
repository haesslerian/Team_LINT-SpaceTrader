package com.example.spacetrader.viewmodel;
import com.example.spacetrader.model.Repository;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Generates a universe for the current game
 */
public class CreateCharacterSummaryViewModel extends RepositoryLinkedViewModel {

    /**
     * uses seed to call for universe generation
     *
     * @param seed value to use when randomly generating universe
     */
    public void generateUniverse(int seed){
        Repository changes = mRepository.getValue();
        changes.generateUniverse(seed);
        mRepository.setValue(changes);
    }

    /**
     * creates value to use for random universe generation
     */
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
