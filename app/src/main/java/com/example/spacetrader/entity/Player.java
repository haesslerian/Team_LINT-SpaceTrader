package com.example.spacetrader.entity;

/**
 * @author lukemuehring
 * @version 1.0
 *
 * Holds information pertaining to the user
 */
public class Player {
    private int skillPilot;
    private int skillFighter;
    private int skillTrader;
    private int skillEngineer;

    private int credits;
    private String name;
    private Difficulty difficulty;

    private Ship currentShip;

    /**
     * Player constructor
     *
     * @param name the name of the user
     * @param difficulty the difficulty of the game
     * @param skillPilot number of skill points for the pilot skill
     * @param skillFighter number of skill points for the fighter skill
     * @param skillTrader number of skill points for the trader skill
     * @param skillEngineer number of skill points for the engineer skill
     * @param credits the number of credits the user has
     * @param shipType the type of ship being used by the user
     */
    public Player(String name, Difficulty difficulty, int skillPilot, int skillFighter, int skillTrader, int skillEngineer, int credits, ShipTypes shipType) {
        this.name = name;
        this.difficulty = difficulty;
        this.skillPilot = skillPilot;
        this.skillFighter = skillFighter;
        this.skillTrader = skillTrader;
        this.skillEngineer = skillEngineer;
        this.credits = credits;
        this.currentShip = new Ship(shipType);
    }

    /**
     * Default constructor for player
     */
    public Player(){
        this("DEFAULT", Difficulty.BEGINNER, 1,1,1,1,1000, ShipTypes.GNAT);
    }

    /**
     * Getter method for the number of pilot skill points
     * @return the number of points
     */
    public int getSkillPilot() {
        return skillPilot;
    }

    /**
     * Setter method for the pilot skill points
     * @param skillPilot the number of points to set
     */
    public void setSkillPilot(int skillPilot) {
        this.skillPilot = skillPilot;
    }

    /**
     * Getter method for the number of fighter skill points
     * @return the number of points
     */
    public int getSkillFighter() {
        return skillFighter;
    }

    /**
     * Setter method for the fighter skill points
     * @param skillFighter the number of points to set
     */
    public void setSkillFighter(int skillFighter) {
        this.skillFighter = skillFighter;
    }

    /**
     * Getter method for the number of trader skill points
     * @return the number of points
     */
    public int getSkillTrader() {
        return skillTrader;
    }

    /**
     * Setter method for the trader skill points
     * @param skillTrader the number of points to set
     */
    public void setSkillTrader(int skillTrader) {
        this.skillTrader = skillTrader;
    }

    /**
     * Getter method for the number of engineer skill points
     * @return the number of points
     */
    public int getSkillEngineer() {
        return skillEngineer;
    }

    /**
     * Setter method for the engineer skill points
     * @param skillEngineer the number of points to set
     */
    public void setSkillEngineer(int skillEngineer) {
        this.skillEngineer = skillEngineer;
    }

    /**
     * Getter method for the player name
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the player name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the difficulty of the game
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Setter method for the difficulty of the game
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Getter method for the number of credits the player has
     * @return the number of credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Setter method for the credits
     * @param credits the number of credits the player has
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Getter method for the ship the player is using
     * @return the name of the ship
     */
    public Ship getCurrentShip() {
        return currentShip;
    }

    /**
     * Setter method for the ship the player is using
     * @param currentShip the new ship the player is using
     */
    public void setCurrentShip(Ship currentShip) {
        this.currentShip = currentShip;
    }
}
