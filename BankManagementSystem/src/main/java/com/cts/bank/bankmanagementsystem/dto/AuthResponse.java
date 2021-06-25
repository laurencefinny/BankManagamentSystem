package com.cts.bank.bankmanagementsystem.dto;

public class AuthResponse {
	 private String token;
	 private String message;
	 

	public AuthResponse(String token,String message) {
		super();
		this.token = token;
		this.message = message;
	}

	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	 
}
