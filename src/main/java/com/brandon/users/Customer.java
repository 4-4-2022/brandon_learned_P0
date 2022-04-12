package com.brandon.users;

public class Customer extends User {

	private double bottleCaps = 0;
	String secondaryAccount = null;
	boolean isSecondaryAccount = false;
	
	/*
	 * This is an overload of our constructor that uses the class's fields.
	 */
	public Customer(String firstName, String lastName, String userName, String password) { 
		super(firstName, lastName, userName, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	
	public String getSecondaryAccount() {
		return secondaryAccount;
	}


	public void setSecondaryAccount(String secondaryAccount) {
		this.secondaryAccount = secondaryAccount;
	}


	public boolean isSecondaryAccount() {
		return isSecondaryAccount;
	}


	public void setSecondaryAccount(boolean isSecondaryAccount) {
		this.isSecondaryAccount = isSecondaryAccount;
	}


	public double getBottleCaps() {
		return bottleCaps;
	}

	public void setBottleCaps(double d) {
		this.bottleCaps = d;
	}

	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nUsername: " + userName + "\nPassword: "
				+ password + "\nBottle Caps: " + bottleCaps + "\nSecondary Account: " + secondaryAccount
				+ "\nSecondary Account Status: " + isSecondaryAccount + "\n " ;
	}
		

	
	
}
