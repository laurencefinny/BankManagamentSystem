package com.cts.bank.bankmanagementsystem.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.cts.bank.bankmanagementsystem.model.Customer;
import com.cts.bank.bankmanagementsystem.model.Loan;
import com.cts.bank.bankmanagementsystem.services.CustomerService;
import com.cts.bank.bankmanagementsystem.services.LoanService;
import com.google.gson.Gson;

import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

	@MockBean
	CustomerService customerService;

	@MockBean
	LoanService loanService;

	@Autowired
	WebTestClient webTestClient;

	@MockBean
	ResponseEntity<Customer> rescustomer;

	@Autowired
	Gson gson;

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(4);
		customer.setCustomerEmailAddress("xyz@com");
		Mockito.when(customerService.registerCustomer(Mockito.any())).thenReturn(Mono.just(customer));
		webTestClient.post().uri("/bms/createCustomer").bodyValue(customer).exchange().expectStatus().isCreated()
				.expectBody().jsonPath("$.customerId", 4);

	}

	@Test
	void testApplyLoan() {
		Loan loan = new Loan();
		loan.setLoanId(5);
		Mockito.when(loanService.applyLoan(Mockito.any())).thenReturn(Mono.just(loan));
		webTestClient.post().uri("/bms/applyLoan").bodyValue(loan).exchange().expectStatus().isCreated().expectBody()
				.jsonPath("$.customerId", 4);

	}

	@Test
	void testUpdateUserDetails() {
		Customer customer = new Customer();
		customer.setCustomerId(4);
		customer.setCustomerEmailAddress("xyz@com");

		Mockito.when(customerService.updateCustomerDetails(Mockito.any())).thenReturn(Mono.just(rescustomer));
		webTestClient.post().uri("/bms/4").bodyValue(customer).exchange().expectStatus().isCreated().expectBody()
				.jsonPath("$.customerId", 4);

	}
}