package com.brandon.repositories;

import java.util.HashSet; 
import java.util.Set;

import com.brandon.users.Customer;
import com.brandon.users.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository{

	private static Set <Employee> employees = new HashSet<Employee>(); //space for ten
		
	public EmployeeRepositoryImpl() {
		super();
		this.employees.add(new Employee("Percy", "Panther", "clawmachine", "prowler4", true));
		this.employees.add(new Employee("Iroh", "Seaton", "foodmaster", "meow1", false));
	}
	
	private Set <Employee> HashSet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set <Employee> returnAllEmployees() {
		return this.employees;
	}

	@Override
	public Set<Customer> returnAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByUserName(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeByUserName(String UserName) {
		for(Employee employee : employees) {
			if(employee.getUserName().equalsIgnoreCase(UserName)) {
				return employee;
			} 
		}
		return null;
	}


}
