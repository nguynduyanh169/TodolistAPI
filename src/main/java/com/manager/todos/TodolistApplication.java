package com.manager.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
@EnableJpaRepositories("com.manager.repository")
@ComponentScan(basePackages = "com.manager.controller")
@ComponentScan(basePackages = "com.manager.ApartmentManager")
@ComponentScan(basePackages = "com.manager.security")
@EntityScan("com.manager.entity")
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
