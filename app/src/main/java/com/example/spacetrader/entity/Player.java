package com.example.spacetrader.entity;

import java.io.Serializable;

/**
 * The type Player.
 */
public class Player implements Serializable {
    private int skillPilot;
    private int skillFighter;
    private int skillTrader;
    private int skillEngineer;

    private int credits;
    private String name;
    private Difficulty difficulty;

    private final Ship currentShip;

    private Player(String name) {
        this.name = name;
        this.difficulty = Difficulty.BEGINNER;
        this.skillPilot = 1;
        this.skillFighter = 1;
        this.skillTrader = 1;
        this.skillEngineer = 1;
        this.credits = 1000;
        this.currentShip = new Ship(ShipTypes.GNAT);
    }

    /**
     * Instantiates a new Player.
     */
    public Player(){
        this("DEFAULT");
    }

    /**
     * Gets skill pilot.
     *
     * @return the skill pilot
     */
    public int getSkillPilot() {
        return skillPilot;
    }

    /**
     * Sets skill pilot.
     *
     * @param skillPilot the skill pilot
     */
    public void setSkillPilot(int skillPilot) {
        this.skillPilot = skillPilot;
    }

    /**
     * Gets skill fighter.
     *
     * @return the skill fighter
     */
    public int getSkillFighter() {
        return skillFighter;
    }

    /**
     * Sets skill fighter.
     *
     * @param skillFighter the skill fighter
     */
    public void setSkillFighter(int skillFighter) {
        this.skillFighter = skillFighter;
    }

    /**
     * Gets skill trader.
     *
     * @return the skill trader
     */
    public int getSkillTrader() {
        return skillTrader;
    }

    /**
     * Sets skill trader.
     *
     * @param skillTrader the skill trader
     */
    public void setSkillTrader(int skillTrader) {
        this.skillTrader = skillTrader;
    }

    /**
     * Gets skill engineer.
     *
     * @return the skill engineer
     */
    public int getSkillEngineer() {
        return skillEngineer;
    }

    /**
     * Sets skill engineer.
     *
     * @param skillEngineer the skill engineer
     */
    public void setSkillEngineer(int skillEngineer) {
        this.skillEngineer = skillEngineer;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

// --Commented out by Inspection START (4/14/19, 10:50 PM):
//    /**
//     * Gets difficulty.
//     *
//     * @return the difficulty
//     */
//    public Difficulty getDifficulty() {
//        return difficulty;
//    }
// --Commented out by Inspection STOP (4/14/19, 10:50 PM)

    /**
     * Sets difficulty.
     *
     * @param difficulty the difficulty
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets credits.
     *
     * @return the credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets credits.
     *
     * @param credits the credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

// --Commented out by Inspection START (4/15/19, 11:16 AM):
//    /**
//     * Gets current ship.
//     *
//     * @return the current ship
//     */
//    public Ship getCurrentShip() {
//        return currentShip;
//    }
// --Commented out by Inspection STOP (4/15/19, 11:16 AM)

// --Commented out by Inspection START (4/14/19, 7:43 PM):
//    public void setCurrentShip(Ship currentShip) {
//        this.currentShip = currentShip;
//    }
// --Commented out by Inspection STOP (4/14/19, 7:43 PM)

    /**
     * Get selected ship cargo int.
     *
     * @param goods the goods
     * @return the int
     */
    public int getSelectedShipCargo(TradeGoods goods){
        return currentShip.getSelectedCargo(goods);
    }

    /**
     * Get used cargo size int.
     *
     * @return the int
     */
    public int getUsedCargoSize(){
        return currentShip.getUsedCargoSize();
    }

    /**
     * Get max cargo size int.
     *
     * @return the int
     */
    public int getMaxCargoSize(){
        return currentShip.getCargoSize();
    }

    /**
     * Add cargo amount.
     *
     * @param good   the good
     * @param amount the amount
     */
    public void addCargoAmount(TradeGoods good, int amount){
         currentShip.addCargoAmount(good, amount);
    }

    /**
     * Get current ship type string.
     *
     * @return the string
     */
    public String getCurrentShipType(){
       return currentShip.getCurrentShipType();
    }

    /**
     * Get difficulty name string.
     *
     * @return the string
     */
    public String getDifficultyName(){
        return difficulty.toString();
    }

    /**
     * Get current name char array char [ ].
     *
     * @return the char [ ]
     */
    public char[] getCurrentNameCharArray(){
        return name.toCharArray();
    }

    /**
     * Get current ship fuel int.
     *
     * @return the int
     */
    public int getCurrentShipFuel(){
        return currentShip.getCurrentFuel();
    }

    /**
     * Set fuel.
     *
     * @param amount the amount
     */
    public void setFuel(int amount){
        currentShip.setCurrentFuel(amount);
    }

    /**
     * Get max fuel int.
     *
     * @return the int
     */
    public int getMaxFuel(){
        return currentShip.getFuelSize();
    }

}
