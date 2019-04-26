package com.example.spacetrader.viewmodel;

import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.TradeGoods;
import com.example.spacetrader.model.Repository;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Updates changes made in the marketplace to cargo and credits
 */
public class BuyGoodsViewModel extends RepositoryLinkedViewModel {

    /**
     * Gets the size of the users cargo and the space that has been used so far
     *
     * @return a string that states the space used out of the total space
     */
    public String getCargoSpace(){
        String output = Integer.toString(mRepository.getValue().getUserPlayer().getCurrentShip().getUsedCargoSize());
        output = output + "/" + Integer.toString(mRepository.getValue().getUserPlayer().getCurrentShip().getCargoSize());
        return output;
    }

    /**
     * Changes the amount of an item owned by the user and the number of credits owned by the user
     * as he/she buys and sells in the market place
     *
     * @param tradeGoods the TradeGood that is being modified
     * @param selling boolean for whether or not the good is being sold or not
     */
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
