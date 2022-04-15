package com.brandon.users;

public abstract class User {
	
	//instance field. Has-a relationships
	public String firstName;
	public String lastName;
	public String userName;
	public String password;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	//Add User methods here
	
	public String getUserName() {
		return userName;
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nUsername: " + userName + "\nPassword: "
				+ password;
	}




}
