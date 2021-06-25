package com.cts.bank.bankmanagementsystem.model;



import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Loan {
	@Id
	private int loanId;
	private String loanType;
	private double loanAmount;
	private LocalDate loanDate;
	private double loanRoi;
	private double loanDuration;
	private int customerId;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public LocalDate getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}
	public double getLoanRoi() {
		return loanRoi;
	}
	public void setLoanRoi(double loanRoi) {
		this.loanRoi = loanRoi;
	}
	public double getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(double loanDuration) {
		this.loanDuration = loanDuration;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
