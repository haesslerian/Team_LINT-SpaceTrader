package com.example.spacetrader.entity;

import java.util.Random;

public class SolarSystem {
    private int x, y;
    private String name;
    private TechLevel techLevel;
    private Planet planet;

    Random random = new Random();

    public SolarSystem(String name) {
        this.name = name;
        planet = new Planet(name);
        techLevel = TechLevel.values()[random.nextInt(TechLevel.values().length)];
    }

    public String getName() {
        return name;
    }

    public Planet getPlanet() { return planet; }

    public TechLevel getTechLevel() { return techLevel; }


}
