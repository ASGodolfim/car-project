package com.car.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.car.controller")
public class CarProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarProjectApplication.class, args);
	}

}

