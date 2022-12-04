package com.jacaranda.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Conn {
		private  StandardServiceRegistry sr;
		private  SessionFactory sf = null;
		private  Session session = null;
	
		public Conn() {
			sr = new StandardServiceRegistryBuilder().configure().build();
			sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
			session = sf.openSession();
		}

		public Session getSession() {
			return this.session;
		}
		
		
		}

