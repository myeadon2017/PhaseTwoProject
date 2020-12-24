package com.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Login;
import com.model.Registration;

//This interface is used for my User Registration and Login functionality
public interface UserDao {
	
	public void registration(Registration reg);
	
	boolean login(Login log, HttpServletRequest request,
			HttpServletResponse response);

}
