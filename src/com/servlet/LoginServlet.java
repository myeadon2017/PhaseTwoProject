package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Login;
import com.service.UserService;

//This servlet will be used to log the user in
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService userService= new UserService();
		System.out.println("inside servlet");
		Login log = new Login(request.getParameter("uname"), request.getParameter("email"));
		
		//This boolean "res" will hold the login validation result
		boolean res = userService.login(log,request,response);
		String name= request.getParameter("uname");
		HttpSession session= request.getSession();
		session.setAttribute("sesname", name);
		response.sendRedirect("loginsuccess.jsp");
}
}
