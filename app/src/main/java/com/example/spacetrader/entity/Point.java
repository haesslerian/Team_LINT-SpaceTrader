package com.example.spacetrader.entity;

public class Point  {
    private int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
