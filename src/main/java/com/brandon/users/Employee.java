package com.brandon.users;

public class Employee extends User{
	
	boolean isAdmin;

public Employee(String firstName, String lastName, String userName, String password, boolean isAdmin) {
		super(firstName, lastName, userName, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	@Override
	public String toString() {
		return "Admin: " + firstName + " " + lastName + "\nUsername: " + userName + "\nAdmin Status: "
				+ isAdmin;
	}
	
}
