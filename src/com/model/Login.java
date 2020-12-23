package com.model;

//This class is used for the login model
public class Login {
	
	private String uname;
	private String email;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String uname, String email) {
		super();
		this.uname = uname;
		this.email = email;
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

}
