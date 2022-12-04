package com.jacaranda.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.sql.Blob;

@Entity (name="movies")
public class Movies {
	@Id
	private Integer id;
	private String title;
	private String description_movie;
	private Double price;
	private Blob img;
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	
	

	public Movies() {
		super();
	}

	public Movies(Integer id, String title, String description_movie, Double price, Category category, Integer stock) {
		super();
		this.id = id;
		this.title = title;
		this.description_movie = description_movie;
		this.price = price;
		this.stock=stock;
		this.category = category;
		
	}
	public Movies(String title, String description_movie, Double price, Category category) {
		super();
		this.title = title;
		this.description_movie = description_movie;
		this.price = price;
		this.category = category;
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws MovieException {
		if(title ==null) {
			throw new MovieException("El titulo no puede ser nulo");
			
		}
		this.title = title;
	}

	public String getDescription_movie() {
		return description_movie;
	}

	public void setDescription_movie(String description_movie) throws MovieException {
		if(description_movie==null) {
			throw new MovieException("La descripcion no puede estar nula");
		}
		this.description_movie = description_movie;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) throws MovieException {
		if(price==null) {
			throw new MovieException("El precio no puede ser nulo");
		}
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	




	@Override
	public int hashCode() {
		return Objects.hash(category, description_movie, id, img, price, stock, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		return Objects.equals(category, other.category) && Objects.equals(description_movie, other.description_movie)
				&& Objects.equals(id, other.id) && Objects.equals(img, other.img) && Objects.equals(price, other.price)
				&& Objects.equals(stock, other.stock) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", description_movie=" + description_movie + ", price=" + price
				+ ", category=" + category + "]";
	}


	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}
	
	
	
}
	
	