package com.brandon.service;

import java.util.Scanner;

import com.brandon.client.AppUIFunctions;
import com.brandon.users.Customer;

public class CustomerService {

	public static void printCapBalance(Customer loggedInCustomer) {
		System.out.println("You currently have " + loggedInCustomer.getBottleCaps() + " Bottle Caps!");
	}
	
	public static void depositCaps(Customer loggedInCustomer) {
		Scanner input = new Scanner(System.in);
		System.out.println("How much would you like to Deposit?");
		int amountToDeposit = AppUIFunctions.handleCurrencyAmmount(input);
		loggedInCustomer.setBottleCaps(amountToDeposit + loggedInCustomer.getBottleCaps());
		System.out.println("Deposited " + amountToDeposit + " bottle caps.");
	}
	
	public static void withdrawCaps(Customer loggedInCustomer) {
		Scanner input = new Scanner(System.in);
		System.out.println("How much would you like to Withdraw?");
		int amountToWithdraw = AppUIFunctions.handleCurrencyAmmount(input);
		if (amountToWithdraw > loggedInCustomer.getBottleCaps()) {
			System.out.println("You do not have enough funds to withdraw that!");
		} else {
			loggedInCustomer.setBottleCaps(loggedInCustomer.getBottleCaps() - amountToWithdraw);
			System.out.println("Withdew " + amountToWithdraw + " bottle caps.");
		}
	}
}
