package com.selfLearn.microservices.limitsservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;

import com.selfLearn.microservices.limitsservices.beans.LimitConfiguration;
//http://www.appsdeveloperblog.com/reading-application-properties-spring-boot/ -ways of reading properties file
@RestController
public class LimitConfigurationController {
	
	@Autowired
	private HystrixTest hystrixTest;
	
	//One way to read the value from the properties file using the @Value
	//@Value("${limits-services.min}")
	//private int min;
	
	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	
	public LimitConfiguration retriveLimitFromConfiguration() {
		return new LimitConfiguration(configuration.getMin(),configuration.getMax());
		
	}
	
	
	@GetMapping("/fault-tolerence-example")
	public LimitConfiguration retrieveConfiguration() {
		LimitConfiguration limitConfiguration = hystrixTest.test();
		return limitConfiguration;
	}
	
	
	
}
