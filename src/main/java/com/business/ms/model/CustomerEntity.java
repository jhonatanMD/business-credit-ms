package com.business.ms.model;

import javax.validation.constraints.NotEmpty;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "CustomerEntity")
@JsonPropertyOrder({"CodCust","Busnam","Ruc","Addr","Num"})
public class CustomerEntity {

	@Id
	private String CodCust;
	
	@NotEmpty(message = "not empty")
	private String Busnam;
	@NotEmpty(message = "not empty")
	private String Ruc;
	@NotEmpty(message = "not empty")
	private String Addr;
	@NotEmpty(message = "not empty")
	private String Num;
	public String getCodCust() {
		return CodCust;
	}
	public void setCodCust(String codCust) {
		CodCust = codCust;
	}
	public String getBusnam() {
		return Busnam;
	}
	public void setBusnam(String busnam) {
		Busnam = busnam;
	}
	public String getRuc() {
		return Ruc;
	}
	public void setRuc(String ruc) {
		Ruc = ruc;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	
	
	
}
