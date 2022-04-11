package com.brandon;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;
import com.brandon.users.Customer;
public class CustomerScreen {

	public static void main(String[] args) {
		
		boolean isRunning = true;
		while(isRunning) {
			Scanner input = new Scanner(System.in);
			AppUIFunctions.customerScreenOptions();
			
			int userSelection = input.nextInt();
			input.nextLine(); // Leaver this here as there is a newline character that I you want to eat
			
			switch(userSelection) {
			case 1: 
				AppUIFunctions.customerLogin();
				break;
			case 2: 
				AppUIFunctions.createNewCustomer();
				break;

			case 3:
				isRunning = false;
				AppUIFunctions.backspace();
				break;
			default:
				AppUIFunctions.invalidInput();
				
			input.close();

			}	
		}
	}
}
