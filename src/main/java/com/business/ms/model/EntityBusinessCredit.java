package com.business.ms.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Document(collection = "BusinessCredit")
public class EntityBusinessCredit {
	@Id
	private String codCur;
	
	private String numCred;
	
	private Double cash;
	
	private Double cashPay;
	
	private CustomerEntity  customer;
	
	private List<EntityTransaction> transactions;

	private String status;
	
	private String bank; 
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@NotNull
	private Date dateOpen;
	
	public String getCodCur() {
		return codCur;
	}

	public void setCodCur(String codCur) {
		this.codCur = codCur;
	}

	public String getNumCred() {
		return numCred;
	}

	public void setNumCred(String numCred) {
		this.numCred = numCred;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public Double getCashPay() {
		return cashPay;
	}

	public void setCashPay(Double cashPay) {
		this.cashPay = cashPay;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<EntityTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<EntityTransaction> transactions) {
		this.transactions = transactions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}


	
}
