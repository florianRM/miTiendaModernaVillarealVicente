package com.jacaranda.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(MoviesId.class)
@Table(name="purchase")
public class Purchase {
	
	private Double price;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="user",
	insertable = false, updatable = false)
	private User user;
	
	@Id
	private LocalDateTime date;
	private Integer quantity;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_movie",
			insertable = false, updatable = false)
	private Movies id_movie;

	public Purchase() {
		super();
	}

	public Purchase(Double price, User user, LocalDateTime date, Integer quantity, Movies id_movie) {
		super();
		
		this.price = Math.round(price*100.0)/100.0;
		this.user = user;
		this.date = date;
		this.quantity = quantity;
		this.id_movie = id_movie;
	}

	

	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getDate() {
		
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Movies getId_movie() {
		return id_movie;
	}

	public void setId_movie(Movies id_movie) {
		this.id_movie = id_movie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id_movie, price, quantity, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		return Objects.equals(date, other.date) && Objects.equals(id_movie, other.id_movie)
				&& Objects.equals(price, other.price) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Purchase [price=" + price + ", user=" + user + ", date=" + date + ", quantity=" + quantity
				+ ", id_movie=" + id_movie + "]";
	}



	
	
	
}
