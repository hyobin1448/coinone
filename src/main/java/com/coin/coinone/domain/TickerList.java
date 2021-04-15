package com.coin.coinone.domain;


import lombok.Data;

import java.util.List;

@Data
public class TickerList {
    private String result;
    private String errorCode;
    private String timestamp;
    private List<Ticker> list;
}
