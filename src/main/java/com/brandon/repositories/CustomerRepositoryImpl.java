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
	
	private static final Customer Customer = null;

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
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}
		
		return customers;
	}

	@Override
	public Customer findCustomerByUserName(String UserName) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from customers where user_name = '" + UserName + "'";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL); //records retrieved
			while(set.next()) {
				Customer retrievedCustomer = new Customer(
						set.getString(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getDouble(5),
						set.getString(6),
						set.getBoolean(7)
					);
				return retrievedCustomer;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}
		return null;
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

	public void updateCustomerBottleCaps(Customer customer, double newBottleCapAmount) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "update customers set bottle_caps = '" + newBottleCapAmount + "' where user_name = '" + customer.getUserName() + "'";	

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			stmt.addBatch(SQL);
			stmt.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}		
	}
	
	
	public void createSecondaryCustomer(Customer primary, Customer secondary) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "update customers set secondary_account = '" + secondary.getUserName() + "' where user_name = '" + primary.getUserName() + "'";	
		final String SQL2 = "update customers set is_secondary_account = true where user_name = '" + secondary.getUserName() + "'";	

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			stmt.addBatch(SQL);
			stmt.addBatch(SQL2);
			stmt.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "delete from customers where user_name = '" + customer.getUserName() + "'";	

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			stmt.addBatch(SQL);
			stmt.executeBatch();
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

	public void donateBottleCapsToSecondary(Customer customer, double amount, double amount2) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "update customers set bottle_caps  = " + amount + " where user_name = '" + customer.getUserName() +  "'";
		final String SQL2 = "update customers set bottle_caps  = " + amount2 + " where user_name = '" + customer.getSecondaryAccount() +  "'";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			stmt.addBatch(SQL);
			stmt.addBatch(SQL2);
			stmt.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	
	}
	
	public void changeAccountDetails(Customer customer, String fieldToChange, String changeValue) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "update customers set " + fieldToChange + " = '" + changeValue + "' where user_name = '" + customer.getUserName() +  "'";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			stmt.addBatch(SQL);
			stmt.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	
	}
	
	public void removeSecondaryCustomer(Customer customer) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "delete from customers where user_name  = '" + customer.secondaryAccount +  "'";	
		final String SQL2 = "update customers set secondary_account = null where user_name = '" + customer.getUserName()+ "'";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			stmt.addBatch(SQL);
			stmt.addBatch(SQL2);
			stmt.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}		
	}

	@Override
	public void admimUpdateBottleCaps(Customer customer, double amount) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "update customers set bottle_caps = '" + amount + "' where user_name = '" + customer.getUserName() +  "'";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			stmt.addBatch(SQL);
			stmt.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}		
	}
		
}

