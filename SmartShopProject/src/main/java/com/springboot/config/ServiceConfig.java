package com.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.springboot.service" }) // chỉ dùng để quét service
public class ServiceConfig {

}
