package com.example.spacetrader.model;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Point;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.TradeGoods;
import com.example.spacetrader.entity.Universe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * The type Repository.
 */
public class Repository implements Serializable {

    private final Player userPlayer;
    private Universe universe;
    private Point currentLocation;
    private final List<TradeGoods> tradeGoodsList;

    /**
     * Instantiates a new Repository.
     */
    public Repository() {
        userPlayer = new Player();
        tradeGoodsList = new ArrayList<>(Arrays.asList(TradeGoods.values()));
    }

// --Commented out by Inspection START (4/15/19, 11:16 AM):
//    /**
//     * Gets user player.
//     *
//     * @return the user player
//     */
//    public Player getUserPlayer() {
//        return userPlayer;
//    }
// --Commented out by Inspection STOP (4/15/19, 11:16 AM)

    /**
     * Get credits int.
     *
     * @return the int
     */
    public int getCredits() {
        return userPlayer.getCredits();
    }

    /**
     * Sets credits.
     *
     * @param credits the credits
     */
    public void setCredits(int credits) {
        userPlayer.setCredits(credits);
    }

    /**
     * Get current system solar system.
     *
     * @return the solar system
     */
    public SolarSystem getCurrentSystem() {
        Map systems = universe.getSolarSystemHashMap();
        return (SolarSystem) systems.get(currentLocation);
    }

// --Commented out by Inspection START (4/14/19, 7:43 PM):
//    public void setUserPlayer(Player userPlayer) {
//        this.userPlayer = userPlayer;
//    }
// --Commented out by Inspection STOP (4/14/19, 7:43 PM)

// --Commented out by Inspection START (4/14/19, 10:50 PM):
//    public Ship getCurrentShip() {
//        return userPlayer.getCurrentShip();
//    }
// --Commented out by Inspection STOP (4/14/19, 10:50 PM)

    /**
     * Generate universe.
     *
     * @param seed the seed
     */
    public void generateUniverse(int seed) {
        universe = new Universe(seed);
        currentLocation = universe.getFirstSystem();
    }

// --Commented out by Inspection START (4/15/19, 11:16 AM):
//    /**
//     * Gets universe.
//     *
//     * @return the universe
//     */
//    public Universe getUniverse() {
//        return universe;
//    }
// --Commented out by Inspection STOP (4/15/19, 11:16 AM)

    /**
     * Gets current location.
     *
     * @return the current location
     */
    public Point getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Sets current location.
     *
     * @param currentLocation the current location
     */
    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

// --Commented out by Inspection START (4/14/19, 7:43 PM):
//    public ArrayList<TradeGoods> getTradeGoodsList() {
//        return tradeGoodsList;
//    }
// --Commented out by Inspection STOP (4/14/19, 7:43 PM)

    /**
     * Get trade goods iterator iterator.
     *
     * @return the iterator
     */
    public Iterator<TradeGoods> getTradeGoodsIterator() {
        return tradeGoodsList.iterator();
    }

    /**
     * Gets selected ship cargo.
     *
     * @param goods the goods
     * @return the selected ship cargo
     */
    public int getSelectedShipCargo(TradeGoods goods) {
        return userPlayer.getSelectedShipCargo(goods);
    }

    /**
     * Gets used cargo size.
     *
     * @return the used cargo size
     */
    public int getUsedCargoSize() {
        return userPlayer.getUsedCargoSize();
    }

    /**
     * Gets max cargo size.
     *
     * @return the max cargo size
     */
    public int getMaxCargoSize() {
        return userPlayer.getMaxCargoSize();
    }

    /**
     * Add cargo amount.
     *
     * @param good   the good
     * @param amount the amount
     */
    public void addCargoAmount(TradeGoods good, int amount) {
        userPlayer.addCargoAmount(good, amount);
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        userPlayer.setName(name);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return userPlayer.getName();
    }

    /**
     * Gets difficulty string.
     *
     * @return the difficulty string
     */
    public String getDifficultyString() {
        return userPlayer.getDifficultyName();
    }

    /**
     * Sets difficulty.
     *
     * @param difficulty the difficulty
     */
    public void setDifficulty(Difficulty difficulty) {
        userPlayer.setDifficulty(difficulty);
    }

    /**
     * Gets skill pilot.
     *
     * @return the skill pilot
     */
    public int getSkillPilot() {
        return userPlayer.getSkillPilot();
    }

    /**
     * Gets skill fighter.
     *
     * @return the skill fighter
     */
    public int getSkillFighter() {
        return userPlayer.getSkillFighter();
    }

    /**
     * Gets skill engineer.
     *
     * @return the skill engineer
     */
    public int getSkillEngineer() {
        return userPlayer.getSkillEngineer();
    }

    /**
     * Gets skill trader.
     *
     * @return the skill trader
     */
    public int getSkillTrader() {
        return userPlayer.getSkillTrader();
    }

    /**
     * Sets skill pilot.
     *
     * @param skill the skill
     */
    public void setSkillPilot(int skill) {
        userPlayer.setSkillPilot(skill);
    }

    /**
     * Sets skill fighter.
     *
     * @param skill the skill
     */
    public void setSkillFighter(int skill) {
        userPlayer.setSkillFighter(skill);
    }

    /**
     * Sets skill engineer.
     *
     * @param skill the skill
     */
    public void setSkillEngineer(int skill) {
        userPlayer.setSkillEngineer(skill);
    }

    /**
     * Sets skill trader.
     *
     * @param skill the skill
     */
    public void setSkillTrader(int skill) {
        userPlayer.setSkillTrader(skill);
    }

    /**
     * Gets current ship type.
     *
     * @return the current ship type
     */
    public String getCurrentShipType() {
        return userPlayer.getCurrentShipType();
    }

    /**
     * Get current name char array char [ ].
     *
     * @return the char [ ]
     */
    public char[] getCurrentNameCharArray(){
        return userPlayer.getCurrentNameCharArray();
    }

    /**
     * Get current system name string.
     *
     * @return the string
     */
    public String getCurrentSystemName(){
       return universe.getSelectedSystemName(currentLocation);
    }

    /**
     * Get current system resources string.
     *
     * @return the string
     */
    public String getCurrentSystemResources(){
        return universe.getSelectedSystemResources(currentLocation);
    }

    /**
     * Get current system tech level string.
     *
     * @return the string
     */
    public String getCurrentSystemTechLevel(){
        return universe.getSelectedSystemTechLevel(currentLocation);
    }

    /**
     * Get current ship fuel int.
     *
     * @return the int
     */
    public int getCurrentShipFuel(){
        return userPlayer.getCurrentShipFuel();
    }

    /**
     * Get system list list.
     *
     * @return the list
     */
    public List<SolarSystem> getSystemList(){
        return universe.getSystemList();
    }

    /**
     * Set fuel.
     *
     * @param amount the amount
     */
    public void setFuel(int amount){
         userPlayer.setFuel(amount);
    }

    /**
     * Get max fuel int.
     *
     * @return the int
     */
    public int getMaxFuel(){
        return userPlayer.getMaxFuel();
    }

}
