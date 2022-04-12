package com.brandon;

import java.util.Scanner; 

import com.brandon.client.AppUIFunctions;

public class Main {
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		AppUIFunctions.startApplication();

		boolean isRunning = true;
		while(isRunning) {
			AppUIFunctions.mainScreenOptions();
			int userSelection = AppUIFunctions.handleUserSelection(input);
			
			switch(userSelection) {
			case 1: 
				CustomerScreen.main(args);
				break;
				
			case 2: 
				EmployeeScreen.main(args);
				break;
				
			case 3:
				isRunning = false;
				AppUIFunctions.exitApplication();
				break;
			default:
				AppUIFunctions.invalidInput();		
			}
		}
		input.close();
	}
}
