package com.brandon;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;
import com.brandon.users.Employee;

public class AdminLoggedInScreen {

	public static void main(Employee loggedInEmployee) {
		AppUIFunctions.greetLoggedInEmployee(loggedInEmployee);	
		Scanner input = new Scanner(System.in);
		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.employeeLoggedInScreenOptions(loggedInEmployee);
			int userSelection = AppUIFunctions.handleUserSelection(input);
			
			switch(userSelection) {
			case 1: 
				AppUIFunctions.viewCustomers();
				//CustomerService.printCapBalance(loggedInEmployee);
				break;
			case 2: 
				//view account balances
				System.out.println("Not in service");
				//CustomerService.depositCaps(loggedInEmployee);
				break;
			case 3:
				//view account personal information
				System.out.println("Not in service");
				//CustomerService.withdrawCaps(loggedInEmployee);
				break;
			case 4:
				//modify account cap balance
				System.out.println("Not in service");

				//AppUIFunctions.createSecondaryCustomer(loggedInEmployee);
				break;
			case 5:
				//cancel and account
				System.out.println("Not in service");

				//CustomerService.donateCaps(loggedInEmployee);
				break;
			case 6:
				String userName = loggedInEmployee.firstName;
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
