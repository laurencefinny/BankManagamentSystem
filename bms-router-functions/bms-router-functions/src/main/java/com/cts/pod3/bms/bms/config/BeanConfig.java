
package com.cts.pod3.bms.bms.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.pod3.bms.bms.handler.UserHandler;
import com.cts.pod3.bms.bms.repository.CustomerRepository;
import com.cts.pod3.bms.bms.repository.LoanRepository;



@Configuration
public class BeanConfig {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LoanRepository loanRepository;

	@Bean
	public RouterFunction<ServerResponse> route() {
		UserHandler userHandler = new UserHandler(customerRepository,loanRepository);
		return RouterFunctions.route(POST("/registerCustomer").and(contentType(APPLICATION_JSON)), userHandler::registerCustomer)
				.andRoute(GET("/getCustomerList").and(contentType(APPLICATION_JSON)),userHandler::customerList)
				.andRoute(POST("/applyLoan").and(contentType(APPLICATION_JSON)),userHandler::applyLoan);
	}

}
