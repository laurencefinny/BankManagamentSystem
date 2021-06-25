package com.cts.bank.bankmanagementsystem.services;


import org.springframework.http.ResponseEntity;

import com.cts.bank.bankmanagementsystem.model.Customer;

import reactor.core.publisher.Mono;

public interface CustomerService {
	public Mono<Object> registerCustomer(Customer customer);

	public Mono<ResponseEntity<Customer>> updateCustomerDetails(Customer customer);
}
