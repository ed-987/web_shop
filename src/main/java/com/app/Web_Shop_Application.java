package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class Web_Shop_Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Web_Shop_Application.class, args);
	}

}
