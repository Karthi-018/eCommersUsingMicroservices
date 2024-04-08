package com.example.discoveryserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerDemoApplication.class, args);
	}

}
