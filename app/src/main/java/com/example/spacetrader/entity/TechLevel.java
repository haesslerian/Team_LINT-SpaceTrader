package com.example.spacetrader.entity;

import java.io.Serializable;

public enum TechLevel implements Serializable {
    PREAGRICULTURE("Pre-Agriculture", 0), AGRICULTURE("Agriculture", 1), MEDIEVAL("Medieval", 2), RENAISSANCE("Renaissance", 3),
    EARLYINDUSTRIAL("Early-Industrial", 4), INDUSTRIAL("Industrial", 5), POSTINDUSTRIAL("Post-Industrial", 6),
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

    public int getLevel() {
        return level;
    }
}
