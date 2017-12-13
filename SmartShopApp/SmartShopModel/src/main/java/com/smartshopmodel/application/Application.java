package com.smartshopmodel.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@ComponentScan("com.smartshop.model")
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
