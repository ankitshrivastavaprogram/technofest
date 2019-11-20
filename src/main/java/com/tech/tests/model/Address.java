package com.tech.tests.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Address {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="address_line_first")
	private String addressLineFirst;
	
	@Column(name="address_line_second")
	private String addressLineSecond;
	
	@Column(name="address_line_third")
	private String addressLineThird;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String country, String state, String city, String pincode, String addressLineFirst,
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

	public Long getId() {
		return id;
	}
	
	

}
