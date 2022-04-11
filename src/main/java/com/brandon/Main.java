package com.brandon;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;

public class Main {
	public static void main (String[] args) {
		
		
		AppUIFunctions.startApplication();
		
		boolean isRunning = true;
		while(isRunning) {
			
			AppUIFunctions.mainScreenOptions();
			
			Scanner input = new Scanner(System.in);
			
			int userSelection = input.nextInt();
			input.nextLine();
			
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
				
			input.close();
			}

		}
		
	}

}
