package com.spring.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EntityScan("com.spring.flux.entity")
@EnableR2dbcRepositories("com.spring.flux.repository")
public class SpringBootWebfluxR2dbcCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxR2dbcCrudApplication.class, args);
	}

}
