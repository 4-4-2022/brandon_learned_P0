package com.brandon.screens;

import java.util.Scanner; 

import com.brandon.client.AppUIFunctions;
import com.brandon.service.CustomerService;
import com.brandon.users.Employee;

public class EmployeeLoggedInScreen {

	public static void main(Employee loggedInEmployee) {
		AppUIFunctions.greetLoggedInEmployee(loggedInEmployee);	
		Scanner input = new Scanner(System.in);
		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.employeeLoggedInScreenOptions(loggedInEmployee);
			int userSelection = AppUIFunctions.handleUserSelection(input);
			
			switch(userSelection) {
			case 1: 
				CustomerService customerService = new CustomerService();
				AppUIFunctions.printItem(customerService.returnAllCustomers());
				break;
			case 2: 
				AppUIFunctions.viewAccountDetails();
				break;
			case 3:
				String userName = loggedInEmployee.getFirstName();
				AppUIFunctions.logOutMessage(userName);
				isRunning = false;
				AppUIFunctions.backspace();
				break;
			default:
				AppUIFunctions.invalidInput();
			}
		}		
	}
	
}
