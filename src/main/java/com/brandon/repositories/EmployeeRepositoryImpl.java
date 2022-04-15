package com.brandon.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;  
import java.util.Set;

import com.brandon.users.Customer;
import com.brandon.users.Employee;
import com.brandon.util.ConnectionFactory;
import com.brandon.util.ResourceCloser;

public class EmployeeRepositoryImpl {
	
	private static final Employee Employee = null;

	private static EmployeeRepositoryImpl employeeRepository;
	
	private static Set <Employee> employees = new HashSet<Employee>(); //cant get rid of yet
	
	public EmployeeRepositoryImpl() {
	}
	
	public static synchronized EmployeeRepositoryImpl getEmployeeRepository() {
		if(employeeRepository == null) {
			employeeRepository = new EmployeeRepositoryImpl();
		}
		return employeeRepository;
	}
	

	public Set <Employee> returnAllEmployees() {
		return this.employees;
	}
	
	public Employee findEmployeeByUserName(String UserName) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from employees where user_name = '" + UserName + "'";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL); //records retrieved
			while(set.next()) {
				Employee retrievedEmployee = new Employee(
						set.getString(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getBoolean(5)
					);
				return retrievedEmployee;
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

}