package com.example.spacetrader.entity;

/**
 * The enum Difficulty.
 */
public enum Difficulty {
    /**
     * Beginner difficulty.
     */
    BEGINNER ("Beginner"),
    /**
     * Easy difficulty.
     */
    EASY ("Easy"),
    /**
     * Normal difficulty.
     */
    NORMAL ("Normal"),
    /**
     * Hard difficulty.
     */
    HARD ("Hard"),
    /**
     * Impossible difficulty.
     */
    IMPOSSIBLE ("Impossible");
    private final String diffNames;

    Difficulty(String diffNames){
        this.diffNames = diffNames;
    }

    public String toString() { return diffNames; }
}
