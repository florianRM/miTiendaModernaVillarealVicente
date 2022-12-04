package com.jacaranda.java;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CRUDUser {

	
	public static User getUser(String name ) {
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		User user = (User) session.get(User.class,name);
		return user;
	}
	
	public static boolean saveUser( User user) {
		boolean resultado=false;
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
			resultado=true;			
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return resultado;
	}
	
	
	public  static boolean  deleteUser(User user) {
		boolean resultado= false;
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		try {
			
			session.getTransaction().begin();
			session.delete(user);
			session.getTransaction().commit();;
			resultado=true;
			
		} catch (Exception e) {
			e.printStackTrace();	
			session.getTransaction().rollback();
		}
		
		return resultado;
	}
	
	public static ArrayList<User> getUsers(){
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		Query<User> query = session.createQuery("SELECT p FROM com.jacaranda.java.User p");
		ArrayList<User> user = (ArrayList<User>) query.getResultList();
		
		return user;
	}
	
}
