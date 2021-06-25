package com.cts.pod3.bms.bms.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.pod3.bms.bms.model.Loan;

import reactor.core.publisher.Flux;

public interface LoanRepository extends ReactiveCrudRepository<Loan, Integer>{
	@Query("select * from loan where customer_Id = ?customer_Id")
	Flux<Loan> findByCustId(int customerId);
}
