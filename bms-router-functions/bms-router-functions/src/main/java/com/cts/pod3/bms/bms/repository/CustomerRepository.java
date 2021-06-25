package com.cts.pod3.bms.bms.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.pod3.bms.bms.model.Customer;




public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {

}
