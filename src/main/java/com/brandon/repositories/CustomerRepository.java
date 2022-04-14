package com.brandon.repositories;


import java.util.Set; 

import com.brandon.users.Customer;


public interface CustomerRepository { //This class just serves as a fake Database
	
	public Set<Customer> returnAllCustomers();
	public Customer findCustomerByUserName(String UserName);
	public void createNewCustomer(Customer customer);
	public void updateCustomerRecord(Customer customer);
	public void deleteCustomer(Customer customer);

		
	
}