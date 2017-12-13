package com.webservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.webservice.*")
@EnableCaching
public class DemoWebserviceRestFull1Application extends SpringBootServletInitializer{

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoWebserviceRestFull1Application.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoWebserviceRestFull1Application.class, args);
	}
}
