package com.service;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.dao.UserDao;
import com.model.Registration;
import com.utility.HibernateUtility;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

//This class is used as a user service for implementing UserDao
//This will use Hibernate to register the user
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

}