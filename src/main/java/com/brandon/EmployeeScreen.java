package com.brandon;

import java.util.Scanner; 
import com.brandon.client.AppUIFunctions;
import com.brandon.service.CustomerService;

public class EmployeeScreen {

	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();
		
		Scanner input = new Scanner(System.in);
	
		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.employeeScreenOptions();			
			int userSelection = AppUIFunctions.handleUserSelection(input);			

			switch(userSelection) {
			case 1: 
				AppUIFunctions.employeeLogin();
				break;	
			case 2: 
				System.out.println("Not implemented yet");
				break;
			case 3:
				AppUIFunctions.printItem(customerService.returnAllCustomers());
				break;
			case 4:
				isRunning = false;
				AppUIFunctions.backspace();
				break;
			default:
				AppUIFunctions.invalidInput();
			}
		}
	}
	
}
