package com.brandon;

import java.util.Scanner; 

import com.brandon.client.AppUIFunctions;
import com.brandon.service.CustomerService;
import com.brandon.users.Customer;

public class SecondaryCustomerLoggedInScreen {

	public static void main(Customer loggedInCustomer) {
		AppUIFunctions.greetLoggedInCustomer(loggedInCustomer);	
		Scanner input = new Scanner(System.in);
		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.customerLoggedInScreenOptions(loggedInCustomer);
			int userSelection = AppUIFunctions.handleUserSelection(input);
			
			switch(userSelection) {
			case 1: 
				CustomerService.printCapBalance(loggedInCustomer);
				break;
			case 2:
				CustomerService.withdrawCaps(loggedInCustomer);
				break;
			case 3:
				String userName = loggedInCustomer.firstName;
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
