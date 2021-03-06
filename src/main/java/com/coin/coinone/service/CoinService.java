package com.coin.coinone.service;

import com.coin.coinone.dao.CoinDao;
import com.coin.coinone.domain.Coin;
import com.coin.coinone.domain.Ticker;
import com.coin.coinone.domain.TickerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CoinService {
    @Autowired
    private CoinDao dao;

    public List<Coin> searchCoinList(){
        return dao.searchCoinList();
    }
    public void insertCoin(Coin coin){
        dao.insertCoin(coin);
    }
    public void insertTicker(TickerList list){
        List<Coin> coinList = dao.searchCoinList();
        boolean flag = false;
        HashMap<String,Integer> map = new HashMap<>();
        for (Coin coin: coinList) {
            map.put(coin.getCurrency(),Integer.parseInt(coin.getSec()));
        }
        for (Ticker item:list.getList()) {
            int sec = map.get(item.getCurrency());
            if(Integer.parseInt(list.getSecond())%sec==0) {
                item.setTimestamp(list.getTimestamp());
                try {
                    dao.insertTicker(item);
                }catch (Exception ex){
                    
                }
//                Ticker prvTicker = dao.searchTicker(item);
            }
        }

    }
    private void calcCCI(Ticker prvTicker, Ticker nowTicker){
        double m = calcM(nowTicker);
        double n = Double.parseDouble(dao.getCalcN(nowTicker));
    }
    private double calcM(Ticker ticker){
        double high = Double.parseDouble(ticker.getHigh());
        double low = Double.parseDouble(ticker.getLow());
        double last = Double.parseDouble(ticker.getLast());

        return (high+low+last)/3;
    }
    private double calcSM(Ticker ticker){
        double high = Double.parseDouble(ticker.getHigh());
        double low = Double.parseDouble(ticker.getLow());
        double last = Double.parseDouble(ticker.getLast());

        return (high+low+last)/3;
    }
}
