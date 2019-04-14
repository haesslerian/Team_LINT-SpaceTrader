package com.example.spacetrader.entity;

import java.io.Serializable;

public enum SolarSystemNames implements Serializable {
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
