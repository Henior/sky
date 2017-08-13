package com.example.mzp.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProviderUserApplication.class, args);
	}
}
