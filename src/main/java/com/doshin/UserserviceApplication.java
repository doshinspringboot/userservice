package com.doshin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.rich.InMemoryRichGaugeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@EnableDiscoveryClient
@SpringBootApplication
public class UserserviceApplication {
	
	@Bean
	@Primary
	public InMemoryRichGaugeRepository inMemoryRichGaugeRepository() {
		return new InMemoryRichGaugeRepository();
}
	


	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
}
