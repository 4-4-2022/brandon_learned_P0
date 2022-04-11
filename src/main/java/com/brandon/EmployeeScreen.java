package com.brandon;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;

public class EmployeeScreen {

	public static void main(String[] args) {

	
		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.employeeScreenOptions();
			
			Scanner scanner = new Scanner(System.in);
			
			int userSelection = scanner.nextInt();
			scanner.nextLine(); // Leaver this here as there is a newline character that I you want to eat
			
//			String userName = scanner.nextLine();
//			System.out.println(userName);
			
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
