package com.jacaranda.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Clase usuario.
 * @author vicente
 *
 */


@Entity (name = "users")
public class User {
	@Id
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private LocalDate date;
	private String gender;
	private Integer admin;
	
	
	public User(String username, String password, String first_name, String last_name, LocalDate date, String gender,
			Integer admin) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date = date;
		this.gender = gender;
		this.admin = admin;
		
	}

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer isAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}



	@Override
	public int hashCode() {
		return Objects.hash(admin, date, first_name, gender, last_name, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(admin, other.admin) && Objects.equals(date, other.date)
				&& Objects.equals(first_name, other.first_name) && Objects.equals(gender, other.gender)
				&& Objects.equals(last_name, other.last_name) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name="
				+ last_name + ", date=" + date + ", gender=" + gender + ", admin=" + admin + "]";
	}


	public Integer getAdmin() {
		return admin;
	}

	

}
