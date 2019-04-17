package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * The type Ship.
 */
public class Ship implements Serializable {
    private final ShipTypes currentType;
    private int cargoSize;
    private int fuelSize;
    private int currentFuel;
    private final HashMap<TradeGoods, Integer> cargo;

    /**
     * Instantiates a new Ship.
     *
     * @param type the type
     */
    public Ship(ShipTypes type){
        currentType = type;
        cargo = new HashMap<>();
        TradeGoods[] tradeGoods = TradeGoods.values();
        for (TradeGoods tradeGood : tradeGoods) {
            cargo.put(tradeGood, 0);
        }
        switch (type){
            case FLEA: {
                cargoSize = 10;
                fuelSize = 20;
                break;
            }
            case GNAT: {
                cargoSize = 15;
                fuelSize = 14;
                break;
            }
            case FIREFLY: {
                cargoSize = 20;
                fuelSize = 17;
                break;
            }
            case MOSQUITO: {
                cargoSize = 15;
                fuelSize = 13;
                break;
            }
            case BUMBLEBEE: {
                cargoSize = 20;
                fuelSize = 15;
                break;
            }
            case BEETLE: {
                cargoSize = 50;
                fuelSize = 14;
                break;
            }
            case HORNET: {
                cargoSize = 20;
                fuelSize = 16;
                break;
            }
            case GRASSHOPPER: {
                cargoSize = 30;
                fuelSize = 15;
                break;
            }
            case TERMITE: {
                cargoSize = 60;
                fuelSize = 13;
                break;
            }
            case WASP: {
                cargoSize = 35;
                fuelSize = 14;
                break;
            }
        }
        currentFuel = fuelSize;
    }

// --Commented out by Inspection START (4/14/19, 10:50 PM):
//    /**
//     * Gets current type.
//     *
//     * @return the current type
//     */
//    public ShipTypes getCurrentType() {
//        return currentType;
//    }
// --Commented out by Inspection STOP (4/14/19, 10:50 PM)

    /**
     * Gets cargo size.
     *
     * @return the cargo size
     */
    public int getCargoSize() {
        return cargoSize;
    }


    /**
     * Gets fuel size.
     *
     * @return the fuel size
     */
    public int getFuelSize() {
        return fuelSize;
    }

    /**
     * Gets current fuel.
     *
     * @return the current fuel
     */
    public int getCurrentFuel() {
        return currentFuel;
    }

    /**
     * Sets current fuel.
     *
     * @param currentFuel the current fuel
     */
    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

// --Commented out by Inspection START (4/14/19, 10:50 PM):
//    /**
//     * Gets cargo.
//     *
//     * @return the cargo
//     */
//    public Map<TradeGoods, Integer> getCargo() {
//        return Collections.unmodifiableMap(cargo);
//    }
// --Commented out by Inspection STOP (4/14/19, 10:50 PM)

    private int getTradeGoodAmount(TradeGoods type){
         return Objects.requireNonNull(cargo.get(type));
    }

    /**
     * Add cargo amount.
     * Excepts negative numbers to subtract value
     *
     * @param type   the type
     * @param amount the amount
     */
//Returns new total for good
    public void addCargoAmount(TradeGoods type, int amount){
        if(type == null){
           throw new IllegalArgumentException("Type can not be null");
        }
        int currAmount = getTradeGoodAmount(type);
        if(((getUsedCargoSize() + amount) > cargoSize) || ((getUsedCargoSize() + amount) < 0)){
            return;
        }
        cargo.put(type, currAmount + amount);
    }

    /**
     * Get used cargo size int.
     *
     * @return the int
     */
    public int getUsedCargoSize(){
        List cargoList = new LinkedList<>(cargo.values());
        Iterator list = cargoList.listIterator();
        int total = 0;
        Integer curr;
        while(list.hasNext()){
            curr = (Integer) list.next();
            total += curr;
        }
        return total;
    }

    /**
     * Get selected cargo int.
     *
     * @param good the good
     * @return the int
     */
    public int getSelectedCargo(TradeGoods good){
        return Objects.requireNonNull(cargo.get(good));
    }

    /**
     * Get current ship type string.
     *
     * @return the string
     */
    public String getCurrentShipType(){
        return currentType.toString();
    }
}
