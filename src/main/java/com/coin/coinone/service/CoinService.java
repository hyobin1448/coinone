package com.coin.coinone.service;

import com.coin.coinone.dao.CoinDao;
import com.coin.coinone.domain.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
