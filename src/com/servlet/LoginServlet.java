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

import com.service.UserService;

//This servlet will be used to log the user in
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String searchname= request.getParameter("uname");
		String searchemail= request.getParameter("email");
		
		//This query will be used to get the users info from the H2
		String sql = "select empname, email from emp";
		try{
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			boolean userFound = false;
			
			while(rs.next()){
				String name = rs.getString(1);
				String email = rs.getString(2);
				
				//This function will compare the two user inputs
				//to validate the users login
				if(searchname.equals(name) && searchemail.equals(email)){
					response.getWriter().println("Login Successful");
					userFound = true;
					
					HttpSession session= request.getSession();
					
					session.setAttribute("sesname", name);
					
					response.sendRedirect("loginsuccess.jsp");
					
					
					break;
				}
			}
			//This handles if the user enters invalid input
			//message will be displayed at the console
			if(!userFound){
				response.getWriter().println("Username and email do not match");
				
			}
		}catch(Exception e){
		
		
		
		
		}
		

	}
}
