package com.foodhub.database.model;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

@Component
public class FullNameDetails {
	
	String userFullName;
	
	String userName;
	
	String password;
	
	String firstName;
	
	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	String lastName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return userFullName;
	}

	public void setFullName(String userFullName) {
		this.userFullName = userFullName;
	}
}
