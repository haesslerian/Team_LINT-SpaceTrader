package com.example.spacetrader.entity;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Defines a point used for solar system location
 */
public class Point  {
    private final int x;
    private final int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the X location
     * @return the X location of the solar system
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the Y location
     * @return the Y location of the solar system
     */
    public int getY() {
        return y;
    }

    /**
     * Determines the distance from one point to the next
     * @param point the point to calculate the distance from
     * @return the distance from this point to the passed in point
     */
    public int distanceFrom(Point point){
       return (int)Math.sqrt((((point.getX() - this.x)*(point.getX() - this.x)) + ((point.getY() - this.y)*(point.getY() - this.y))));
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        Point toCompare = (Point) o;
        return (this.x == toCompare.getX() && this.y == toCompare.getY());
    }
}
