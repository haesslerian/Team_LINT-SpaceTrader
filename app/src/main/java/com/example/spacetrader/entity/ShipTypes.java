package com.example.spacetrader.entity;

import java.io.Serializable;

public enum ShipTypes implements Serializable {
    GNAT ("Gnat"), FLEA ("Flea"), FIREFLY ("Firefly"), MOSQUITO ("Mosquito"),
    BUMBLEBEE ("Bumblebee"), BEETLE ("Beetle"), HORNET ("Hornet"), GRASSHOPPER ("Grasshopper"),
    TERMITE ("Termite"), WASP ("Wasp");

    private final String names;

    ShipTypes(String names){
        this.names = names;
    }

    public String toString() { return names; }
}
