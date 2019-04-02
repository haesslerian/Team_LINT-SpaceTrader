package com.example.spacetrader.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Ship {
    private ShipTypes currentType;
    private int cargoSize, weaponSize, gadgetSize, fuelSize, currentFuel;
    private HashMap<TradeGoods, Integer> cargo;

    public Ship(ShipTypes type){
        currentType = type;
        cargo = new HashMap<>();
        TradeGoods[] tradeGoods = TradeGoods.values();
        for(int i = 0; i < tradeGoods.length; i++){
            cargo.put(tradeGoods[i], 0);
        }
        switch (type){
            case FLEA: {
                cargoSize = 10;
                weaponSize = 0;
                gadgetSize = 0;
                fuelSize = 20;
                break;
            }
            case GNAT: {
                cargoSize = 15;
                weaponSize = 1;
                gadgetSize = 1;
                fuelSize = 14;
                break;
            }
            case FIREFLY: {
                cargoSize = 20;
                weaponSize = 1;
                gadgetSize = 1;
                fuelSize = 17;
                break;
            }
            case MOSQUITO: {
                cargoSize = 15;
                weaponSize = 2;
                gadgetSize = 1;
                fuelSize = 13;
                break;
            }
            case BUMBLEBEE: {
                cargoSize = 20;
                weaponSize = 2;
                gadgetSize = 2;
                fuelSize = 15;
                break;
            }
            case BEETLE: {
                cargoSize = 50;
                weaponSize = 0;
                gadgetSize = 1;
                fuelSize = 14;
                break;
            }
            case HORNET: {
                cargoSize = 20;
                weaponSize = 3;
                gadgetSize = 1;
                fuelSize = 16;
                break;
            }
            case GRASSHOPPER: {
                cargoSize = 30;
                weaponSize = 2;
                gadgetSize = 3;
                fuelSize = 15;
                break;
            }
            case TERMITE: {
                cargoSize = 60;
                weaponSize = 1;
                gadgetSize = 2;
                fuelSize = 13;
                break;
            }
            case WASP: {
                cargoSize = 35;
                weaponSize = 3;
                gadgetSize = 2;
                fuelSize = 14;
                break;
            }
        }
        currentFuel = fuelSize;
    }

    public ShipTypes getCurrentType() {
        return currentType;
    }

    public int getCargoSize() {
        return cargoSize;
    }

    public int getWeaponSize() {
        return weaponSize;
    }

    public int getGadgetSize() {
        return gadgetSize;
    }

    public int getFuelSize() {
        return fuelSize;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public HashMap<TradeGoods, Integer> getCargo() {
        return cargo;
    }

    public int getTradeGoodAmount(TradeGoods type){
        try {
            return cargo.get(type);
        } catch (NullPointerException ex){
            return 0;
        }
    }

    //Returns new total for good
    public int addCargoAmount(TradeGoods type, int amount){
        int currAmount = getTradeGoodAmount(type);
        if((getUsedCargoSize() + amount) > cargoSize){
            return -1;
        }
        cargo.put(type, currAmount + amount);
        return currAmount + amount;
    }

    public int getUsedCargoSize(){
        LinkedList cargoList = new LinkedList<>(cargo.values());
        Iterator list = cargoList.listIterator();
        int total = 0;
        Integer curr;
        while(list.hasNext()){
            curr = (Integer) list.next();
            total += curr;
        }
        return total;
    }
}
