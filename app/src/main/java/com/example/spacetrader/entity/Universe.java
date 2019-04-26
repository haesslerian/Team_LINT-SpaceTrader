package com.example.spacetrader.entity;

import android.util.Log;

import org.apache.commons.math3.random.MersenneTwister;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haesslerian
 * @version 1.0
 *
 * The location of the user in the game
 */
public class Universe {
    private final HashMap<Point, SolarSystem> solarSystemHashMap;
    private final MersenneTwister seedGenerator;

    /**
     * Gets a seed to use for universe generation
     *
     * @param seed the number to use when generating a seed
     */
    public Universe(int seed){
        solarSystemHashMap = new HashMap<>();
        seedGenerator = new MersenneTwister(seed);
        generateUniverse(10,150,100);
        Log.d("UniverseOutput", getSystemList().toString());
    }

    /**
     * Generates a universe based on the given number of planets and map size
     *
     * @param amountPlanets the number of planets to include in the universe
     * @param mapSizeX the X value of the universe
     * @param mapSizeY the Y value of the universe
     */
    private void generateUniverse(int amountPlanets, int mapSizeX, int mapSizeY){
        SolarSystemNames[] names = SolarSystemNames.values();
        TechLevel[] techlevels = TechLevel.values();
        Resources[] resources = Resources.values();
        int currentX = mapSizeX / 2;
        int currentY = mapSizeY / 2;
        Point initialCord = new Point(currentX, currentY);
        SolarSystem initialSystem = new SolarSystem(initialCord, names[0].toString(), techlevels[seedGenerator.nextInt(techlevels.length)], resources[seedGenerator.nextInt(techlevels.length)]);
        solarSystemHashMap.put(initialCord, initialSystem);
        for(int i = 1; i < amountPlanets; i ++){
            currentX = currentX + seedGenerator.nextInt(20) - 10;
            currentY = currentY + seedGenerator.nextInt(20) - 10;
            Point planetCord = new Point(currentX, currentY);
            SolarSystem newSystem = new SolarSystem(planetCord, names[i].toString(), techlevels[seedGenerator.nextInt(techlevels.length)], resources[seedGenerator.nextInt(techlevels.length)]);
            solarSystemHashMap.put(planetCord, newSystem);
        }
    }

    /**
     * Getter method for the solar system
     *
     * @return a list of all solar systems
     */
    public List<SolarSystem> getSystemList(){
        return new LinkedList<>(solarSystemHashMap.values());
    }

    /**
     * Getter method for a hash map of the solar system
     *
     * @return a hash map containing the solar systems and their locations
     */
    public HashMap<Point, SolarSystem> getSolarSystemHashMap() {
        return solarSystemHashMap;
    }
}
