package com.brandon.repositories;

import com.brandon.users.Employee;

public interface EmployeeRepository {
		
	public Employee findEmployeeByUserName(String UserName);


}
