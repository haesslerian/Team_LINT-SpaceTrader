package com.example.spacetrader.entity;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Each planet is named the same as the solar system it belongs to
 */
public class Planet {
    private String name;

    Planet(String name){
        this.name = name;
    }

    /**
     * @return the name of the planet
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the planet name
     *
     * @param name the name the planet should be set as
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("Planet: " + name );
    }
}
