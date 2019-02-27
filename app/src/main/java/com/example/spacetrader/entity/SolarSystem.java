package com.example.spacetrader.entity;

public class SolarSystem {
    private Point location;
    private String name;
    private TechLevel techLevel;
    private Resources resources;
    private Planet planet;

    public SolarSystem(Point location, String name, TechLevel techLevel, Resources resources) {
        this.location = location;
        this.name = name;
        planet = new Planet(name);
        this.techLevel = techLevel;
        this.resources = resources;
    }

    public String getName() {
        return name;
    }

    public Planet getPlanet() { return planet; }

    public TechLevel getTechLevel() { return techLevel; }

    public Point getLocation() {
        return location;
    }


    @Override
    public String toString() {
        return ("{Solar System: " + this.name + " | Location: (" + location.getX() + ", " + location.getY() +  ") | TechLevel: " + techLevel.toString() + " | Resources: " + resources.toString() + " | Planets: [" + planet.toString() + "] }");
    }
}
