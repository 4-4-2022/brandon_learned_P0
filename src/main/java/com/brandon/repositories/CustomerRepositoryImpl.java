package com.brandon.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;  
import java.util.Set;

import com.brandon.users.Customer;
import com.brandon.util.ConnectionFactory;
import com.brandon.util.ResourceCloser;

public class CustomerRepositoryImpl implements CustomerRepository{
	
	private static CustomerRepositoryImpl customerRepository;
	
	private static Set <Customer> customers = new HashSet<Customer>(); //cant get rid of yet
	
	public CustomerRepositoryImpl() {
	}
	
	public static synchronized CustomerRepositoryImpl getCustomerRepository() {
		if(customerRepository == null) {
			customerRepository = new CustomerRepositoryImpl();
		}
		return customerRepository;
	}

	public Set <Customer> returnAllCustomers() {
		Set<Customer> customers = new HashSet<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from customers";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL); //records retrieved
			while(set.next()) {
				customers.add(new Customer(
						set.getString(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getDouble(5),
						set.getString(6),
						set.getBoolean(7)
					));
				}
			for(Customer customer : customers) {
				System.out.println(customer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}
		
		return customers;
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

	@Override
	public void createNewCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into customers values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setString(3, customer.getUserName());
			stmt.setString(4, customer.getPassword());
			stmt.setDouble(5, customer.getBottleCaps());
			stmt.setString(6, customer.getSecondaryAccount());
			stmt.setBoolean(7, customer.isSecondaryAccount());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
		
	}

	@Override
	public void updateCustomerRecord(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}
}
