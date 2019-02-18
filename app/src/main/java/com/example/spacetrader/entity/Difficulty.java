package com.example.spacetrader.entity;

public enum Difficulty {
    BEGINNER ("Beginner"), EASY ("Easy"), NORMAL ("Normal"), HARD ("Hard"), IMPOSSIBLE ("Impossible");
    private final String diffNames;

    Difficulty(String diffNames){
        this.diffNames = diffNames;
    }

    public String toString() { return diffNames; }
}
