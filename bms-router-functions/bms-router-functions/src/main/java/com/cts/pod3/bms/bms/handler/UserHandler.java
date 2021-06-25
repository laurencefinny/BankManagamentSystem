package com.cts.pod3.bms.bms.handler;



import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.pod3.bms.bms.model.Customer;
import com.cts.pod3.bms.bms.model.Loan;
import com.cts.pod3.bms.bms.repository.CustomerRepository;
import com.cts.pod3.bms.bms.repository.LoanRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class UserHandler {

    private CustomerRepository customerRepository;
    
    private LoanRepository loanRepository;

    public UserHandler(CustomerRepository customerRepository, LoanRepository loanRepository){
        this.customerRepository = customerRepository;
        this.loanRepository = loanRepository;
    }

    public Mono<ServerResponse> registerCustomer(ServerRequest request) {
        Mono<Customer> customerMono = request.bodyToMono(Customer.class).flatMap(user -> customerRepository.save(user));
        return ServerResponse.ok().body(customerMono, Customer.class);
    }

    public Mono<ServerResponse> customerList(ServerRequest request) {
        Flux<Customer> customer = customerRepository.findAll();
        return ServerResponse.ok().body(customer, Customer.class);
    }
    
    public Mono<ServerResponse> applyLoan(ServerRequest request) {
        Mono<Object> loanMono = request.bodyToMono(Loan.class).flatMap(loan -> loanRepository.save(loan));
        return ServerResponse.ok().body(loanMono, Loan.class);
    }
    
    

	
	
	/*
	 * public Mono<ServerResponse> getUserById(ServerRequest request) { String
	 * userId = request.pathVariable("userId"); Mono<ServerResponse> notFound =
	 * ServerResponse.notFound().build(); Mono<Customer> userMono =
	 * userRepository.findById(userId); return userMono .flatMap(user ->
	 * ServerResponse.ok().contentType(APPLICATION_JSON).body(BodyInserters.
	 * fromObject(user))) .switchIfEmpty(notFound); }
	 * 
	 * public Mono<ServerResponse> deleteUser(ServerRequest request) { String userId
	 * = request.pathVariable("userId"); userRepository.deleteById(userId); return
	 * ServerResponse.ok().build(); }
	 * 
	 * 
	 * public Mono<ServerResponse> streamEvents(ServerRequest serverRequest) {
	 * return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
	 * Flux.interval(Duration.ofSeconds(1)).map(val -> new UserEvent("" + val,
	 * "Devglan User Event")), UserEvent.class); }
	 */

}
