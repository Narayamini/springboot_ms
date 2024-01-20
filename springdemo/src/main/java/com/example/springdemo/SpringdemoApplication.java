package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//If all components are not in same package or sub packages
//@SpringBootApplication(scanBasePackageClasses = {"",""})

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args); }}

// Bootstraps our springboot application and we give reference to actual name of our class ->
// Behind the scenes it creates app context and register all beans and starts the embedded server tomcat
