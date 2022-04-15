package com.brandon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brandon.repositories.CustomerRepositoryImpl;
import com.brandon.repositories.EmployeeRepository;
import com.brandon.repositories.EmployeeRepositoryImpl;
import com.brandon.users.Customer;
import com.brandon.users.Employee;

public class EmployeeService {
	
	private EmployeeRepositoryImpl employeeRepository;
	
	public EmployeeService() {
		this.employeeRepository = EmployeeRepositoryImpl.getEmployeeRepository();
	}

	public Employee findEmployeeByUserName(String input){
		return this.employeeRepository.findEmployeeByUserName(input);
	}


	
}
