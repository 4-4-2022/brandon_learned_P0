package com.brandon;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;
import com.brandon.service.CustomerService;
import com.brandon.users.Employee;

public class AdminLoggedInScreen {

	public static void main(Employee loggedInEmployee) {
		AppUIFunctions.greetLoggedInEmployee(loggedInEmployee);	
		Scanner input = new Scanner(System.in);
		boolean isRunning = true;
		while(isRunning) {
			CustomerService customerService = new CustomerService();
			AppUIFunctions.employeeLoggedInScreenOptions(loggedInEmployee);
			int userSelection = AppUIFunctions.handleUserSelection(input);
			
			switch(userSelection) {
			case 1: 
				AppUIFunctions.printItem(customerService.returnAllCustomers());
				break;
			case 2: 
				AppUIFunctions.viewAccountDetails();
				break;
			case 3:
				AppUIFunctions.cancelCapKeeperAccount();
				break;
			case 4:
				AppUIFunctions.modifyAccountDetails();
				break;
			case 5:
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
