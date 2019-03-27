package com.example.spacetrader.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.TradeGoods;
import com.example.spacetrader.model.Repository;
import com.example.spacetrader.viewmodel.BuyGoodsViewModel;

import java.util.HashMap;
import java.util.Iterator;

public class BuyGoodsActivity extends AppCompatActivity {

    private TextView credits;
    private TextView cargospace;
    private final int PLANET_AMOUNT_VIEW = 0, PRICE_VIEW = 1, BUYBTN = 2, SELLBTN = 3, SHIP_AMOUNT_VIEW = 4;
    private HashMap<TradeGoods, TextView[]> viewArray;
    private BuyGoodsViewModel mBuyGoodsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_goods);
        credits = findViewById(R.id.creditsValue);
        cargospace = findViewById(R.id.cargoSpaceValue);
        viewArray = new HashMap<>();
        viewArray.put(TradeGoods.WATER, new TextView[]{findViewById(R.id.waterAmount), findViewById(R.id.waterPrice), findViewById(R.id.addWater), findViewById(R.id.subWater), findViewById(R.id.waterAmountShip)});
        viewArray.put(TradeGoods.FURS, new TextView[]{findViewById(R.id.furAmount), findViewById(R.id.furPrice), findViewById(R.id.addFur), findViewById(R.id.subFur), findViewById(R.id.furAmountShip)});
        viewArray.put(TradeGoods.FOOD, new TextView[]{findViewById(R.id.foodAmount), findViewById(R.id.foodPrice), findViewById(R.id.addFood), findViewById(R.id.subFood), findViewById(R.id.foodAmountShip)});
        viewArray.put(TradeGoods.ORE, new TextView[]{findViewById(R.id.oreAmount), findViewById(R.id.orePrice), findViewById(R.id.addOre), findViewById(R.id.subOre), findViewById(R.id.oreAmountShip)});
        viewArray.put(TradeGoods.GAMES, new TextView[]{findViewById(R.id.gamesAmount), findViewById(R.id.gamesPrice), findViewById(R.id.addGames), findViewById(R.id.subGames), findViewById(R.id.gamesAmountShip)});
        viewArray.put(TradeGoods.FIREARMS, new TextView[]{findViewById(R.id.firearmsAmount), findViewById(R.id.firearmsPrice), findViewById(R.id.addFirearms), findViewById(R.id.subFirearms), findViewById(R.id.firearmsAmountShip)});
        viewArray.put(TradeGoods.MEDICINE, new TextView[]{findViewById(R.id.medicineAmount), findViewById(R.id.medicinePrice), findViewById(R.id.addMedicine), findViewById(R.id.subMedicine), findViewById(R.id.medicineAmountShip)});
        viewArray.put(TradeGoods.MACHINES, new TextView[]{findViewById(R.id.machinesAmount), findViewById(R.id.machinesPrice), findViewById(R.id.addMachines), findViewById(R.id.subMachines), findViewById(R.id.machinesAmountShip)});
        viewArray.put(TradeGoods.NARCOTICS, new TextView[]{findViewById(R.id.narcoticsAmount), findViewById(R.id.narcoticsPrice), findViewById(R.id.addNarcotics), findViewById(R.id.subNarcotics), findViewById(R.id.narcoticsAmountShip)});
        viewArray.put(TradeGoods.ROBOTS, new TextView[]{findViewById(R.id.robotsAmount), findViewById(R.id.robotsPrice), findViewById(R.id.addRobots), findViewById(R.id.subRobots), findViewById(R.id.robotsAmountShip)});
        mBuyGoodsViewModel = ViewModelProviders.of(this).get(BuyGoodsViewModel.class);
        mBuyGoodsViewModel.init();
        mBuyGoodsViewModel.getRepository().observe(this, new Observer<Repository>() {
            @Override
            public void onChanged(@Nullable Repository repository) {
                updateValues(repository);
            }
        });
        setUpButtons();
    }

    private void setUpButtons(){
        Iterator<TradeGoods> goodsList = mBuyGoodsViewModel.getRepository().getValue().getTradeGoodsIterator();
        TextView[] tradeGoodUpdatables;
        while(goodsList.hasNext()){
            TradeGoods good = goodsList.next();
            tradeGoodUpdatables = viewArray.get(good);
            tradeGoodUpdatables[BUYBTN].setOnClickListener(getListener(good, false));
            tradeGoodUpdatables[SELLBTN].setOnClickListener(getListener(good, true));
        }
    }

    private View.OnClickListener getListener(final TradeGoods tradeGoods, final boolean selling){
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               makeTransaction(tradeGoods, selling);

            }
        };
    }

    private void updateValues(Repository repository){
        credits.setText(Integer.toString(repository.getUserPlayer().getCredits()));
        cargospace.setText(mBuyGoodsViewModel.getCargoSpace());
        SolarSystem currentSystem = repository.getUniverse().getSolarSystemHashMap().get(repository.getCurrentLocation());
        Iterator<TradeGoods> goodsList = repository.getTradeGoodsIterator();
        TextView[] tradeGoodUpdatables;
        while(goodsList.hasNext()){
            TradeGoods good = goodsList.next();
            tradeGoodUpdatables = viewArray.get(good);
            int amount = currentSystem.getTradeGoodAmount().get(good);
            int price = currentSystem.getTradeGoodPrices().get(good);
            tradeGoodUpdatables[PLANET_AMOUNT_VIEW].setText(Integer.toString(amount));
            tradeGoodUpdatables[PRICE_VIEW].setText(Integer.toString(price) + " Cr.");
            tradeGoodUpdatables[SHIP_AMOUNT_VIEW].setText(Integer.toString(repository.getUserPlayer().getCurrentShip().getCargo().get(good)));
        }
    }

    private void makeTransaction(TradeGoods tradeGoods, boolean selling){
        mBuyGoodsViewModel.makeTransaction(tradeGoods, selling);
    }
}
