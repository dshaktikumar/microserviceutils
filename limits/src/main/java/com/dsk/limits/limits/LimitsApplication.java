package com.dsk.limits.limits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LimitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsApplication.class, args);
	}

}
