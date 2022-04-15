package com.brandon;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;
import com.brandon.users.Customer;
public class CustomerScreen {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.customerScreenOptions();
			int userSelection = AppUIFunctions.handleUserSelection(input);
			
			switch(userSelection) {
			case 1: 
				AppUIFunctions.customerLogin();
				break;
			case 2: 
				AppUIFunctions.customerSignUp();
				break;
			case 3:
				isRunning = false;
				AppUIFunctions.backspace();
				break;
			default:
				AppUIFunctions.invalidInput();
			}	
		}
	}
}