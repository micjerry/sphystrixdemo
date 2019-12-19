package com.sculler.hystrixfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixFrontController {
	@Autowired
	HystrixRestDelegate delegate;
	
	@RequestMapping(value = "/hystrix/front", method = RequestMethod.GET)
	public String getBackendData() {
		return delegate.callBackendAndGetData();
	}
}
