package com.example.spacetrader.entity;

import java.io.Serializable;

public class Player implements Serializable {
    private int skillPilot;
    private int skillFighter;
    private int skillTrader;
    private int skillEngineer;

    private int credits;
    private String name;
    private Difficulty difficulty;

    private Ship currentShip;

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

    public Player(){
        this("DEFAULT", Difficulty.BEGINNER, 1,1,1,1,1000, ShipTypes.GNAT);
    }

    public int getSkillPilot() {
        return skillPilot;
    }

    public void setSkillPilot(int skillPilot) {
        this.skillPilot = skillPilot;
    }

    public int getSkillFighter() {
        return skillFighter;
    }

    public void setSkillFighter(int skillFighter) {
        this.skillFighter = skillFighter;
    }

    public int getSkillTrader() {
        return skillTrader;
    }

    public void setSkillTrader(int skillTrader) {
        this.skillTrader = skillTrader;
    }

    public int getSkillEngineer() {
        return skillEngineer;
    }

    public void setSkillEngineer(int skillEngineer) {
        this.skillEngineer = skillEngineer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Ship getCurrentShip() {
        return currentShip;
    }

    public void setCurrentShip(Ship currentShip) {
        this.currentShip = currentShip;
    }
}
