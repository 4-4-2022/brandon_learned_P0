package com.brandon.client;

import java.util.Scanner;
import java.util.Set;

import com.brandon.repositories.CustomerRepository;
import com.brandon.repositories.CustomerRepositoryImpl;
import com.brandon.users.Customer;

public class AppUIFunctions {
		
	static CustomerRepository customerRepository = new CustomerRepositoryImpl();
	static Set <Customer> customers = customerRepository.returnAllCustomers(); //These two lines of code allow case 3 to call it's for look
	
	public static void startApplication() {
		System.out.println("Welcome to Cap Keeper! Your friendly Wasteland safehaven for all bottlecap storage needs!\n"
				+ "We apologize for the lack of a Graphical User Interface, technology is...lacking these days.\n");
		
//		
//				+ ""
//				+ "Please, select from the following options:\n \n1: Customer Login \n2: Employee Login \n3: Exit Application");
	}
	
	public static void mainScreenOptions() {
		System.out.println("Please select from the following options: \n1: Customer Options \n2: Employee Options \n3: Exit Application");
	}
	
	public static void customerScreenOptions() {
		System.out.println("Customer Options - Please select from the following: ");
		System.out.println("1: Login \n2: Sign up \n3: Back to Home Screen");
	}
	
	public static void greetLoggedInCustomer(Customer loggedInCustomer) {
		System.out.println("Hello " + loggedInCustomer.firstName + "!");
	}
	public static void customerLoggedInScreenOptions() {
		System.out.println("\nPlease select from the following: ");
		System.out.println("1: Check Cap Balance \n2: Deposit Caps \n3: Withdraw Caps \n4: Log Out \n ");
	}
	
	public static void employeeScreenOptions() {
		System.out.println("Employee Options - Please select from the following: ");
		System.out.println("1: Login \n2: Sign up \n3: View All Customers \n4 Back to Home Screen");
	}
	
	public static void exitApplication() {
		System.out.println("Watch out for Ghouls!");
	}
	
	public static void backspace() {
		System.out.println("Returning back one screen \n ");
	}
	
	public static void viewCustomers() {
		for(Object customer : customers) {
			System.out.println(customer);
		}
	}
	
	public static void promptUserName () {
		System.out.println("Enter Username: ");
	}
	
	public static void promptUserPassword () {
		System.out.println("Enter Password: ");
	}
	
	public static void createNewCustomer() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your first name: ");
		String firstName = input.nextLine();
		System.out.println("Please input your last name: ");
		String lastName = input.nextLine();
		System.out.println("Please input a username: ");
		String userName = input.next();
		System.out.println("Please input a password: ");
		String password = input.next();
		CustomerRepositoryImpl.addCustomer(firstName, lastName, userName, password);
		System.out.println("Account Successfully Created! \n ");
	}
	
	public static Customer customerLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String userNameInput = input.next();
		System.out.println("Enter Password: ");
		String passwordInput = input.next();
		Customer retrievedCustomer = customerRepository.findCustomerByUserName(userNameInput);
		if (retrievedCustomer == null) {
			System.out.println("That username does not exist.");
		} else {
			if (passwordInput.equals(retrievedCustomer.getPassword())) {
				System.out.println("Successful login!");
			} else {
				System.out.println("Password is incorrect.");
			}
			
		} 
		return retrievedCustomer;
	}
	
	public static void invalidInput() {
		System.out.println("That is not a valid input, please try again.");
	}
	
}
