package com.example.spacetrader.entity;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class SolarSystem {
    private final Point location;
    private final String name;
    private final TechLevel techLevel;
    private final Resources resources;
    private final Planet planet;
    private final HashMap<TradeGoods, Integer> tradeGoodPrices;
    private final HashMap<TradeGoods, Integer> tradeGoodAmount;

    public SolarSystem(Point location, String name, TechLevel techLevel, Resources resources) {
        this.location = location;
        this.name = name;
        planet = new Planet(name);
        this.techLevel = techLevel;
        this.resources = resources;
        this.tradeGoodPrices = new HashMap<>();
        this.tradeGoodAmount = new HashMap<>();
        this.createMarket();
    }

    private void createMarket(){
        TradeGoods[] tradeGoods = TradeGoods.values();
        for(int i = 0; i < tradeGoods.length; i++){
            TradeGoods goodToAdd = tradeGoods[i];
            if(tradeGoods[i].getMTLP() <= techLevel.getLevel()){
                tradeGoodAmount.put(goodToAdd, ThreadLocalRandom.current().nextInt(0, 21));
                int newPrice = goodToAdd.getBasePrice() + (goodToAdd.getIPL() * (techLevel.getLevel() - goodToAdd.getMTLP())) + ThreadLocalRandom.current().nextInt(-10, 11);

                tradeGoodPrices.put(goodToAdd, newPrice);
            }
            else{
                tradeGoodAmount.put(goodToAdd, 0);
                tradeGoodPrices.put(goodToAdd, 0);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Planet getPlanet() { return planet; }

    public TechLevel getTechLevel() { return techLevel; }

    public Point getLocation() {
        return location;
    }

    public Resources getResources() {
        return resources;
    }

    public HashMap<TradeGoods, Integer> getTradeGoodPrices() {
        return tradeGoodPrices;
    }

    public HashMap<TradeGoods, Integer> getTradeGoodAmount() {
        return tradeGoodAmount;
    }

    @Override
    public String toString() {
        return ("{Solar System: " + this.name + " | Location: (" + location.getX() + ", " + location.getY() +  ") | TechLevel: " + techLevel.toString() + " | Resources: " + resources.toString() + " | Planets: [" + planet.toString() + "] }");
    }
}
