package com.brandon.client;

import java.util.InputMismatchException;   
import java.util.Scanner;
import java.util.Set;

import com.brandon.AdminLoggedInScreen;
import com.brandon.CustomerLoggedInScreen;
import com.brandon.EmployeeLoggedInScreen;
import com.brandon.SecondaryCustomerLoggedInScreen;
import com.brandon.repositories.CustomerRepository;
import com.brandon.repositories.CustomerRepositoryImpl;
import com.brandon.repositories.EmployeeRepository;
import com.brandon.repositories.EmployeeRepositoryImpl;
import com.brandon.service.CustomerService;
import com.brandon.users.Customer;
import com.brandon.users.Employee;

public class AppUIFunctions {
		

//keep these		
	
	public static void printItem(Object item) {
		if(item instanceof Iterable) {
			Iterable iterable = (Iterable) item;
			for(Object o : iterable) {
				System.out.println(o);
			}
		}else if(item instanceof Object[]) {
			Object[] array = (Object[]) item;
			for(Object o : array) {
				System.out.println(o);
			}
		}else System.out.println(item);
	}
	
	public static void startApplication() {
		System.out.println("Welcome to Cap Keeper! Your friendly Wasteland safehaven for all bottlecap storage needs!\n"
				+ "We apologize for the lack of a Graphical User Interface, technology is...lacking these days.\n");
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
	
	public static void greetLoggedInEmployee(Employee loggedInEmployee) {
		System.out.println("Hello " + loggedInEmployee.firstName + "!");
	}
	
	public static void customerLoggedInScreenOptions(Customer loggedInCustomer) {
		if (loggedInCustomer.isSecondaryAccount() == false) {
			System.out.println("\nPlease select from the following: ");
			System.out.println("1: Check Cap Balance \n2: Deposit Caps \n3: Withdraw Caps "
					+ "\n4: Create Secondary Account \n5: Donate Caps to Secondary Account \n6: Log Out \n ");
		} else {
			System.out.println("\nPlease select from the following: ");
			System.out.println("1: Check Cap Balance \n2: Withdraw Caps \n3: Log Out \n ");
		}
	}
	
	public static void employeeLoggedInScreenOptions(Employee loggedInEmployee) {
		if (loggedInEmployee.isAdmin() == false) {
			System.out.println("\nPlease select from the following: ");
			System.out.println("1: View Customer Account Information \n2: View Customer Cap Balance "
					+ "\n3: View Customer Personal Info "
					+ "\n4: Log Out \n ");
		} else {
			System.out.println("\nPlease select from the following: ");
			System.out.println("1: View Customer Account Information \n2: View Customer Cap Balance "
					+ "\n3: View Customer Personal Info "
					+ "\n4: Modify Account Cap Balance \n5: Cancel Existing Cap Keeper Account \n6: Log Out \n ");
		}
	}
	
	
	public static void employeeScreenOptions() {
		System.out.println("Employee Options - Please select from the following: ");
		System.out.println("1: Login \n2: Sign up \n3: View All Customers \n4 Back to Home Screen");
	}
	
	public static void exitApplication() {
		System.out.println("Watch out for Ghouls!");
	}
	
	public static void logOutMessage(String nameInput) {
		System.out.println("Goodbye " + nameInput + "! Don't get eaten!");
	}
	
	public static void backspace() {
		System.out.println("Returning back one screen \n ");
	}
	
	public static void promptUserName () {
		System.out.println("Enter Username: ");
	}
	
	public static void promptUserPassword () {
		System.out.println("Enter Password: ");
	}
	
	public static String inputFirstName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your first name: ");
		String firstNameInput = input.nextLine();
		firstNameInput = firstNameInput.replaceAll("[^a-zA-Z]", "");
		String firstName = firstNameInput.substring(0, 1).toUpperCase() + firstNameInput.substring(1);
		return firstName;
	}
	
	public static String inputLastName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your last name: ");
		String lastNameInput = input.nextLine();
		lastNameInput = lastNameInput.replaceAll("[^a-zA-Z0-9]", "");
		String lastName = lastNameInput.substring(0, 1).toUpperCase() + lastNameInput.substring(1);
		return lastName;
	}
	
	public static String inputUserName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a username: ");
		String userNameInput = input.nextLine();
		String userName = userNameInput.replaceAll("[^a-zA-Z0-9]", "");	
		return userName;
	}
	
	public static String inputPassword() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a password: ");
		String passwordInput = input.nextLine();
		String password = passwordInput.replaceAll(" ", "");
		return password;
	}
	
	public static void invalidInput() {
		System.out.println("That is not a valid input, please try again. \n");
	}
	
	public static int handleUserSelection(Scanner input) {
		int userSelection = 0;
		try {
			userSelection = input.nextInt();
		}catch(InputMismatchException e) {
			
		}
		input.nextLine(); // Leaving this here as there is a newline character in the stream
		return userSelection;
	}
	
	public static int handleCurrencyAmmount(Scanner input) {
		int userSelection = 0;
		try {
			userSelection = input.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Not a valid Number.");
		}
		input.nextLine(); // Leaving this here as there is a newline character in the stream
		return userSelection;
	}
	
	//maybe keep

	//	static Set <Employee> employees = employeeRepository.returnAllEmployees();

	
	public static void viewCustomers() {
		CustomerService customerService = new CustomerService();
		Set<Customer> customers = customerService.returnAllCustomers();
		for(Object customer : customers) {
			System.out.println(customer);
		}
	}
	
