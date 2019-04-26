package com.example.spacetrader;

import android.arch.lifecycle.MutableLiveData;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.ShipTypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MakeTransactionTest {
    private static final int TIMEOUT = 200;

    Player player;
    Ship ship;

    @Before
    public void setUp() {
        player = new Player ("name", Difficulty.HARD, 3, 4, 5, 3, 1, ShipTypes.BUMBLEBEE);
    }

    @Test(timeout = TIMEOUT)
    public void testGetSkillPilot() {
        assertEquals(3, player.getSkillPilot());
    }

    @Test(timeout = TIMEOUT)
    public void testSetSkillPilot() {
        player.setSkillPilot(1);

        assertEquals(1, player.getSkillPilot());
    }

    @Test(timeout = TIMEOUT)
    public void testGetSkillFighter() {
        assertEquals(4, player.getSkillFighter());
    }

    @Test(timeout = TIMEOUT)
    public void testSetSkillFighter() {
        player.setSkillFighter(5);

        assertEquals(5, player.getSkillFighter());
    }

    @Test(timeout = TIMEOUT)
    public void testGetSkillTrader() {
        assertEquals(5, player.getSkillTrader());
    }

    @Test(timeout = TIMEOUT)
    public void testSetSkillTrader() {
        player.setSkillTrader(3);

        assertEquals(3, player.getSkillTrader());
    }

    @Test(timeout = TIMEOUT)
    public void testGetSkillEngineer() {
        assertEquals(3, player.getSkillEngineer());
    }

    @Test(timeout = TIMEOUT)
    public void testSetSkillEngineer() {
        player.setSkillEngineer(2);

        assertEquals(2, player.getSkillEngineer());
    }

    @Test(timeout = TIMEOUT)
    public void testGetName(){
        assertEquals("name", player.getName());
    }

    @Test(timeout = TIMEOUT)
    public void testSetName() {
        player.setName("newName");

        assertEquals("newName", player.getName());
    }

    @Test(timeout = TIMEOUT)
    public void testGetDifficulty() {
        assertEquals(Difficulty.HARD, player.getDifficulty());
    }

    @Test(timeout = TIMEOUT)
    public void testSetDifficulty() {
        player.setDifficulty(Difficulty.EASY);

        assertEquals(Difficulty.EASY, player.getDifficulty());
    }

    @Test(timeout = TIMEOUT)
    public void testGetCredits() {
        assertEquals(1, player.getCredits());
    }

    @Test(timeout = TIMEOUT)
    public void testSetCredits() {
        player.setCredits(10);

        assertEquals(10, player.getCredits());
    }

    @Test(timeout = TIMEOUT)
    public void testGetCurrentShip() {
        assertEquals(ShipTypes.BUMBLEBEE, player.getCurrentShip());
    }

    @Test(timeout = TIMEOUT)
    public void testSetShip() {
        ship = new Ship(ShipTypes.GRASSHOPPER);
        player.setCurrentShip(ship);

        assertEquals(ShipTypes.GRASSHOPPER, player.getCurrentShip());
    }
}
