package com.jacaranda.java;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CRUDCategory {
	
	public static Category getCategory(Integer id ) {
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		Category category = (Category) session.get(Category.class,id);
		return category;
	}


	public static ArrayList<Category> getCategory(){
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		Query<Category> query = session.createQuery("SELECT p FROM com.jacaranda.java.Category p");
		ArrayList<Category> category = (ArrayList<Category>) query.getResultList();
		
		return category;
	}
	
	
	
	

	

		
		
	
}
