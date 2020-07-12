package com.dsk.loan.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.dsk.loan.proxy")
public class LoanSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanSystemApplication.class, args);
	}

}
