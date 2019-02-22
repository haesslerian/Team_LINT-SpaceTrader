package com.example.spacetrader.model;

import com.example.spacetrader.entity.Player;

public class Repository {

    private Player userPlayer;

    public Repository(){
        userPlayer = new Player();
    }

    public Player getUserPlayer() {
        return userPlayer;
    }

    public void setUserPlayer(Player userPlayer) {
        this.userPlayer = userPlayer;
    }

}
