package com.selfLearn.microservices.limitsservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableCircuitBreaker
public class LimitsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServicesApplication.class, args);
	}

}
