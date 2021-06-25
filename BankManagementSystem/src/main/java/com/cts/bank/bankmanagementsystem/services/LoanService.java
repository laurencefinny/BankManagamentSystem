package com.cts.bank.bankmanagementsystem.services;

import com.cts.bank.bankmanagementsystem.model.Loan;

import reactor.core.publisher.Mono;


public interface LoanService {
	public Mono<Object> applyLoan(Loan loan);
}
