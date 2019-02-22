package com.example.spacetrader.entity;

import org.apache.commons.math3.random.MersenneTwister;

import java.util.HashMap;

public class Universe {
    private HashMap<Point, Planet> planetsHashMap;
    private MersenneTwister seedGenerator;

    public Universe(int seed){
        planetsHashMap = new HashMap<>();
        seedGenerator = new MersenneTwister(seed);
    }
}
