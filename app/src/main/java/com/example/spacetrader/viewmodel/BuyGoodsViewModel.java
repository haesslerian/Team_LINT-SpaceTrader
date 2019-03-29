package com.example.spacetrader.viewmodel;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.TradeGoods;
import com.example.spacetrader.model.Repository;

import java.util.HashMap;

public class BuyGoodsViewModel extends RepositoryLinkedViewModel {

    public String getCargoSpace(){
        String output = Integer.toString(mRepository.getValue().getUserPlayer().getCurrentShip().getUsedCargoSize());
        output = output + "/" + Integer.toString(mRepository.getValue().getUserPlayer().getCurrentShip().getCargoSize());
        return output;
    }

    public void makeTransaction(TradeGoods tradeGoods, boolean selling){
        Repository changes = mRepository.getValue();
        Ship currShip = changes.getUserPlayer().getCurrentShip();
        SolarSystem currentSystem = changes.getUniverse().getSolarSystemHashMap().get(changes.getCurrentLocation());
        int amount = currentSystem.getTradeGoodAmount().get(tradeGoods);
        int price = currentSystem.getTradeGoodPrices().get(tradeGoods);
        if(!selling && currShip.getUsedCargoSize() < currShip.getCargoSize() && amount > 0 && price < changes.getUserPlayer().getCredits()){
            changes.getUserPlayer().setCredits(changes.getUserPlayer().getCredits() - price);
            currShip.addCargoAmount(tradeGoods, 1);
            currentSystem.getTradeGoodAmount().put(tradeGoods, amount - 1);
        }
        else if(selling && currShip.getCargo().get(tradeGoods) > 0){
                changes.getUserPlayer().setCredits(changes.getUserPlayer().getCredits() + (int)(price - (price * .1)));
                currShip.addCargoAmount(tradeGoods, -1);
                currentSystem.getTradeGoodAmount().put(tradeGoods, amount + 1);
            }
        mRepository.setValue(changes);
    }
}
