package com.cts.bank.bankmanagementsystem.dto;

public class AuthRequest {
	 private int custId;
	    private String password;
		public int getCustId() {
			return custId;
		}
		public void setCustId(int custId) {
			this.custId = custId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public AuthRequest(int custId, String password) {
			super();
			this.custId = custId;
			this.password = password;
		}
		public AuthRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
