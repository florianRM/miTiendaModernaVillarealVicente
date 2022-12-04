package com.jacaranda.java;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List<MovieCarrito> listPurchase;

	public Carrito() {
		this.listPurchase = new ArrayList<>();
	}

	public Carrito(List<MovieCarrito> listPurchase) {
		super();
		this.listPurchase = new ArrayList<>();
	}

	public List<MovieCarrito> getListPurchase() {
		return listPurchase;
	}

	public void setListPurchase(List<MovieCarrito> listPurchase) {
		this.listPurchase = listPurchase;
	}

	public void addItem(MovieCarrito movie) throws Exception {

		if (movie == null) {
			throw new Exception("Pelicula nula");
		}

		if (this.listPurchase.isEmpty()) {
			this.listPurchase.add(movie);

		} else {

			boolean different = true;
			for (MovieCarrito item : this.listPurchase) {
				if (item.getMovie().getId() == (movie.getMovie().getId())) {
					different = false;
					item.setCantidad(movie.getCantidad());
					item.setPrecioTotal(movie.getPrecioTotal());
				

				}
			}

			if (different) {
				
				this.listPurchase.add(movie);
				

			}
		}
	}

	public boolean contieneMovie(Movies movie) {
		boolean contiene = false;
		for (MovieCarrito c : listPurchase) {
			if (c.getMovie().equals(movie)) {
				contiene = true;
			}
		}

		return contiene;
	}

	@Override
	public String toString() {
		return "Carrito [listPurchase=" + listPurchase + "]";
	}

}
