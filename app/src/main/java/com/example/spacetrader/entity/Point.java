package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Point.
 */
public class Point implements Serializable {
    private final int x;
    private final int y;

    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     */
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Distance from int.
     *
     * @param point the point
     * @return the int
     */
    public int distanceFrom(Point point){
       return (int)Math.sqrt(((
               (point.getX() - this.x)*(point.getX() - this.x)) + (
                       (point.getY() - this.y)*(point.getY() - this.y))));
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Point)){
            return false;
        }
        Point toCompare = (Point) o;
        return ((this.x == toCompare.getX()) && (this.y == toCompare.getY()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
