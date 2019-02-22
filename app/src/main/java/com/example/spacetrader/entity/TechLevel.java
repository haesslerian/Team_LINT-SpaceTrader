package com.example.spacetrader.entity;

public enum TechLevel {
    PRE_AGRICULTURE("Pre-Agriculture"),
    MEDIEVAL("Medieval"),
    RENAISSANCE("Renaissance"),
    EARLY_INDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"),
    POST_INDUSTRIAL("Post Industrial"),
    HI_TECH("Hi-Tech");

    private final String name;
    TechLevel(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
