package com.cts.pod3.bms.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableR2dbcRepositories(basePackages = ("com.cts.pod3.bms.bms.repository"))
public class BmsRouterFunctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsRouterFunctionsApplication.class, args);
	}

}