//	public static void viewEmployees() {
//		for(Object employee : employees) {
//			System.out.println(employee);
//		}
//	}
	
	
	public static void createNewCustomer() {
		boolean isRunning = true;
		while(isRunning) {
			Scanner input = new Scanner(System.in);
			boolean isValid = false;
			while (isValid == false) {
				String firstName = inputFirstName();
				String lastName = inputLastName();		
				String userName = inputUserName();			
				String password = inputPassword();
				if (customerRepository.findCustomerByUserName(userName) != null) {
					System.out.println("That Username is already taken.");
					} else {
						isValid = true;
						System.out.println("First Name: " + firstName + "\nLast Name: " + 
								lastName + "\nUsername: " + userName + "\nPassword: " + 
								password + "\nIs this information correct?\n 1: Yes   2: No \n");
						
						int response = input.nextInt();
						switch(response) {
						case 1: 
							CustomerRepositoryImpl.addCustomer(firstName, lastName, userName, password);
							System.out.println("User " + userName + " Successfully Created! \n ");
							isRunning = false;
							break;
						case 2: 
							System.out.println("Account not created");
							break;
						default:
							AppUIFunctions.invalidInput();
					
						}	
					}
			}
		}
	}
	
	public static void createSecondaryCustomer(Customer loggedInCustomer) {
		boolean isRunning = true;
		while(isRunning) {
			Scanner input = new Scanner(System.in);
			boolean isValid = false;
			while (isValid == false) {
				String firstName = inputFirstName();
				String lastName = inputLastName();		
				String userName = inputUserName();			
				String password = inputPassword();
				if (customerRepository.findCustomerByUserName(userName) != null) {
					System.out.println("That Username is already taken.");
					} else {
						isValid = true;
						System.out.println("First Name: " + firstName + "\nLast Name: " + 
								lastName + "\nUsername: " + userName + "\nPassword: " + 
								password + "\nIs this information correct?\n 1: Yes   2: No \n");
						
						int response = input.nextInt();
						switch(response) {
						case 1: 
							CustomerRepositoryImpl.addCustomer(firstName, lastName, userName, password);
							loggedInCustomer.setSecondaryAccount(userName);
							Customer retrievedCustomer = customerRepository.findCustomerByUserName(userName);
							retrievedCustomer.setSecondaryAccount(true);
							System.out.println("Secondary User " + userName + " Successfully Created! \n ");
							isRunning = false;
							break;
						case 2: 
							System.out.println("Account not created");
							break;
						default:
							AppUIFunctions.invalidInput();
					
						}	
					}
			}
		}
	}
	

	
	public static Customer customerLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String userNameInput = input.next();
		System.out.println("Enter Password: ");
		String passwordInput = input.next();
		Customer retrievedCustomer = customerRepository.findCustomerByUserName(userNameInput);
		if (retrievedCustomer == null) {
			System.out.println("That username does not exist. \n");
		} else {
			if (passwordInput.equals(retrievedCustomer.getPassword()) && retrievedCustomer.isSecondaryAccount() == false) {
				System.out.println("Successful login! \n");
				CustomerLoggedInScreen.main(retrievedCustomer);
			} else if (passwordInput.equals(retrievedCustomer.getPassword()) && retrievedCustomer.isSecondaryAccount() == true) {
				System.out.println("Successful login! \n");
				SecondaryCustomerLoggedInScreen.main(retrievedCustomer);
			} else {
				System.out.println("Password is incorrect. \n");
			}
			
		} 
		return retrievedCustomer;
	}
	
	
	public static Employee employeeLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String userNameInput = input.next();
		System.out.println("Enter Password: ");
		String passwordInput = input.next();
		Employee retrievedEmployee = employeeRepository.findEmployeeByUserName(userNameInput);
		if (retrievedEmployee == null) {
			System.out.println("That employee does not exist. \n");
		} else {
			if (passwordInput.equals(retrievedEmployee.getPassword()) && retrievedEmployee.isAdmin() == false) {
				System.out.println("Successful login! \n");
				EmployeeLoggedInScreen.main(retrievedEmployee);
			} else if (passwordInput.equals(retrievedEmployee.getPassword()) && retrievedEmployee.isAdmin() == true) {
				System.out.println("Successful login! \n");
				AdminLoggedInScreen.main(retrievedEmployee);
			} else {
				System.out.println("Password is incorrect. \n");
			}
			
		} 
		return retrievedEmployee;
	}
	
}