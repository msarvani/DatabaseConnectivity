package com.foodhub.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdata")
public class Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "salt")
	private String salt;
	
	@Column(name = "password_value")
	private String password;
	
	@Column(name = "user_full_name")
	private String userFullName;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public Details() {
		super();
	}

	public Details(String userName, String salt, String password) {
		super();
		this.userName = userName;
		this.salt = salt;
		this.password = password;
	}
	
	public Details(String userName, String salt, String password, String userFullName) {
		super();
		this.userName = userName;
		this.salt = salt;
		this.password = password;
		this.userFullName = userFullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPasswordValue() {
		return password;
	}

	public void setPasswordValue(String passwordValue) {
		this.password = passwordValue;
	}
}
