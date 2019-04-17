package com.example.spacetrader.entity;

import java.io.Serializable;


/**
 * The type Planet.
 */
class Planet implements Serializable {
    private final String name;

    /**
     * Instantiates a new Planet.
     *
     * @param name the name
     */
    Planet(String name){
        this.name = name;
    }

// --Commented out by Inspection START (4/14/19, 7:43 PM):
// --Commented out by Inspection START (4/14/19, 7:43 PM):
////    public String getName() {
////        return name;
////    }
//// --Commented out by Inspection STOP (4/14/19, 7:43 PM)
// --Commented out by Inspection STOP (4/14/19, 7:43 PM)

// --Commented out by Inspection START (4/14/19, 7:46 PM):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (4/14/19, 7:46 PM)

    @Override
    public String toString() {
        return ("Planet: " + name );
    }
}
