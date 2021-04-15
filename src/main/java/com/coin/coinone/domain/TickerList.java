package com.coin.coinone.domain;


import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Data
public class TickerList {
    private String result;
    private String errorCode;
    private String timestamp;
    private List<Ticker> list;

    public String getTimestamp() {
        long timestamp = Long.parseLong(this.timestamp);
        Date date = new java.util.Date(timestamp*1000L);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);

        return  sdf.format(date);
    }
    public String getSecond(){
        long timestamp = Long.parseLong(this.timestamp);
        Date date = new java.util.Date(timestamp*1000L);

        SimpleDateFormat sdf = new SimpleDateFormat("s", Locale.KOREA);

        return sdf.format(date);
    }
}
