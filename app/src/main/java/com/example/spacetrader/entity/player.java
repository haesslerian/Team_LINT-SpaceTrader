package com.example.spacetrader.entity;

public class Player {
    private int skillPilot, skillFighter, skillTrader, skillEngineer;
    private String name;
    private Difficulty difficulty;

    public Player(String name, Difficulty difficulty, int skillPilot, int skillFighter, int skillTrader, int skillEngineer) {
        this.name = name;
        this.difficulty = difficulty;
        this.skillPilot = skillPilot;
        this.skillFighter = skillFighter;
        this.skillTrader = skillTrader;
        this.skillEngineer = skillEngineer;
    }

    public Player(){
        this("DEFAULT", Difficulty.BEGINNER, 1,1,1,1);
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
}
