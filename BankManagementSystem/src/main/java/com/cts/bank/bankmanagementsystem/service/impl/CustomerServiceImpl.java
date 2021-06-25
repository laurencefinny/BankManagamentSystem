package com.cts.bank.bankmanagementsystem.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.bank.bankmanagementsystem.model.Customer;
import com.cts.bank.bankmanagementsystem.repository.CustomerRepository;
import com.cts.bank.bankmanagementsystem.services.CustomerService;

import reactor.core.publisher.Mono;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	
	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public Mono<Object> registerCustomer(Customer customer) {
		logger.info(this.getClass().getName());
		customer.setCustomerPassword(passwordEncoder().encode(customer.getCustomerPassword()));
		return customerRepository.save(customer) .map(savedCustomer ->
		 ResponseEntity.ok(savedCustomer.getCustomerId()));
	}

	@Override
	public Mono<ResponseEntity<Customer>> updateCustomerDetails(Customer customer) {
		logger.info(this.getClass().getName());
		 return customerRepository.findById(customer.getCustomerId()).flatMap(cust -> {
			cust.setCustomerAddress(customer.getCustomerAddress());
			cust.setCustomerContactNo(customer.getCustomerContactNo());
			cust.setCustomerEmailAddress(customer.getCustomerEmailAddress());
			cust.setCustomerPassword(passwordEncoder().encode(customer.getCustomerPassword()));
			cust.setCustomerStreet(customer.getCustomerStreet());
			return customerRepository.save(cust);
			
		}).map(updatedCustomer -> ResponseEntity.ok(updatedCustomer))
				.defaultIfEmpty(ResponseEntity.badRequest().build());
	}
	
	private PasswordEncoder passwordEncoder() {
		logger.info(this.getClass().getName());
		return new BCryptPasswordEncoder();
	}
}
