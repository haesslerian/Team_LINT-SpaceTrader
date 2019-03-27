package com.example.spacetrader.entity;

public enum TradeGoods {
    WATER("Water", 0, 0, Resources.LOTSOFWATER, 30, 3), FURS("Furs", 0 ,0, Resources.RICHFAUNA, 250, 10), FOOD("Food", 1, 0, Resources.RICHSOIL, 100, 5), ORE("Ore", 2, 2, Resources.MINERALRICH, 350, 20),
    GAMES("Games", 3, 1, Resources.ARTISTIC, 250, -10), FIREARMS("Firearms", 3, 1, Resources.WARLIKE, 1250, -75), MEDICINE("Medicine", 4, 1, Resources.LOTSOFHERBS, 650, -20),
    MACHINES("Machines", 4, 3, null, 900, -30), NARCOTICS("Narcotics", 5, 0, Resources.WEIRDMUSHROOMS, 3500, -125), ROBOTS("Robots", 6, 4, null, 5000, -150);

    private final String name;
    //Minimum Tech Level to Produce this resource
    private final int MTLP;
    //Minimum Tech Level to sell this resource
    private final int MTLU;
    //Low Price Event
    private final Resources CR;
    //Base Price
    private final int basePrice;
    //Price increase pre Tech Level
    private final int IPL;
    TradeGoods(String name, int MTLP, int MTLU, Resources CR, int basePrice, int IPL){
        this.name = name;
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.CR = CR;
        this.basePrice = basePrice;
        this.IPL = IPL;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getMTLP() {
        return MTLP;
    }

    public int getMTLU() {
        return MTLU;
    }

    public Resources getCR() {
        return CR;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getIPL() {
        return IPL;
    }
}
