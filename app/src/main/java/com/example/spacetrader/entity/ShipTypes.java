package com.example.spacetrader.entity;

/**
 * The enum Ship types.
 */
public enum ShipTypes {
    /**
     * Gnat ship types.
     */
    GNAT ("Gnat"),
    /**
     * Flea ship types.
     */
    FLEA ("Flea"),
    /**
     * Firefly ship types.
     */
    FIREFLY ("Firefly"),
    /**
     * Mosquito ship types.
     */
    MOSQUITO ("Mosquito"),
    /**
     * Bumblebee ship types.
     */
    BUMBLEBEE ("Bumblebee"),
    /**
     * Beetle ship types.
     */
    BEETLE ("Beetle"),
    /**
     * Hornet ship types.
     */
    HORNET ("Hornet"),
    /**
     * Grasshopper ship types.
     */
    GRASSHOPPER ("Grasshopper"),
    /**
     * Termite ship types.
     */
    TERMITE ("Termite"),
    /**
     * Wasp ship types.
     */
    WASP ("Wasp");

    private final String names;

    ShipTypes(String names){
        this.names = names;
    }


    public String toString() { return names; }
}
