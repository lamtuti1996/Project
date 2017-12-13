package com.smartshopmodel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.smartshopmodel.service" }) // chỉ dùng để quét service
public class ServiceConfig {

}
