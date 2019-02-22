package com.example.spacetrader.entity;

public enum TechLevel {
    PRE_AGRICULTURE("Pre-Agriculture"),
    MEDIEVAL("Medieval"),
    RENAISSANCE("Renaissance"),
    EARLY_INDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"),
    POST_INDUSTRIAL("Post Industrial"),
    HI_TECH("Hi-Tech");

    private final String code;

    TechLevel(String code) {
        this.code = code;
    }

    public String toString() {
        return code;
    }
}