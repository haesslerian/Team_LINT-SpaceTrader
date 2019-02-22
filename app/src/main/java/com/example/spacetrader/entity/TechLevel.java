package com.example.spacetrader.entity;

public enum TechLevel {
    PREAGRICULTURE("Pre-Agriculture"), AGRICULTURE("Agriculture"), MEDIEVAL("Medieval"), RENAISSANCE("Renaissance"),
    EARLYINDUSTRIAL("Early-Industrial"), INDUSTRIAL("Industrial"), POSTINDUSTRIAL("Post-Industrial"),
    HITECH("Hi-Tech");

    private final String name;
    TechLevel(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
