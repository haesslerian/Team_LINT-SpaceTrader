package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Universe {
    Random random = new Random();

    public static List<SolarSystem> universe = new ArrayList<SolarSystem>();

    public Universe() {
        for (int i = 0; i < 10; i++) {
            universe.add(new SolarSystem(SolarSystemNames.values()[random.nextInt(SolarSystemNames
                    .values().length)].getCode()));
        }
    }
}

