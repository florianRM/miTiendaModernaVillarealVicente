package com.jacaranda.java;

public class MovieCarrito {

	private Movies movie;
	private Integer cantidad;
	private Double precioTotal;
	
	public MovieCarrito() {
		
	}


	public MovieCarrito(Movies movie, Integer cantidad, Double precioTotal) {
		super();
		this.movie = movie;
		this.cantidad = cantidad;
		this.precioTotal=(movie.getPrice()*cantidad);
	}


	public Movies getMovie() {
		return movie;
	}


	public void setMovie(Movies movie) {
		this.movie = movie;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Double getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}


	@Override
	public String toString() {
		return "MovieCarrito [movie=" + movie + ", cantidad=" + cantidad + ", precioTotal=" + precioTotal + "]";
	}
	
	
	

}
