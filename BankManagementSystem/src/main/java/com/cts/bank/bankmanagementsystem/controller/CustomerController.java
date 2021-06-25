package com.cts.bank.bankmanagementsystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bank.bankmanagementsystem.model.Customer;
import com.cts.bank.bankmanagementsystem.model.Loan;
import com.cts.bank.bankmanagementsystem.services.CustomerService;
import com.cts.bank.bankmanagementsystem.services.LoanService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/bms")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	LoanService loanService;

	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping("/createCustomer")
	public Mono<Object> createCustomer(@RequestBody Customer customer) {
		logger.info(this.getClass().getName());
		return customerService.registerCustomer(customer);
	}

	@PostMapping("/applyLoan")
	public Mono<Object> createLoan(@RequestBody Loan loan) {
		logger.info(this.getClass().getName());
		return loanService.applyLoan(loan);
	}

	@PutMapping("/{customerId}")
	public Mono<ResponseEntity<Customer>> getUserById(@PathVariable int customerId, @RequestBody Customer customer) {
		logger.info(this.getClass().getName());
		customer.setCustomerId(customerId);
		return customerService.updateCustomerDetails(customer);

	}

}
