/*package com.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "insert into emp(empname,email,city) values(?,?,?)";
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			System.out.println(name + " " + email + " " + city);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, city);
			int i = pst.executeUpdate();
			if(i > 0) {
				response.getWriter().println("User is registered");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace(); 
		} //finally {
			//try {
				//conn.close();
				//System.out.println("Connection is closed.");
			//} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
			//System.out.println("Finally block called");
		//}
	}
}*/
package com.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;

//This servlet handles the user registration
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService= new UserService();
		System.out.println("inside servlet");
		
		com.model.Registration reg= new com.model.Registration(request.getParameter("uname"),request.getParameter("email"),request.getParameter("city"));
		
		userService.registration(reg);
		
		String name= request.getParameter("uname");
		HttpSession session= request.getSession();
		
		session.setAttribute("sesname", name);
		response.sendRedirect("registersuccess.jsp");
	}
	

	
}