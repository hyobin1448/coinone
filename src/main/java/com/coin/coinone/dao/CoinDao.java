package com.coin.coinone.dao;

import com.coin.coinone.domain.Coin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CoinDao {
    public List<Coin> searchCoinList();
    public void insertCoin(Coin coin);
}
