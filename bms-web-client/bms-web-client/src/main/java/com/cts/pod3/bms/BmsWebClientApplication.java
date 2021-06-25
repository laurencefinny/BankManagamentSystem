package com.cts.pod3.bms;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/bms-client")
public class BmsWebClientApplication {
	WebClient webClient;

	@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl("http://localhost:9041/")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
	}

	@PostMapping("/regiserCustomer")
	public Mono<String> registerCust(@RequestBody Customer request) {
		return webClient.post().uri("/registerCustomer").syncBody(request).retrieve().bodyToMono(String.class);
	}

	@GetMapping("/getCustomerList")
	public Flux<Customer> getCustDetails() {
		return webClient.get().uri("/getCustomerList").retrieve().bodyToFlux(Customer.class);
	}

	@PostMapping("/applyLoan")
	public Mono<String> applyLoanCust(@RequestBody Loan request) {
		return webClient.post().uri("/applyLoan").syncBody(request).retrieve().bodyToMono(String.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(BmsWebClientApplication.class, args);
	}

}
