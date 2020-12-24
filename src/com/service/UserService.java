package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.dao.UserDao;
import com.model.Login;
import com.model.Registration;
import com.utility.HibernateUtility;

//This class is used as a user service for implementing UserDao
//This will use Hibernate to register the user and log them in
public class UserService implements UserDao{


	@Override
	public void registration(Registration reg) {
		System.out.println("inside service");

		try {
			
			Session session= HibernateUtility.getSession();
			Transaction tx= session.beginTransaction();
			
			session.save(reg);
			tx.commit();

			System.out.println(("user is registered"));
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public boolean login(Login log, HttpServletRequest request,
			HttpServletResponse response) {
		
		System.out.println("inside login service");
		String uname = log.getUname();
		String email = log.getEmail();
		Session session = HibernateUtility.getSession();
		
		//This query will retrieve the user who matches the
		//login validation and add them into a list
		//This is where validation occurs
		Query query = session.createQuery("from Registration where uname=:uname");
		query.setString("uname", uname);
		List<Registration> rl = query.list();
		for (Registration r : rl) {
			System.out.println(r);
			if (r.getEmail().equals(email) && r.getUname().equals(uname)) {
				System.out.println("user found!");
				return true;
			}
		}
			
		
		return false;
	}

}