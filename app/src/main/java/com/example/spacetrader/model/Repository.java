package com.example.spacetrader.model;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Point;
import com.example.spacetrader.entity.TradeGoods;
import com.example.spacetrader.entity.Universe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Repository {

    private Player userPlayer;
    private Universe universe;
    private Point currentLocation;
    private final ArrayList<TradeGoods> tradeGoodsList;

    public Repository(){
        userPlayer = new Player();
        tradeGoodsList = new ArrayList<>(Arrays.asList(TradeGoods.values()));
    }

    public Player getUserPlayer() {
        return userPlayer;
    }

    public void setUserPlayer(Player userPlayer) {
        this.userPlayer = userPlayer;
    }

    public void generateUniverse(int seed){
        universe = new Universe(seed);
        currentLocation = universe.getSystemList().get(0).getLocation();
    }

    public Universe getUniverse() {
        return universe;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    public ArrayList<TradeGoods> getTradeGoodsList() {
        return tradeGoodsList;
    }

    public Iterator<TradeGoods> getTradeGoodsIterator(){
        return tradeGoodsList.iterator();
    }

}
