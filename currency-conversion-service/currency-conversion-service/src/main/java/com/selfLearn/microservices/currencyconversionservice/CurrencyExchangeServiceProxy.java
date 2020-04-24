package com.selfLearn.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(name="currency-exchange-service" , url="localhost:8000") // when we use ribbon for client side load balancing we can not hardcode the url.
//@FeignClient(name="currency-exchange-service") - For Calling Zuul API need to call the Zuul API service name
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}") -calling comment for adding uri for calling exchange service using the zull api gateway
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConverterBean retriveExchangeValue(@PathVariable ("from") String from, @PathVariable ("to") String to);

}
