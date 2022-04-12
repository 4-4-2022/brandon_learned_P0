package com.brandon.service;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;
import com.brandon.repositories.CustomerRepository;
import com.brandon.repositories.CustomerRepositoryImpl;
import com.brandon.users.Customer;

public class CustomerService {

	static CustomerRepository customerRepository = new CustomerRepositoryImpl(); //this could cause erros?

	public static void printCapBalance(Customer loggedInCustomer) {
		System.out.println("You currently have " + loggedInCustomer.getBottleCaps() + " Bottle Caps!");
	}
	
//	String.format("%.0f", percentageValue);

	
	public static void depositCaps(Customer loggedInCustomer) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many caps would you like to Deposit?");
		int amountToDeposit = AppUIFunctions.handleCurrencyAmmount(input);
		if (amountToDeposit < 0) {
			System.out.println("Sorry, that is not a valid number.");
		} else {
			loggedInCustomer.setBottleCaps(amountToDeposit + loggedInCustomer.getBottleCaps());
			System.out.println("Deposited " + amountToDeposit + " bottle caps.");
		}
	}
	
	public static void withdrawCaps(Customer loggedInCustomer) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many caps would you like to Withdraw?");
		int amountToWithdraw = AppUIFunctions.handleCurrencyAmmount(input);
		if (amountToWithdraw > loggedInCustomer.getBottleCaps()) {
			System.out.println("You do not have enough caps to withdraw that!");
		} else if (amountToWithdraw < 0){
			System.out.println("Sorry, that is not a valid number.");
		} else {
			loggedInCustomer.setBottleCaps(loggedInCustomer.getBottleCaps() - amountToWithdraw);
			System.out.println("Withdew " + amountToWithdraw + " bottle caps.");
		}
	}
	
	public static void donateCaps(Customer loggedInCustomer) {
		Scanner input = new Scanner(System.in);
		String secondaryAccountName = loggedInCustomer.getSecondaryAccount();
		Customer retrievedCustomer = customerRepository.findCustomerByUserName(secondaryAccountName);
		System.out.println("How many caps would you like to donate to " + retrievedCustomer.firstName + "?");
		int amountToDonate = AppUIFunctions.handleCurrencyAmmount(input);
		if (amountToDonate < 0) {
			System.out.println("Sorry, that is not a valid number.");
		} else if (amountToDonate > loggedInCustomer.getBottleCaps()){
			System.out.println("You do not have enough caps to donate that.");

		} else {
			loggedInCustomer.setBottleCaps(loggedInCustomer.getBottleCaps() - amountToDonate);
			retrievedCustomer.setBottleCaps(amountToDonate + retrievedCustomer.getBottleCaps());
			System.out.println("Donated " + amountToDonate + " bottle caps to " + retrievedCustomer.firstName + ".");
		}
	}
}
