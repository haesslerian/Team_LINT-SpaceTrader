package com.example.spacetrader.viewmodel;

import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.TradeGoods;
import com.example.spacetrader.model.Repository;

/**
 * The type Buy goods view model.
 */
public class BuyGoodsViewModel extends RepositoryLinkedViewModel {

    /**
     * Get cargo space string.
     *
     * @return the string
     */
    public String getCargoSpace(){
        Repository repo = getRepositoryValue();
        int usedCargoSize = repo.getUsedCargoSize();
        int maxCargoSize = repo.getMaxCargoSize();
        String output = Integer.toString(usedCargoSize);
        output = output + "/" + Integer.toString(maxCargoSize);
        return output;
    }

    /**
     * Make transaction.
     *
     * @param tradeGoods the trade goods
     * @param selling    the selling
     */
    public void makeTransaction(TradeGoods tradeGoods, boolean selling){
        Repository changes = getRepositoryValue();
        SolarSystem currentSystem = changes.getCurrentSystem();
        int amount = currentSystem.getSelectedTradeGoodAmount(tradeGoods);
        int price = currentSystem.getSelectedTradeGoodPrice(tradeGoods);
        if(!selling &&
                (changes.getUsedCargoSize() < changes.getMaxCargoSize()) &&
                (amount > 0) && (price < changes.getCredits())){
            changes.setCredits(changes.getCredits() - price);
            changes.addCargoAmount(tradeGoods, 1);
            currentSystem.setTradeGoodAmount(tradeGoods, amount - 1);
        }
        else if(selling && (changes.getSelectedShipCargo(tradeGoods) > 0)){
            double TRADE_MODIFIER = .1;
            changes.setCredits(changes.getCredits() + (int)(price - (price * TRADE_MODIFIER)));
                changes.addCargoAmount(tradeGoods, -1);
                currentSystem.setTradeGoodAmount(tradeGoods, amount + 1);
            }
        mRepository.setValue(changes);
    }
}
