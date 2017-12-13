package com.webservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@ComponentScan("com.webservice.*")
@PropertySources({ @PropertySource("classpath:datasource.properties"), @PropertySource("classpath:log4j.properties") })
@EnableCaching
public class DemoWebserviceRestFullApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoWebserviceRestFullApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoWebserviceRestFullApplication.class, args);
	}
}
