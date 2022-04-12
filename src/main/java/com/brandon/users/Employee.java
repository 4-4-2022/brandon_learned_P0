package com.brandon.users;

public class Employee extends User{

public Employee(String firstName, String lastName, String userName, String password) {
		super(firstName, lastName, userName, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public static void main(String[] args) {
		
	}

	
}
