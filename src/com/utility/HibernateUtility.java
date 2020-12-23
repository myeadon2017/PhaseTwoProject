package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;

//This class is the HibernateUtility used to host the session factory
public class HibernateUtility {

	
	private static SessionFactory sf;
	
	static{
		sf= new AnnotationConfiguration().configure().buildSessionFactory();
		
	}
	public static Session getSession(){
		
		Session session= sf.openSession();
		return session;
	}
}
