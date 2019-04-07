package com.example.spacetrader.entity;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SolarSystem {
    private Point location;
    private String name;
    private TechLevel techLevel;
    private Resources resources;
    private Planet planet;
    private HashMap<TradeGoods, Integer> tradeGoodPrices;
    private HashMap<TradeGoods, Integer> tradeGoodAmount;
    private int randomPriceChange;

    public SolarSystem(Point location, String name, TechLevel techLevel, Resources resources) {
        this.location = location;
        this.name = name;
        planet = new Planet(name);
        this.techLevel = techLevel;
        this.resources = resources;
        this.tradeGoodPrices = new HashMap<>();
        this.tradeGoodAmount = new HashMap<>();
        this.randomPriceChange = determineRandomEvent();
        this.createMarket();
    }


    private int determineRandomEvent() {

        Random rand = new Random();
        int randomVal = rand.nextInt(55);
        int event = 0;
        for (int i = 0; i < TradeGoods.values().length; i++) {
            event += (10 - TradeGoods.values()[i].ordinal());
            if (event > randomVal) {
                return i;
            }
        }

        return -1;
    }


    private void createMarket(){
        TradeGoods[] tradeGoods = TradeGoods.values();
        for(int i = 0; i < tradeGoods.length; i++){
            TradeGoods goodToAdd = tradeGoods[i];
            if(tradeGoods[i].getMTLP() <= techLevel.getLevel()){
                tradeGoodAmount.put(goodToAdd, ThreadLocalRandom.current().nextInt(0, 21));
                int newPrice = goodToAdd.getBasePrice() + (goodToAdd.getIPL() * (techLevel.getLevel() - goodToAdd.getMTLP())) + ThreadLocalRandom.current().nextInt(-10, 11);

                if (i == randomPriceChange) {
                    newPrice *= 1000;
                }

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
