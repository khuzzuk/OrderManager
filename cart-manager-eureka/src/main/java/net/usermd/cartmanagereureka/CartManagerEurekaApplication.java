package net.usermd.cartmanagereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CartManagerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartManagerEurekaApplication.class, args);
	}
}
