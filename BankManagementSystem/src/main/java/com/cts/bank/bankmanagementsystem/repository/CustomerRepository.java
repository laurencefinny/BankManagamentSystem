package com.cts.bank.bankmanagementsystem.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.bank.bankmanagementsystem.model.Customer;
import reactor.core.publisher.Mono;


@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
	@Query("select * from cusromer where first_name = ?first_name")
	Mono<Customer> findByCustName(String fristName);
}
