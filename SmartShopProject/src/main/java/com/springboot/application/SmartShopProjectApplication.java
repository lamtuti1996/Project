package com.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableCaching
@ComponentScan("com.springboot.*")
@PropertySources({ @PropertySource("classpath:persistence.properties"), @PropertySource("classpath:log4j.properties") })
public class SmartShopProjectApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SmartShopProjectApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SmartShopProjectApplication.class, args);
	}
}
