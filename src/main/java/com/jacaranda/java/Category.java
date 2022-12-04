package com.jacaranda.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity (name="category")
public class Category {
	@Id
	private Integer id;
	private String genres;
	private String description_category;
	@OneToMany (mappedBy="category", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Movies> movies;
	
	public Category() {
		super();
	}

	public Category(Integer id, String genres, String description_category) {
		super();
		this.id = id;
		this.genres = genres;
		this.description_category = description_category;
		this.movies=new ArrayList<>();
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) throws CategoryException {
		if(genres==null) {
			throw new CategoryException("el nombre no puede ser nulo");
		}
		this.genres = genres;
	}

	public String getDescription_category() {
		return description_category;
	}

	public void setDescription_category(String description_category) throws CategoryException {
		if( description_category==null) {
			throw new CategoryException("La descripcion no puede ser nula");
		}
		
		this.description_category = description_category;
	}

	public List<Movies> getMovies() {
		return movies;
	}

	public void setMovies(List<Movies> movies) throws CategoryException {
		if(movies==null) {
			throw new CategoryException("La lista no puede ser nula");
		}
		
		this.movies = movies;
	}

	public boolean add(Movies e) {
		return movies.add(e);
	}

	public boolean remove(Movies o) {
		return movies.remove(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description_category, genres, id, movies);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(description_category, other.description_category) && Objects.equals(genres, other.genres)
				&& Objects.equals(id, other.id) && Objects.equals(movies, other.movies);
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", genres=" + genres + ", description_category=" + description_category
				+ ", movies=" + movies + "]";
	}
	
	
	
}

	