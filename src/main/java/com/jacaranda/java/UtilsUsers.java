package com.jacaranda.java;

import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Clase de control del usuario, contiene métodos utiles para el usuario.
 * -Obtiene un usuario concreto por el nombre.
 * -Obtiene todos los usuarios.
 * -Comprueba si es un usuario valido en nuestra base de datos
 * -Limpia los parámetros de la session actual.
 * @author vicente
 *
 */
public class UtilsUsers {

	// Obtiene un usuario en concreto partiendo del parametro name.
	public static User getUser(String name ) {
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
			
		User user = (User) session.get(User.class,name);
		return user;
		
	}
	
	// Obtiene una lista con los usuarios
	public static ArrayList<User> getUsers(){
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		
		Query<User> query = session.createQuery("SELECT p FROM com.jacaranda.java.User p");
		ArrayList<User> users = (ArrayList<User>) query.getResultList();
		
		return users;
	}
	
	  //Comprueba si el usuario es valido en nuestra base de datos.
	public static boolean userIsValid(String username, String password) {
		String passwordEncript= Md5encript.getMD5(password);
	    boolean valid = false;
	    Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		Query<User> query = session.createQuery("SELECT p FROM com.jacaranda.java.User p WHERE username='" + username + "'and password='"+passwordEncript+"'",User.class);
		if(!query.getResultList().isEmpty()) {
		    valid = true;
		
		}
		return valid;
	}
	
	/**
	 * Cerrar sesion. Limpia parametros  y atributos de la session actual.
	 */
	public static void closeSession () {	
		Conn conn = new Conn();
		conn.getSession();
		Session session= conn.getSession();
		 session.clear();
	}

}
