package com.example.spacetrader.entity;

import java.io.Serializable;

public enum Difficulty implements Serializable {
    BEGINNER ("Beginner"), EASY ("Easy"), NORMAL ("Normal"), HARD ("Hard"), IMPOSSIBLE ("Impossible");
    private final String diffNames;

    Difficulty(String diffNames){
        this.diffNames = diffNames;
    }

    public String toString() { return diffNames; }
}
