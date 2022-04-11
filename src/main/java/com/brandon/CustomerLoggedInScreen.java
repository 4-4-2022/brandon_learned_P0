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
				System.out.println("You currently have " + loggedInCustomer.getBottleCaps() + " Bottle Caps!");
				break;
			case 2: 
				System.out.println("How much would you like to Deposit?");
				int amountToDeposit = input.nextInt();
				loggedInCustomer.setBottleCaps(amountToDeposit + loggedInCustomer.getBottleCaps());
				System.out.println("You balance is now " + loggedInCustomer.getBottleCaps() + " bottle caps.");
				break;
			case 3:
				System.out.println("How much would you like to Withdraw?");
				short amountToWithdraw = input.nextShort();
				if (amountToWithdraw > loggedInCustomer.getBottleCaps()) {
					System.out.println("You do not have enough funds to withdraw that!");
				} else {
					loggedInCustomer.setBottleCaps(loggedInCustomer.getBottleCaps() - amountToWithdraw);
				}
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



