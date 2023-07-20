package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//If all components are not in same package or sub packages
//@SpringBootApplication(scanBasePackageClasses = {"",""})

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

}
