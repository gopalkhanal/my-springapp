package com.springboot.rest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.springboot.rest.CustomerRest;
import com.springboot.rest.HelloWorldRest;

@Configuration
public class SampleRestConfig extends ResourceConfig {

	public SampleRestConfig() {
		register(HelloWorldRest.class);
		register(CustomerRest.class);
	}

}
