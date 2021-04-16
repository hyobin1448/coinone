package com.coin.coinone.dao;

import com.coin.coinone.domain.Coin;
import com.coin.coinone.domain.Ticker;
import com.coin.coinone.domain.TickerList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CoinDao {
    public List<Coin> searchCoinList();
    public void insertCoin(Coin coin);
    public void insertTicker(Ticker ticker);
    public Ticker searchTicker(Ticker ticker);
    public String getCalcN(Ticker ticker);
}
