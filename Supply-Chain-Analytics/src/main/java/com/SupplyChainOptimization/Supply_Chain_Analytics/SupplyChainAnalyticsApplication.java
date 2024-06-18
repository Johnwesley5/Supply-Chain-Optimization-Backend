package com.SupplyChainOptimization.Supply_Chain_Analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SupplyChainAnalyticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyChainAnalyticsApplication.class, args);
	}

}
