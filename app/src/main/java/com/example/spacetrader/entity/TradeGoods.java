package com.example.spacetrader.entity;

/**
 * The enum Trade goods.
 */
public enum TradeGoods {
    /**
     * Water trade goods.
     */
    WATER("Water", 0, 0, Resources.LOTSOFWATER, 30, 3),
    /**
     * Furs trade goods.
     */
    FURS("Furs", 0 ,0, Resources.RICHFAUNA, 250, 10),
    /**
     * Food trade goods.
     */
    FOOD("Food", 1, 0, Resources.RICHSOIL, 100, 5),
    /**
     * Ore trade goods.
     */
    ORE("Ore", 2, 2, Resources.MINERALRICH, 350, 20),
    /**
     * Games trade goods.
     */
    GAMES("Games", 3, 1, Resources.ARTISTIC, 250, -10),
    /**
     * Firearms trade goods.
     */
    FIREARMS("Firearms", 3, 1, Resources.WARLIKE, 1250, -75),
    /**
     * Medicine trade goods.
     */
    MEDICINE("Medicine", 4, 1, Resources.LOTSOFHERBS, 650, -20),
    /**
     * Machines trade goods.
     */
    MACHINES("Machines", 4, 3, null, 900, -30),
    /**
     * Narcotics trade goods.
     */
    NARCOTICS("Narcotics", 5, 0, Resources.WEIRDMUSHROOMS, 3500, -125),
    /**
     * Robots trade goods.
     */
    ROBOTS("Robots", 6, 4, null, 5000, -150);

    private final String name;
    //Minimum Tech Level to Produce this resource
    private final int MTLP;
    //Base Price
    private final int basePrice;
    //Price increase pre Tech Level
    private final int IPL;
    TradeGoods(String name, int MTLP, int MTLU, Resources CR, int basePrice, int IPL){
        this.name = name;
        this.MTLP = MTLP;
        //Minimum Tech Level to sell this resource
        //Low Price Event
        this.basePrice = basePrice;
        this.IPL = IPL;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets mtlp.
     *
     * @return the mtlp
     */
    public int getMTLP() {
        return MTLP;
    }

// --Commented out by Inspection START (4/14/19, 7:43 PM):
//    public int getMTLU() {
//        return MTLU;
//    }
// --Commented out by Inspection STOP (4/14/19, 7:43 PM)

// --Commented out by Inspection START (4/14/19, 7:43 PM):
//    public Resources getCR() {
//        return CR;
//    }
// --Commented out by Inspection STOP (4/14/19, 7:43 PM)

    /**
     * Gets base price.
     *
     * @return the base price
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * Gets ipl.
     *
     * @return the ipl
     */
    public int getIPL() {
        return IPL;
    }
}
