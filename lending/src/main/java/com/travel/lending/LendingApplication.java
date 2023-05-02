package com.travel.lending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LendingApplication.class, args);
	}

}
