package com.cts.bank.bankmanagementsystem.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.cts.bank.bankmanagementsystem.model.Customer;
import com.cts.bank.bankmanagementsystem.repository.CustomerRepository;
import com.cts.bank.bankmanagementsystem.service.impl.CustomerServiceImpl;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerServiceImplTest {

	@MockBean
	CustomerRepository customerRepository;

	@SpyBean
	CustomerServiceImpl customerServiceImpl;

	@Test
	void testRegisterCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(4);
		customer.setCustomerPassword("abc@1234");
		customer.setCustomerEmailAddress("abc@gmail.com");
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(Mono.just(customer));
		customerServiceImpl.registerCustomer(customer);
		StepVerifier.create(customerServiceImpl.registerCustomer(customer)).expectNextCount(1).expectComplete()
				.verify();
	}

	@Test
	void testUpdateCustomerDetails() {
		Customer customer = new Customer();
		customer.setCustomerId(4);
		customer.setCustomerPassword("abc@1234");
		customer.setCustomerEmailAddress("abc@gmail.com");
		Mockito.when(customerRepository.findById(4)).thenReturn(Mono.just(customer));
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(Mono.just(customer));
		customerServiceImpl.updateCustomerDetails(customer);
		StepVerifier.create(customerServiceImpl.updateCustomerDetails(customer)).expectNextCount(1).expectComplete()
				.verify();
	}

}
