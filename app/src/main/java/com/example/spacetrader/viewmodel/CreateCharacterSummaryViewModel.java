package com.example.spacetrader.viewmodel;
import com.example.spacetrader.model.Repository;

import java.util.Objects;

/**
 * The type Create character summary view model.
 */
public class CreateCharacterSummaryViewModel extends RepositoryLinkedViewModel {

    /**
     * Generate universe.
     */
    public void generateUniverse(){
        Repository changes = mRepository.getValue();
        char[] chars = Objects.requireNonNull(changes).getCurrentNameCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum += (int) aChar;
        }
        int SALT = 34589;
        sum = (sum / chars.length) * SALT;
        changes.generateUniverse(sum);
        mRepository.setValue(changes);
    }
}
