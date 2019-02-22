package com.example.spacetrader.entity;

public class SolarSystem {
    private int x, y;
    private String name;
    private TechLevel techLevel;
    private Planet planet;

    public SolarSystem(String name) {
        this.name = name;
        this.planet = new Planet(name);
    }

    public String getName() {
        return name;
    }

    public Planet getPlanet() { return planet; }


}
