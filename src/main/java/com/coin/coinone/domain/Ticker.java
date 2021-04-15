package com.coin.coinone.domain;


import lombok.Data;

@Data
public class Ticker {
    private String key;
    private String time;
    private String high;
    private String low;
    private String last;
    private String volume;
    private String first;
    private String currency;
    private String timestamp;

    public String getKey(){
        return this.currency;
    }
}
