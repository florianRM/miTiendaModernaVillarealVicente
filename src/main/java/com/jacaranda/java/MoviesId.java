package com.jacaranda.java;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class MoviesId  implements Serializable{

	private String user;
	private int id_movie;
	private LocalDateTime date;

	
	public MoviesId() {
	}
	
	

	public MoviesId(String user, int id_movie, LocalDateTime date) {
		super();
		this.user = user;
		this.id_movie = id_movie;
		this.date = date;
	}



	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getId_movie() {
		return id_movie;
	}

	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_movie, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoviesId other = (MoviesId) obj;
		return id_movie == other.id_movie && Objects.equals(user, other.user);
	}




	
}