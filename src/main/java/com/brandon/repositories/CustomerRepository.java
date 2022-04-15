package com.brandon.repositories;


import java.util.Set; 

import com.brandon.users.Customer;


public interface CustomerRepository { //This class just serves as a fake Database
	
	public Set<Customer> returnAllCustomers();
	public Customer findCustomerByUserName(String UserName);
	public void createNewCustomer(Customer customer);
	public void updateCustomerBottleCaps(Customer customer, double newBottleCapAmount);
	public void donateBottleCapsToSecondary(Customer customer, double amount, double amount2);
	public void updateCustomerRecord(Customer customer);
	public void deleteCustomer(Customer customer);
	public void createSecondaryCustomer(Customer primary, Customer secondary);
	public void changeAccountDetails(Customer customer, String fieldToChange, String changeValue);
	public void admimUpdateBottleCaps(Customer customer, double amount);
	public void removeSecondaryCustomer(Customer customer);
	
}