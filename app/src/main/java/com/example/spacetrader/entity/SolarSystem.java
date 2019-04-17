package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Solar system.
 */
public class SolarSystem implements Serializable {
    private final Point location;
    private final String name;
    private final TechLevel techLevel;
    private final Resources resources;
    private final Planet planet;
    private final Map<TradeGoods, Integer> tradeGoodPrices;
    private final Map<TradeGoods, Integer> tradeGoodAmount;

    /**
     * Instantiates a new Solar system.
     *
     * @param location  the location
     * @param name      the name
     * @param techLevel the tech level
     * @param resources the resources
     */
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
        for (TradeGoods goodToAdd : tradeGoods) {
            if (goodToAdd.getMTLP() <= techLevel.getLevel()) {
                int MAX_GOOD_AMOUNT = 21;
                tradeGoodAmount.put(goodToAdd,
                        ThreadLocalRandom.current().nextInt(0, MAX_GOOD_AMOUNT));
                int MAX_PRICE_MODIFIER = 11;
                int newPrice = goodToAdd.getBasePrice() +
                        (goodToAdd.getIPL() * (techLevel.getLevel() - goodToAdd.getMTLP())) +
                        ThreadLocalRandom.current().nextInt(-10, MAX_PRICE_MODIFIER);
                tradeGoodPrices.put(goodToAdd, newPrice);
            } else {
                tradeGoodAmount.put(goodToAdd, 0);
                tradeGoodPrices.put(goodToAdd, 0);
            }
        }
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    // --Commented out by Inspection (4/14/19, 7:43 PM):public Planet getPlanet() { return planet; }

// --Commented out by Inspection START (4/14/19, 10:50 PM):
//    /**
//     * Gets tech level.
//     *
//     * @return the tech level
//     */
//    public TechLevel getTechLevel() { return techLevel; }
// --Commented out by Inspection STOP (4/14/19, 10:50 PM)

    /**
     * Gets location.
     *
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

// --Commented out by Inspection START (4/14/19, 10:50 PM):
//// --Commented out by Inspection START (4/14/19, 10:50 PM):
////    /**
////     * Gets resources.
////     *
////     * @return the resources
////     */
////    public Resources getResources() {
////        return resources;
////    }
//// --Commented out by Inspection START (4/14/19, 10:50 PM):
// --Commented out by Inspection STOP (4/14/19, 10:50 PM)
//// --Commented out by Inspection STOP (4/14/19, 10:50 PM)
//
//    /**
//     * Gets trade good prices.
//     *
//     * @return the trade good prices
//     */
//    public Map<TradeGoods, Integer> getTradeGoodPrices() {
//        return Collections.unmodifiableMap(tradeGoodPrices);
// --Commented out by Inspection STOP (4/14/19, 10:50 PM)
    //}

// --Commented out by Inspection START (4/15/19, 11:16 AM):
//    /**
//     * Gets trade good amount.
//     *
//     * @return the trade good amount
//     */
//    public Map<TradeGoods, Integer> getTradeGoodAmount() {
//        return Collections.unmodifiableMap(tradeGoodAmount);
//    }
// --Commented out by Inspection STOP (4/15/19, 11:16 AM)


    /**
     * Get selected trade good price int.
     *
     * @param good the good
     * @return the int
     */
    public int getSelectedTradeGoodPrice(TradeGoods good){
        return Objects.requireNonNull(tradeGoodPrices.get(good));
    }

    /**
     * Get selected trade good amount int.
     *
     * @param good the good
     * @return the int
     */
    public int getSelectedTradeGoodAmount(TradeGoods good){
        return Objects.requireNonNull(tradeGoodAmount.get(good));
    }

    /**
     * Set trade good amount.
     *
     * @param good   the good
     * @param amount the amount
     */
    public void setTradeGoodAmount(TradeGoods good, int amount){
        tradeGoodAmount.put(good, amount);
    }

    /**
     * Get tech level text string.
     *
     * @return the string
     */
    public String getTechLevelText(){
        return techLevel.toString();
    }

    /**
     * Get resources text string.
     *
     * @return the string
     */
    public String getResourcesText(){
        return resources.toString();
    }

    /**
     * Distance from int.
     *
     * @param otherLocation the location
     * @return the int
     */
    public int distanceFrom(Point otherLocation){
        return location.distanceFrom(otherLocation);
    }

    @Override
    public String toString() {
        return ("{Solar System: " + this.name + " | Location: (" + location.getX() + ", "
                + location.getY() +  ") | TechLevel: " + techLevel.toString() + " | Resources: "
                + resources.toString() + " | Planets: [" + planet.toString() + "] }");
    }
}
