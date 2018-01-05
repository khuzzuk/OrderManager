package net.usermd.cartdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
public class CartDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartDataApplication.class, args);
	}
}
