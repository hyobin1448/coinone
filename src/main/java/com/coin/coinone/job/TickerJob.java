package com.coin.coinone.job;

import com.coin.coinone.domain.Coin;
import com.coin.coinone.domain.Ticker;
import com.coin.coinone.domain.TickerList;
import com.coin.coinone.service.CoinService;
import com.google.gson.Gson;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
@Component
@EnableAsync
public class TickerJob {
    private ApplicationContext ctx;
    @Autowired
    private CoinService service;
    @Scheduled(cron = "* */2 * * * ?")
    @Async
    public void start() throws JobExecutionException{
//        List<Coin> list = service.searchCoinList();
        sendGet();
    }
    private void sendGet(){
        try {
            URL url = new URL("https://api.coinone.co.kr/ticker?currency=123");

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
            String response = sb.toString();
            Gson gson = new Gson();
            response= response.replaceAll("\"pha\"\\:\\{","\"list\"\\:\\[\\{");
            response = response.replaceAll("\"[a-zA-Z0-9]*\"\\:\\{","\\{");
            response = response.replaceAll("\\}\\}","\\}\\]\\}");
            TickerList list = gson.fromJson(response, TickerList.class);
            service.insertTicker(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sendPost(){
        try {
            URL url = new URL("https://api.coinone.co.kr/v2/order/limit_sell/");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestProperty("Content-Type","application/json;utf-8");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("X-COINONE-PAYLOAD","eyJhY2Nlc3NfdG9rZW4iOiAiMWI5YzkzOTktNjJmZi00ZDA5LWEwNjMtZGQ5NzA4OTNlNzA4Iiwibm9uY2UiOiAxNjE4Mjc5MDg3OTIwLCJwcmljZSI6ICIyMzUuMCIsInF0eSI6IDIyLjAsImN1cnJlbmN5IjogIk9SQlMiLCJpc19wb3N0X29ubHkiOmZhbHNlfQ==");
            conn.setRequestProperty("X-COINONE-SIGNATURE","409910c350689e017887a938c9502693ce870c9a190b0c18bc9341d7a17326995f431bb5facc3fbb74afb300d10266efcd43cee0066139816520c4f30c560796");
            String param = "{\"access_token\": \"1b9c9399-62ff-4d09-a063-dd970893e708\",\"nonce\": 1618279087920,\"price\": \"235.0\",\"qty\": 22.0,\"currency\": \"ORBS\",\"is_post_only\":false}";

            try(OutputStream os = conn.getOutputStream()){
                byte[] input = param.getBytes(StandardCharsets.UTF_8);
                os.write(input,0,input.length);
            }
            try(BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream(), "utf-8"))){
                StringBuilder response = new StringBuilder();
                String responeLine = null;
                while((responeLine=br.readLine())!=null){
                    response.append(responeLine.trim());
                }
                System.out.println(response.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
