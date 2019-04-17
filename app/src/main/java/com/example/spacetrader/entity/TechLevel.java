package com.example.spacetrader.entity;

/**
 * The enum Tech level.
 */
public enum TechLevel {
    /**
     * Preagriculture tech level.
     */
    PREAGRICULTURE("Pre-Agriculture", 0),
    /**
     * Agriculture tech level.
     */
    AGRICULTURE("Agriculture", 1),
    /**
     * Medieval tech level.
     */
    MEDIEVAL("Medieval", 2),
    /**
     * Renaissance tech level.
     */
    RENAISSANCE("Renaissance", 3),
    /**
     * Earlyindustrial tech level.
     */
    EARLYINDUSTRIAL("Early-Industrial", 4),
    /**
     * Industrial tech level.
     */
    INDUSTRIAL("Industrial", 5),
    /**
     * Postindustrial tech level.
     */
    POSTINDUSTRIAL("Post-Industrial", 6),
    /**
     * Hitech tech level.
     */
    HITECH("Hi-Tech", 7);

    private final String name;
    private final int level;
    TechLevel(String name, int level){
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }
}
