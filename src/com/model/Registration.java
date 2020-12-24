package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//This class is used for the registration model
@Entity
public class Registration {
	
	@Override
	public String toString() {
		return "Registration [uname=" + uname + ", email=" + email + ", city="
				+ city + "]";
	}
	@Id
	private String uname;
	private String email;
	private String city;
	public Registration(String uname, String email, String city) {
		super();
		this.uname = uname;
		this.email = email;
		this.city = city;
	}
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
