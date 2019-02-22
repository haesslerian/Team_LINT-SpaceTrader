package com.example.spacetrader.model;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Universe;

public class Repository {

    private Player userPlayer;
    private Universe universe;

    public Repository(){
        userPlayer = new Player();
        universe = new Universe();
    }

    public Player getUserPlayer() {
        return userPlayer;
    }

    public void setUserPlayer(Player userPlayer) {
        this.userPlayer = userPlayer;
    }

}
