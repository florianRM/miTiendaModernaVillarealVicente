package com.jacaranda.java;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CRUDPurchase {

	public CRUDPurchase() {
		

}
	public static boolean savePurchase(Purchase purchase) {
		boolean resultado=false;
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(purchase);		
			session.getTransaction().commit();
			resultado=true;			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			session.getTransaction().rollback();
		}
		return resultado;
	}
	
	public static ArrayList<Purchase> getListPurchase(String user) {
	   
	    Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		Query<Purchase> query = session.createQuery("SELECT p FROM com.jacaranda.java.Purchase p WHERE user='" + user+"'",Purchase.class);
		ArrayList<Purchase> purchase = (ArrayList<Purchase>) query.getResultList();
		return purchase;
	}
	public static void restarCantidad(Purchase p) {
		p.getId_movie().setStock(p.getId_movie().getStock()-p.getQuantity());
		
	}
}

