package com.brandon;

import java.util.Scanner;
import java.util.Set;

import com.brandon.client.AppUIFunctions;
import com.brandon.service.CustomerService;
import com.brandon.users.Customer;

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
				CustomerService customerService = new CustomerService();
				Customer customer = new Customer("Barret", "Wallace", "machinegun", "marlene35");
				System.out.println(customer);
				customerService.createNewCustomer(customer);
//				Set<Customer> customers = customerService.returnAllCustomers();
//				CustomerScreen.main(args);
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
