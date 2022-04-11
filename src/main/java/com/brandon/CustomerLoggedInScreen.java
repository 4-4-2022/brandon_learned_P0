package com.brandon;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;
import com.brandon.users.Customer;

public class CustomerLoggedInScreen {
	
	public static void main(Customer loggedInCustomer) {
		AppUIFunctions.greetLoggedInCustomer(loggedInCustomer);		
		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.customerLoggedInScreenOptions();
			
			Scanner input = new Scanner(System.in);
			
			int userSelection = input.nextInt();
			input.nextLine(); // Leaver this here as there is a newline character that I you want to eat
			
			switch(userSelection) {
			case 1: 
				System.out.println("You currently have " + loggedInCustomer.getFunds() + " Bottle Caps!");
				break;
				
			case 2: 
				System.out.println("Not implemented");
				break;
			case 3:
				System.out.println("Not implemented");
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



