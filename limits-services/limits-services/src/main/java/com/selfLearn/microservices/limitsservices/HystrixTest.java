package com.selfLearn.microservices.limitsservices;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.selfLearn.microservices.limitsservices.beans.LimitConfiguration;

@Service
public class HystrixTest {
	
	 @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public LimitConfiguration test() {
		throw new RuntimeException("Not available");
	}

	 public LimitConfiguration fallbackRetrieveConfiguration() {
			return new LimitConfiguration(9, 999);
		}
}
