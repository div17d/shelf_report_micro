package com.capgemini.go.shelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShelfTimeReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShelfTimeReportApplication.class, args);
	}

}
