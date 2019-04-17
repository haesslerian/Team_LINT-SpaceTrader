package com.example.spacetrader.entity;

import org.apache.commons.math3.random.MersenneTwister;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The type Universe.
 */
public class Universe implements Serializable {
    private final Map<Point, SolarSystem> solarSystemHashMap;
    private final MersenneTwister seedGenerator;

    /**
     * Instantiates a new Universe.
     *
     * @param seed the seed
     */
    public Universe(int seed){
        solarSystemHashMap = new HashMap<>();
        seedGenerator = new MersenneTwister(seed);
        generateUniverse();
        //Log.d("UniverseOutput", getSystemList().toString());
    }

    private void generateUniverse(){
        SolarSystemNames[] names = SolarSystemNames.values();
        TechLevel[] techlevels = TechLevel.values();
        Resources[] resources = Resources.values();
        int MAX_X = 150;
        int currentX = MAX_X / 2;
        int MAX_Y = 100;
        int currentY = MAX_Y / 2;
        Point initialCord = new Point(currentX, currentY);
        SolarSystem initialSystem = new SolarSystem(
                initialCord, names[0].toString(),
                techlevels[seedGenerator.nextInt(techlevels.length)],
                resources[seedGenerator.nextInt(techlevels.length)]);
        solarSystemHashMap.put(initialCord, initialSystem);
        for(int i = 1; i < 10; i ++){
            int RAND_RANGE = 20;
            currentX = (currentX + seedGenerator.nextInt(RAND_RANGE)) - 10;
            currentY = (currentY + seedGenerator.nextInt(RAND_RANGE)) - 10;
            Point planetCord = new Point(currentX, currentY);
            SolarSystem newSystem = new SolarSystem(
                    planetCord, names[i].toString(),
                    techlevels[seedGenerator.nextInt(techlevels.length)],
                    resources[seedGenerator.nextInt(techlevels.length)]);
            solarSystemHashMap.put(planetCord, newSystem);
        }
    }

    /**
     * Get first system point.
     *
     * @return the point
     */
    public Point getFirstSystem(){
        return getSystemList().get(0).getLocation();
    }

    /**
     * Get system list list.
     *
     * @return the list
     */
    public List<SolarSystem> getSystemList(){
        return new LinkedList<>(solarSystemHashMap.values());
    }

    /**
     * Gets solar system hash map.
     *
     * @return the solar system hash map
     */
    public Map<Point, SolarSystem> getSolarSystemHashMap() {
        return Collections.unmodifiableMap(solarSystemHashMap);
    }

    /**
     * Get selected system name string.
     *
     * @param location the location
     * @return the string
     */
    public String getSelectedSystemName(Point location){
        SolarSystem solarSystem = solarSystemHashMap.get(location);
        return Objects.requireNonNull(solarSystem).getName();
    }

    /**
     * Get selected system resources string.
     *
     * @param location the location
     * @return the string
     */
    public String getSelectedSystemResources(Point location){
        SolarSystem solarSystem = solarSystemHashMap.get(location);
        return Objects.requireNonNull(solarSystem).getResourcesText();
    }

    /**
     * Get selected system tech level string.
     *
     * @param location the location
     * @return the string
     */
    public String getSelectedSystemTechLevel(Point location){
        SolarSystem solarSystem = solarSystemHashMap.get(location);
        return Objects.requireNonNull(solarSystem).getTechLevelText();
    }
}
