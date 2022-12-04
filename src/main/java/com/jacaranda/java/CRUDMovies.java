package com.jacaranda.java;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.java.Movies;
import com.jacaranda.java.Conn;

public class CRUDMovies {

	public static Movies getMovie(Integer id ) {
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		Movies movie = (Movies) session.get(Movies.class,id);
		return movie;
	}
	
	public static boolean saveMovie( Movies movie) {
		boolean resultado=false;
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(movie);
			session.getTransaction().commit();
			resultado=true;			
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return resultado;
	}
	
	
	public  static boolean  deleteMovie(Movies movie) {
		boolean resultado= false;
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		try {
			
			session.getTransaction().begin();
			session.delete(movie);
			session.getTransaction().commit();;
			resultado=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return resultado;
	}
	
	public static ArrayList<Movies> getMovies(){
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		Query<Movies> query = session.createQuery("SELECT p FROM com.jacaranda.java.Movies p");
		ArrayList<Movies> movie = (ArrayList<Movies>) query.getResultList();
		
		return movie;
	}
	
	public static List<Integer> MoviesMaxId() {
		
	    boolean valid = false;
	    Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		Query<Integer> query = session.createQuery("SELECT MAX(id) FROM com.jacaranda.java.Movies");
		List<Integer> Movies_maxID=query.getResultList();
		    
	
		return Movies_maxID;
	}
	
	public static Movies getMovieTitle(String title){
		
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
	
		Movies movies=null;
		try {
			Query<Movies> query = session.createQuery("SELECT p FROM com.jacaranda.java.Movies p WHERE title='"+ title +"'",Movies.class);
			movies = query.getSingleResult();
			return movies;
		}catch (Exception e) {
			return movies;
		}
		
	}
	

	public Movies getImgMovie(Integer id) {
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
	return session.get(Movies.class, id);
	}
}
