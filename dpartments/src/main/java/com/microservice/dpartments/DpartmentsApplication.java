package com.microservice.dpartments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DpartmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpartmentsApplication.class, args);
	}

}
