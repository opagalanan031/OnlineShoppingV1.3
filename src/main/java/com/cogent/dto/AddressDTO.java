package com.cogent.dto;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-9:43:12 AM
 */
public class AddressDTO {
	private String houseNo;
	private String street;
	private String city;
	private String state;
	
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public AddressDTO() {
		super();
	}
	public AddressDTO(String houseNo, String street, String city, String state) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	@Override
	public String toString() {
		return houseNo + " " + street + ", " + city + ", " + state;
	}
	
}
