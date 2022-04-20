package com.brandon.service;

import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brandon.client.AppUIFunctions;
import com.brandon.repositories.CustomerRepository;
import com.brandon.repositories.CustomerRepositoryImpl;
import com.brandon.users.Customer;

public class CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	private CustomerRepository customerRepository;

	public CustomerService() {
		this.customerRepository = CustomerRepositoryImpl.getCustomerRepository();
	}
	
	public Set<Customer> returnAllCustomers(){
		Set<Customer> retrievedCustomers = null;
		retrievedCustomers = this.customerRepository.returnAllCustomers();
		return retrievedCustomers;
	}
	
	public Customer findCustomerByUserName(String input){
		return this.customerRepository.findCustomerByUserName(input);
	}
	
	public void createNewCustomer(Customer customer) {
		this.customerRepository.createNewCustomer(customer);
	}
	
	public void createSecondaryCustomer(Customer primary, Customer secondary) {
		this.customerRepository.createSecondaryCustomer(primary, secondary);
		
	}
	
	public void updateCustomerBottleCaps(Customer customer, double bottleCapAmount) {
		this.customerRepository.updateCustomerBottleCaps(customer, bottleCapAmount);
	}
	
	public void donateBottleCapsToSecondary(Customer customer, double amount, double amount2) {
		this.customerRepository.donateBottleCapsToSecondary(customer, amount, amount2);
	};
	
	public void deleteCustomer(Customer customer) {
		this.customerRepository.deleteCustomer(customer);
	}
	
	public void changeAccountDetails(Customer customer, String fieldToChange, String changeValue) {
		this.customerRepository.changeAccountDetails(customer, fieldToChange, changeValue);
	}
	
	public void adminUpdateBottleCaps(Customer customer, double amount) {
		this.customerRepository.admimUpdateBottleCaps(customer, amount);
	}
	
	public void removeSecondaryCustomer(Customer customer) {
		this.customerRepository.removeSecondaryCustomer(customer);
	}
	
	
	public static void printCapBalance(Customer loggedInCustomer) {
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.findCustomerByUserName(loggedInCustomer.getUserName());
		System.out.println("You currently have " + customer.getBottleCaps() + " Bottle Caps!");
	}

	
	public static void depositCaps(Customer loggedInCustomer) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many caps would you like to Deposit?");
		int amountToDeposit = AppUIFunctions.handleCurrencyAmmount(input);
		if (amountToDeposit < 0) {
			System.out.println("Sorry, that is not a valid number.");
		} else {
			CustomerService customerService = new CustomerService();
			Customer customer = customerService.findCustomerByUserName(loggedInCustomer.getUserName());
			double amount = amountToDeposit + loggedInCustomer.getBottleCaps();
			customerService.updateCustomerBottleCaps(customer, amount);
			System.out.println("Deposited " + amountToDeposit + " bottle caps. \nYou now have " + amount + " bottlecaps saved!");
			logger.info("User " + loggedInCustomer.getUserName() + " deposited " + amountToDeposit + " bottle caps.");
		}
	}
	
	public static void withdrawCaps(Customer loggedInCustomer) {
		Scanner input = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.findCustomerByUserName(loggedInCustomer.getUserName());
		System.out.println("How many caps would you like to Withdraw?");
		int amountToWithdraw = AppUIFunctions.handleCurrencyAmmount(input);
		if (amountToWithdraw > customer.getBottleCaps()) {
			System.out.println("You do not have enough caps to withdraw that!");
		} else if (amountToWithdraw < 0){
			System.out.println("Sorry, that is not a valid number.");
		} else {
			double amount = customer.getBottleCaps() - amountToWithdraw;
			customerService.updateCustomerBottleCaps(customer, amount);
			System.out.println("Withdrew " + amountToWithdraw + " bottle caps. \nYou now have " + amount + " bottlecaps being saved!");
			logger.info("User " + loggedInCustomer.getUserName() + " withdrew " + amountToWithdraw + " bottle caps.");
		}
	}
	
	public static void donateCaps(Customer loggedInCustomer) {
		Scanner input = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.findCustomerByUserName(loggedInCustomer.getUserName());
		Customer secondaryCustomer = customerService.findCustomerByUserName(customer.secondaryAccount);
		if(secondaryCustomer == null) {
			System.out.println("You do not have a secondary account.");
		} else {System.out.println("How many caps would you like to donate to " + secondaryCustomer.getFirstName() + "?");
		int amountToDonate = AppUIFunctions.handleCurrencyAmmount(input);
		if (amountToDonate < 0) {
			System.out.println("Sorry, that is not a valid number.");
		} else if (amountToDonate > customer.getBottleCaps()){
			System.out.println("You do not have enough caps to donate that.");
		} else {
			double amount = customer.getBottleCaps() - amountToDonate;
			double amount2 = secondaryCustomer.getBottleCaps() + amountToDonate;
			customerService.donateBottleCapsToSecondary(customer, amount, amount2);
			System.out.println("Donated " + amountToDonate + " bottle caps to " + secondaryCustomer.firstName + ".");
			logger.info("User " + loggedInCustomer.getUserName() + " donated " + amountToDonate
					+ " bottle caps to their Secondary User " + secondaryCustomer.getUserName() + ".");
		}
			
			
			
		}
	
	}
}
