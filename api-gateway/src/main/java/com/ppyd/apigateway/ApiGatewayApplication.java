package com.ppyd.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		System.err.println("SISAS");
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
