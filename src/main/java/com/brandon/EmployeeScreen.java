package com.brandon;

import java.util.Scanner; 
import com.brandon.client.AppUIFunctions;

public class EmployeeScreen {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
	
		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.employeeScreenOptions();			
			int userSelection = AppUIFunctions.handleUserSelection(input);

			switch(userSelection) {
			case 1: 
				System.out.println("Not implemented yet.");
				break;	
			case 2: 
				System.out.println("Not implemented yet");
				break;
			case 3:
				AppUIFunctions.viewCustomers();
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
