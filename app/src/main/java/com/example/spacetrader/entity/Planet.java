package com.example.spacetrader.entity;

import java.util.Random;

public class Planet {
    private String name;
    private ResourceType resourceType;

    Random random = new Random();

    public Planet(String name) {
        this.name = name;
        resourceType = ResourceType.values()[random.nextInt(ResourceType.values().length)];
    }

    public ResourceType getResourceType() {
        return resourceType;
    }
}
