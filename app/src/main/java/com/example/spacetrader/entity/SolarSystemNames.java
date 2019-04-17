package com.example.spacetrader.entity;

/**
 * The enum Solar system names.
 */
public enum SolarSystemNames {
    /**
     * Culc solar system names.
     */
    CULC ("CULC"),
    /**
     * Skiles solar system names.
     */
    SKILES ("Skiles"),
    /**
     * Howey solar system names.
     */
    HOWEY ("Howey"),
    /**
     * Crc solar system names.
     */
    CRC ("CRC"),
    /**
     * The Northave.
     */
    NORTHAVE ("North Ave"),
    /**
     * Couch solar system names.
     */
    COUCH ("Couch"),
    /**
     * Woodruff solar system names.
     */
    WOODRUFF ("Woodruff"),
    /**
     * Brittain solar system names.
     */
    BRITTAIN ("Brittain"),
    /**
     * The Twistedtaco.
     */
    TWISTEDTACO ("Twisted Taco"),
    /**
     * Klaus solar system names.
     */
    KLAUS ("Klaus");

    private final String code;

    SolarSystemNames(String code) {
        this.code = code;
    }

    // --Commented out by Inspection (4/14/19, 7:43 PM):public String getCode() { return code; }

    public String toString() {
        return code;
    }
}
