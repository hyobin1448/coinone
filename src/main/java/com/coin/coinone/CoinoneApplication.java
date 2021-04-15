package com.coin.coinone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.coin.coinone")
@EnableScheduling
public class CoinoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinoneApplication.class, args);
	}

}



