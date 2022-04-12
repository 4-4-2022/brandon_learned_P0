package com.brandon.repositories;

import java.util.HashSet; 
import java.util.Set;

import com.brandon.users.Customer;

public class CustomerRepositoryImpl implements CustomerRepository{
	
	private static Set <Customer> customers = new HashSet<Customer>(); //space for ten
	
	public CustomerRepositoryImpl() {
		super();
		this.customers.add(new Customer("Brandon", "Learned", "blearned92", "pw"));
		this.customers.add(new Customer("Alexa", "Learned", "alearned10", "awooooo"));	
	}
	
	private Set <Customer> HashSet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set <Customer> returnAllCustomers() {
		return this.customers;
	}

	public Customer findCustomerByUserName(String UserName) {
		for(Customer customer : customers) {
			if(customer.getUserName().equalsIgnoreCase(UserName)) {
				return customer;
			} 
		}
		return null;
	}

	public static void addCustomer(String firstName, String lastName, String userName, String password) {
		customers.add(new Customer(firstName, lastName, userName, password));		
	}
	
	//public static void main(String[] args) {
	//
	//
	//Scanner input = new Scanner(System.in);
	//
	//
	//Customer customer = new Customer("Brandon", "blearned92", "pwd"); 
	//Customer customer2 = new Customer("Brandon", "blearned92", "pwd"); 
	//
	//
	//Set<Customer> set = new HashSet<Customer>();
	//	
	//
	//set.add(customer);
	//set.add(customer2);
	//
	//Iterator<Customer> iterator = set.iterator();
	//while(iterator.hasNext()) {
	//	Customer next = iterator.next();
	//	System.out.println(next);
	//}
	
	
	
	
	//}
	//
	//public static void addCustomer(String custName, String custUserName, String custPassword) {
	//Customer customer = new Customer(custName, custUserName, custPassword); 
	//Set<Customer> set = null;
	//set.add(customer);			
	//}
		
}
