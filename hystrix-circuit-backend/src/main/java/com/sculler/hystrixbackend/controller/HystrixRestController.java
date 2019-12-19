package com.sculler.hystrixbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixRestController {
	
	@RequestMapping(value = "/hystrix/test", method = RequestMethod.GET)
	public String hystrixTest() {
		return "{result:\"normal\"}";
	}

}
