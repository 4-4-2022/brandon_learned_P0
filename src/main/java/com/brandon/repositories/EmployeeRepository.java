package com.brandon.repositories;

import java.util.Set;

import com.brandon.users.Customer;
import com.brandon.users.Employee;

public interface EmployeeRepository {
		
	public Set<Customer> returnAllCustomers();
	public Set<Employee> returnAllEmployees();
	public Customer findCustomerByUserName(String UserName);
	public Employee findEmployeeByUserName(String UserName);


}
