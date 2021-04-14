package com.coin.coinone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.coin.coinone")
public class CoinoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinoneApplication.class, args);
	}

}



