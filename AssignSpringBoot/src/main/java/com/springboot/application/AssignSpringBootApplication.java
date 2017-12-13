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
@ComponentScan("com.springboot.*")
@PropertySources({
	@PropertySource("classpath:messages.properties"),
	@PropertySource("classpath:persistence.properties"),
	@PropertySource("classpath:log4j.properties")
})
@EnableCaching
public class AssignSpringBootApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AssignSpringBootApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(AssignSpringBootApplication.class, args);
	}
}
