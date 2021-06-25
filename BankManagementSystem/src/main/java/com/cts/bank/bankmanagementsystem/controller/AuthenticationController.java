package com.cts.bank.bankmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bank.bankmanagementsystem.dto.AuthRequest;
import com.cts.bank.bankmanagementsystem.dto.AuthResponse;
import com.cts.bank.bankmanagementsystem.repository.CustomerRepository;
import com.cts.bank.bankmanagementsystem.security.JWTUtil;

import reactor.core.publisher.Mono;

@RestController
public class AuthenticationController {

	private JWTUtil jwtUtil;

	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/login")
	public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest ar) {
		return customerRepository.findById(ar.getCustId())
				.filter(userDetails -> passwordEncoder().matches(ar.getPassword(), userDetails.getCustomerPassword()))
				.map(userDetails -> ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails),"Login Succesfull")))
				.switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
	}
	 
	
	public AuthenticationController(JWTUtil jwtUtil, CustomerRepository customerRepository) {
		super();
		this.jwtUtil = jwtUtil;
		this.customerRepository = customerRepository;
	}

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	

}