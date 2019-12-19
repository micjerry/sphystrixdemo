package com.sculler.hystrixfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixRestDelegate {
	@Autowired
    RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callBackendAndGetData_Fallback")
	public String callBackendAndGetData() {
		String response = restTemplate
                .exchange("http://localhost:8090/hystrix/test"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
            }).getBody();
		
		return response;
	}
	
	@SuppressWarnings("unused")
	private String callBackendAndGetData_Fallback() {
		return "{result:\"BREAKER ENABLED\"}";
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
