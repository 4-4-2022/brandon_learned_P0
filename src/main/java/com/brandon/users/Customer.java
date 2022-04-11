package com.brandon.users;

public class Customer extends User {

	private short funds = 0;
	
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
		
	public static void main(String[] args) {

		Customer[] customers = {
				new Customer("Brandon", "Learned", "blearned92", "pw"), 
				new Customer("Alexa", "Learned", "alearned10", "awooooo")};
		
		int i = 1;
		for(Customer customer : customers) {
			System.out.println("Customer " + i + ": \n" + customer);
			i += 1;
		}
	}
	
	public void callCustomers() {
		
	}

	public short getFunds() {
		return funds;
	}

	public void setFunds(short funds) {
		this.funds = funds;
	}

	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nUsername: " + userName + "\nPassword: "
				+ password + "\nFunds: " + funds;
	}
		

	
	
}
