package com.example.spacetrader.entity;

/**
 * The enum Resources.
 */
public enum Resources {
    /**
     * The Nospecialresources.
     */
    NOSPECIALRESOURCES("No Special Resources"),
    /**
     * The Mineralrich.
     */
    MINERALRICH("Mineral Rich"),
    /**
     * The Mineralpoor.
     */
    MINERALPOOR("Mineral Poor"),
    /**
     * Desert resources.
     */
    DESERT("Desert"),
    /**
     * The Lotsofwater.
     */
    LOTSOFWATER("Lots of Water"),
    /**
     * The Richsoil.
     */
    RICHSOIL("Rich Soil"),
    /**
     * The Poorsoil.
     */
    POORSOIL("Poor Soil"),
    /**
     * The Richfauna.
     */
    RICHFAUNA("Rich Fauna"),
    /**
     * Lifeless resources.
     */
    LIFELESS("Lifeless"),
    /**
     * The Weirdmushrooms.
     */
    WEIRDMUSHROOMS("Weird Mushrooms"),
    /**
     * The Lotsofherbs.
     */
    LOTSOFHERBS("Lots of Herbs"),
    /**
     * Artistic resources.
     */
    ARTISTIC("Artistic"),
    /**
     * Warlike resources.
     */
    WARLIKE("Warlike");

    private final String name;
    Resources(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
