package com.example.spacetrader.entity;

public enum ResourceType {
    NOSPECIALRESOURCES ("No Special Resources"),
    MINERALRICH ("Mineral Rich"),
    MINERALPOOR ("Mineral Poor"),
    DESERT ("Desert"),
    LOTSOFWATER ("Lots of Water"),
    RISCHSOIL ("Rich Soil"),
    POORSOIL ("Poor Soil"),
    RICHFAUNA ("Rich Fauna"),
    LIFELESS ("Lifeless"),
    WEIRDMUSHROOMS ("Weird Mushrooms"),
    LOTSOFHERBS ("Lots of Herbs"),
    ARTISTIC ("Artistic"),
    WARLIKE ("Warlike");

    private final String code;

    ResourceType(String code) {
        this.code = code;
    }

    public String toString() { return code; }
}