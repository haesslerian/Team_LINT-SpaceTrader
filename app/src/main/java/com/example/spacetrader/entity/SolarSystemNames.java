package com.example.spacetrader.entity;

public enum SolarSystemNames {
    CULC ("CULC"),
    SKILES ("Skiles"),
    HOWEY ("Howey"),
    CRC ("CRC"),
    NORTHAVE ("North Ave"),
    COUCH ("Couch"),
    WOODRUFF ("Woodruff"),
    BRITTAIN ("Brittain"),
    TWISTEDTACO ("Twisted Taco"),
    KLAUS ("Klaus");

    private final String code;

    SolarSystemNames(String code) {
        this.code = code;
    }

    public String getCode() { return code; }

    public String toString() {
        return code;
    }
}
