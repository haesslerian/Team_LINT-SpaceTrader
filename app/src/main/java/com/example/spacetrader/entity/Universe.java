package com.example.spacetrader.entity;

import android.util.Log;

import org.apache.commons.math3.random.MersenneTwister;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Universe implements Serializable {
    private HashMap<Point, SolarSystem> solarSystemHashMap;
    private MersenneTwister seedGenerator;

    public Universe(int seed){
        solarSystemHashMap = new HashMap<>();
        seedGenerator = new MersenneTwister(seed);
        generateUniverse(10,150,100);
        Log.d("UniverseOutput", getSystemList().toString());
    }

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

    public List<SolarSystem> getSystemList(){
        return new LinkedList<>(solarSystemHashMap.values());
    }

    public HashMap<Point, SolarSystem> getSolarSystemHashMap() {
        return solarSystemHashMap;
    }
}
