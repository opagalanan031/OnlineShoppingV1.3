package com.cogent.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.util.Date;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-9:42:18 AM
 */
public class CustomerDTO {
	private int customerId;
	private String customerName;
	private String email;
	private String password;
	private LocalDate dob;
	private String gender;
	private AddressDTO adto;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public AddressDTO getAdto() {
		return adto;
	}
	public void setAdto(AddressDTO adto) {
		this.adto = adto;
	}
	public CustomerDTO() {
		super();
	}
	public CustomerDTO(int customerId, String customerName, String email, String password, LocalDate dob, String gender,
			AddressDTO adto) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.adto = adto;
	}
	
	@Override
	public String toString() {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return "\n" + customerId + " : " + customerName + " : " + dob + " : " + gender + " : " + email + 
				" : " + getAdto() + "\n";
	}
	
}
