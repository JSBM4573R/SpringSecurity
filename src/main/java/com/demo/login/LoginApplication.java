package com.demo.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan(basePackages = {"com.demo.login.Services"})
public class LoginApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
