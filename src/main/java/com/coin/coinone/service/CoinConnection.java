package com.coin.coinone.service;

import com.coin.coinone.domain.Coin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CoinConnection {
    public String sendGetMessage(String urlStr) throws IOException{
            URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Accept","application/json");
        conn.setRequestMethod("GET");
        conn.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String jsonData;
        while ((jsonData = br.readLine()) != null) {
            sb.append(jsonData);
        }
        System.out.println(sb.toString());

        return null;
    }
    public String sendPostMessage(String url, Coin coin){
        return null;
    }
}
