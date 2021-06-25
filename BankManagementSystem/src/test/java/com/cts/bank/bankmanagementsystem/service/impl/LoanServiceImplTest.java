package com.cts.bank.bankmanagementsystem.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.cts.bank.bankmanagementsystem.model.Loan;
import com.cts.bank.bankmanagementsystem.repository.LoanRepository;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoanServiceImplTest {

	@SpyBean
	LoanServiceImpl loanServiceImpl;

	@MockBean
	LoanRepository loanRepository;

	@Test
	void testApplyLoan() {
		Loan loan = new Loan();
		loan.setLoanId(3);
		Mockito.when(loanRepository.save(Mockito.any())).thenReturn(Mono.just(loan));
		loanServiceImpl.applyLoan(loan);
		StepVerifier.create(loanServiceImpl.applyLoan(loan)).expectNextCount(1).expectComplete().verify();
	}

}