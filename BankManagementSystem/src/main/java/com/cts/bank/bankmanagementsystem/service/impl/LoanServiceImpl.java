package com.cts.bank.bankmanagementsystem.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.bank.bankmanagementsystem.model.Loan;
import com.cts.bank.bankmanagementsystem.repository.LoanRepository;
import com.cts.bank.bankmanagementsystem.services.LoanService;

import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	LoanRepository loanRepository;
	
	private final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

	@Override
	public Mono<Object> applyLoan(Loan loan) {
		logger.info(this.getClass().getName());
		return loanRepository.save(loan).map(savedLoanDetails ->
 		  ResponseEntity.ok(savedLoanDetails.getLoanId()));
	}
}
