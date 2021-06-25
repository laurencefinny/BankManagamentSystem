package com.cts.bank.bankmanagementsystem.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.bank.bankmanagementsystem.model.Loan;

import reactor.core.publisher.Flux;
@Repository
public interface LoanRepository extends ReactiveCrudRepository<Loan, Integer>{
	@Query("select * from loan where customer_Id = ?customer_Id")
	Flux<Loan> findByCustId(int customerId);
}
