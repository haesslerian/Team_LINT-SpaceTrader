package com.example.spacetrader.entity;

import android.util.Log;

import org.apache.commons.math3.random.MersenneTwister;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Universe {
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
        for(int i = 0; i < amountPlanets; i ++){
            Point planetCord = new Point(seedGenerator.nextInt(mapSizeX), seedGenerator.nextInt(mapSizeY));
            while(solarSystemHashMap.containsKey(planetCord)) {
                planetCord = new Point(seedGenerator.nextInt(mapSizeX), seedGenerator.nextInt(mapSizeY));
            }
            SolarSystem newSystem = new SolarSystem(planetCord, names[i].toString(), techlevels[seedGenerator.nextInt(techlevels.length)], resources[seedGenerator.nextInt(techlevels.length)]);
            solarSystemHashMap.put(planetCord, newSystem);
        }
    }

    public List<SolarSystem> getSystemList(){
        return new LinkedList<>(solarSystemHashMap.values());
    }
}
