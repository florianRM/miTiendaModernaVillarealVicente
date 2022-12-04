package com.jacaranda.java;

import java.time.LocalDateTime;
import java.util.Comparator;

public class ComparatorDateTime implements Comparator<Purchase> {

	public ComparatorDateTime() {
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public int compare(Purchase o1, Purchase o2) {
		
		return o2.getDate().compareTo(o1.getDate());
	}

}
