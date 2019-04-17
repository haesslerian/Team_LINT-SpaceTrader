package com.example.spacetrader;

import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.ShipTypes;
import com.example.spacetrader.entity.TradeGoods;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ShipAddCargoTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testCargoIsCorrectlyAdded(){
        Ship test = new Ship(ShipTypes.FLEA);
        test.addCargoAmount(TradeGoods.FIREARMS, 2);
        assertEquals(2, test.getSelectedCargo(TradeGoods.FIREARMS));
        test.addCargoAmount(TradeGoods.FIREARMS, 2);
        assertEquals(4, test.getSelectedCargo(TradeGoods.FIREARMS));
        test.addCargoAmount(TradeGoods.FIREARMS, -1);
        assertEquals(3, test.getSelectedCargo(TradeGoods.FIREARMS));
    }

    @Test
    public void testAddingNull(){
        Ship test = new Ship(ShipTypes.FLEA);
        exception.expect(IllegalArgumentException.class);
        test.addCargoAmount(null, 2);
    }

    @Test
    public void addOverMax(){
        Ship test = new Ship(ShipTypes.FLEA);
        test.addCargoAmount(TradeGoods.FIREARMS, 100);
        assertEquals(0, test.getSelectedCargo(TradeGoods.FIREARMS));
    }

    @Test
    public void addLessThan0(){
        Ship test = new Ship(ShipTypes.FLEA);
        test.addCargoAmount(TradeGoods.FIREARMS, -1);
        assertEquals(0, test.getSelectedCargo(TradeGoods.FIREARMS));
    }
}
