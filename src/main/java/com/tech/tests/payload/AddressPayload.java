package com.tech.tests.payload;

public class AddressPayload {
	
	private String country;
	private String state;
	private String city;
	private String pincode;
	private String addressLineFirst;
	private String addressLineSecond;
	private String addressLineThird;
	
	public AddressPayload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressPayload(String country, String state, String city, String pincode, String addressLineFirst,
			String addressLineSecond, String addressLineThird) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.addressLineFirst = addressLineFirst;
		this.addressLineSecond = addressLineSecond;
		this.addressLineThird = addressLineThird;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddressLineFirst() {
		return addressLineFirst;
	}

	public void setAddressLineFirst(String addressLineFirst) {
		this.addressLineFirst = addressLineFirst;
	}

	public String getAddressLineSecond() {
		return addressLineSecond;
	}

	public void setAddressLineSecond(String addressLineSecond) {
		this.addressLineSecond = addressLineSecond;
	}

	public String getAddressLineThird() {
		return addressLineThird;
	}

	public void setAddressLineThird(String addressLineThird) {
		this.addressLineThird = addressLineThird;
	}
	
	
	
	

}
