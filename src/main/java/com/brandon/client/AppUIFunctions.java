package com.brandon.client;

import java.util.InputMismatchException;   
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.brandon.AdminLoggedInScreen;
import com.brandon.CustomerLoggedInScreen;
import com.brandon.CustomerScreen;
import com.brandon.EmployeeLoggedInScreen;
import com.brandon.SecondaryCustomerLoggedInScreen;
import com.brandon.repositories.CustomerRepository;
import com.brandon.repositories.CustomerRepositoryImpl;
import com.brandon.repositories.EmployeeRepository;
import com.brandon.repositories.EmployeeRepositoryImpl;
import com.brandon.service.CustomerService;
import com.brandon.service.EmployeeService;
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
		System.out.println("Please select from the following options: \n1: Customer Options \n2: Employee Login \n3: Exit Application");
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
			System.out.println("1: View Cap Keeper Accounts \n2: Cap Keeper Account Details "
					+ "\n3: Log Out \n ");
		} else {
			System.out.println("\nPlease select from the following: ");
			System.out.println("1: View Cap Keeper Accounts \n2: Cap Keeper Account Details "
					+ "\n3: Cancel Cap Keeper Account "
					+ "\n4: Modify Cap Keeper Account Information \n5: Log Out \n ");
		}
	}
	
	public static void customerModificationOptions() {
		System.out.println("Please select from the following options: "
				+ "\n1: Change First Name"
				+ "\n2: Change Last Name "
				+ "\n3: Change Username"
				+ "\n4: Change Password"
				+ "\n5: Change Bottlecap Balance"
				+ "\n6: Remove Secondary Account"
				+ "\n7: Exit Application");
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
		boolean isValid = true;
		Scanner input = new Scanner(System.in);
		String firstName = null;
		while (isValid) {
			Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
			System.out.println("Please input your first name: ");
			String firstNameInput = input.nextLine();
			Matcher m = p.matcher(firstNameInput);
			boolean b = m.find();
			if(b == true) {
				System.out.println("Special characters and numbers are not allowed in your first name.");
			} else if(firstNameInput.length() > 20) {
				System.out.println("Name Length Cannot Exceed 20 Characters.");
			} else if(firstNameInput.length() < 1) {
				System.out.println("You must input a first name \n");
			} else {
				firstName = firstNameInput.substring(0, 1).toUpperCase() + firstNameInput.substring(1);
				isValid = false;
			}
		}
		return firstName;
	}
	
	public static String inputLastName() {
		boolean isValid = true;
		Scanner input = new Scanner(System.in);
		String lastName = null;
		while (isValid) {
			Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
			System.out.println("Please input your last name: ");
			String lastNameInput = input.nextLine();
			Matcher m = p.matcher(lastNameInput);
			boolean b = m.find();
			if(b == true) {
				System.out.println("Special characters and numbers are not allowed in your last name.");
			} else if(lastNameInput.length() > 20) {
				System.out.println("Name Length Cannot Exceed 20 Characters.");
			} else if(lastNameInput.length() < 1) {
				System.out.println("You must input a last name\n");
			} else {
				lastName = lastNameInput.substring(0, 1).toUpperCase() + lastNameInput.substring(1);
				isValid = false;
			}
		}
		return lastName;
	}
	
	public static String inputUserName() {
		boolean isValid = true;
		Scanner input = new Scanner(System.in);
		String userName = null;
		while (isValid) {
			Pattern p = Pattern.compile("[^a-zA-Z0-9]", Pattern.CASE_INSENSITIVE);
			System.out.println("Please input a username: ");
			String userNameInput = input.nextLine();
			Matcher m = p.matcher(userNameInput);
			boolean b = m.find();
			if(b == true) {
				System.out.println("Special characters are not allowed in your username.");
			} else if(userNameInput.length() > 16 || userNameInput.length() < 8) {
				System.out.println("Username Length must be 8-16 characters long.");
			} else {
				userName = userNameInput.toLowerCase();
				isValid = false;
			}
		}
		return userName;
	}
	
	public static String inputPassword() {
		boolean isValid = true;
		Scanner input = new Scanner(System.in);		
		String password = null;
		while (isValid) {
			System.out.println("Please input a password: ");
			String passwordInput = input.nextLine();
			if(passwordInput.length() > 20 || passwordInput.length() < 8) {
				System.out.println("Password Length must be 8-20 characters long.");
			} else {
				password = passwordInput;
				isValid = false;
			}
		}
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
		input.nextLine(); 
		return userSelection;
	}
	
	public static void customerSignUp() {
		boolean isRunning = true;
		while(isRunning) {
			CustomerService customerService = new CustomerService();
			Scanner input = new Scanner(System.in);
			boolean isValid = false;
			while (isValid == false) {
				String firstName = inputFirstName();
				String lastName = inputLastName();		
				String userName = inputUserName();			
				String password = inputPassword();
				if (customerService.findCustomerByUserName(userName) != null) {
					System.out.println("That Username is already taken.");
					} else {
						isValid = true;
						System.out.println("First Name: " + firstName + "\nLast Name: " + 
								lastName + "\nUsername: " + userName + "\nPassword: " + 
								password + "\nIs this information correct?\n 1: Yes   2: No \n");
						
						int response = input.nextInt();
						switch(response) {
						case 1: 
							Customer createdCustomer = new Customer(firstName, lastName, userName, password);
							customerService.createNewCustomer(createdCustomer);
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
		CustomerService customerService = new CustomerService();
		if(loggedInCustomer.secondaryAccount != null) {
			System.out.println("You already someone moochin' off of you. No more!");
		} else {
			boolean isRunning = true;
			while(isRunning) {
				Scanner input = new Scanner(System.in);
				boolean isValid = false;
				while (isValid == false) {
					String firstName = inputFirstName();
					String lastName = inputLastName();		
					String userName = inputUserName();			
					String password = inputPassword();
					if (customerService.findCustomerByUserName(userName) != null) {
						System.out.println("That Username is already taken.");
						} else {
							isValid = true;
							System.out.println("First Name: " + firstName + "\nLast Name: " + 
									lastName + "\nUsername: " + userName + "\nPassword: " + 
									password + "\nIs this information correct?\n 1: Yes   2: No \n");
							
							int response = input.nextInt();
							switch(response) {
							case 1: 
								Customer createdSecondaryCustomer = new Customer(firstName, lastName, userName, password);
								customerService.createNewCustomer(createdSecondaryCustomer);
								customerService.createSecondaryCustomer(loggedInCustomer, createdSecondaryCustomer);
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

	}
	

	
	public static Customer customerLogin() {
		CustomerService customerService = new CustomerService();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String userNameInput = input.next();
		System.out.println("Enter Password: ");
		String passwordInput = input.next();
		Customer retrievedCustomer = customerService.findCustomerByUserName(userNameInput);
		if (retrievedCustomer == null) {
			System.out.println("\nThat username does not exist.");
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
		EmployeeService employeeService = new EmployeeService();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String userNameInput = input.next();
		System.out.println("Enter Password: ");
		String passwordInput = input.next();
		Employee retrievedEmployee = employeeService.findEmployeeByUserName(userNameInput);
		if (retrievedEmployee == null) {
			System.out.println("\nThat username does not exist.");
		} else {
			if (passwordInput.equals(retrievedEmployee.getPassword()) && retrievedEmployee.isAdmin() == true) {
				System.out.println("Successful login! \n");
				AdminLoggedInScreen.main(retrievedEmployee);
			} else if (passwordInput.equals(retrievedEmployee.getPassword()) && retrievedEmployee.isAdmin() == false) {
				System.out.println("Successful login! \n");
				EmployeeLoggedInScreen.main(retrievedEmployee);
			} else {
				System.out.println("Password is incorrect. \n");
			}
		}
		return retrievedEmployee;
	}
	
	public static void viewAccountDetails() {
		Scanner input = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		System.out.println("\nWho's account you snoopin on?");
		System.out.println("You can type in their Username below if ya feel like forgettin' yer morals:");
		String desiredAccount = input.nextLine();
		Customer retrievedAccount = customerService.findCustomerByUserName(desiredAccount);
		
		if (retrievedAccount == null) {
			System.out.println("\nThat username you put in don't match anything I got here, pal.");
		} else {
			System.out.println("\nThere ya go, ya lowlife. Hope you're able to sleep at night.");
			System.out.println("\nName: " + retrievedAccount.getFirstName() + " " + retrievedAccount.getLastName() + "\nUsername: " 
					+ retrievedAccount.getUserName() + "\nPassword: " + retrievedAccount.getPassword() + "\nBottle Caps: " 
					+ retrievedAccount.getBottleCaps() + "\nSecondary Account: " + retrievedAccount.secondaryAccount 
					+ "\nSecondary Account Status: " + retrievedAccount.isSecondaryAccount + "\n ");
		}
	}
	
	public static void cancelCapKeeperAccount() {
		Scanner input = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		System.out.println("\nOooooooo! Someone's gettin' deleted!");
		System.out.println("Type in their Username below wish they never set eyes on ya!:");
		String desiredAccount = input.nextLine();
		Customer retrievedAccount = customerService.findCustomerByUserName(desiredAccount);
		
		if (retrievedAccount == null) {
			System.out.println("\nUhh...can't delete what don't exist buddy...");
		} else {
			if(retrievedAccount.secondaryAccount == null) {
				customerService.deleteCustomer(retrievedAccount);
				System.out.println("Job's done! Wait'll ya see the look on " + retrievedAccount.getFirstName() 
				+ "'s face when they find out!");
			} else {
				Customer secondaryCustomer = customerService.findCustomerByUserName(retrievedAccount.secondaryAccount);
				customerService.deleteCustomer(secondaryCustomer);
				customerService.deleteCustomer(retrievedAccount);
				System.out.println("That'll show em! " + retrievedAccount.getFirstName() + " and "
						+ secondaryCustomer.getFirstName() + " won't be showin' their faces round here no more!");
			}
		}
	}
	
	public static void modifyAccountDetails() {
		Scanner input = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		System.out.println("\nWho's Cap Keeper account we jackin' up this time?");
		System.out.println("Tell me the Username and we'll make quick work of 'em!");
		String desiredAccount = input.nextLine();
		Customer retrievedAccount = customerService.findCustomerByUserName(desiredAccount);
		if (retrievedAccount == null) {
			System.out.println("\nCan't you type anything right? Learn to spell, or no Cap Keeper info for you!");
		} else {
			System.out.println("\nName: " + retrievedAccount.getFirstName() + " " + retrievedAccount.getLastName() + "\nUsername: " 
				+ retrievedAccount.getUserName() + "\nPassword: " + retrievedAccount.getPassword() + "\nBottle Caps: " 
				+ retrievedAccount.getBottleCaps() + "\nSecondary Account: " + retrievedAccount.secondaryAccount 
				+ "\nSecondary Account Status: " + retrievedAccount.isSecondaryAccount + "\n ");
			System.out.println("There ya go! The power of the account in the palm of your hand.");
			
			boolean isValid = true;
			while(isValid) {
				System.out.println("What now, Boss? \n");
				customerModificationOptions();
				int userSelection = AppUIFunctions.handleUserSelection(input);
				switch(userSelection) {
				case 1: 
					System.out.println("What new first name are we thinkin'?");
					String newFirstName = inputFirstName();
					customerService.changeAccountDetails(retrievedAccount, "first_name", newFirstName);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s first name is now " + newFirstName + "..."
							+ "Kind of dumb name, don'tcha think?");
					isValid = false;
					break;
				case 2: 
					System.out.println("What new last name are we thinkin'?");
					String newLastName = inputLastName();
					customerService.changeAccountDetails(retrievedAccount, "last_name", newLastName);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s last name is now " + newLastName + "..."
							+ newLastName + "...Seriously?");
					isValid = false;
					break;
				case 3: 
					System.out.println("What new Username are we thinkin'?");
					String newUsername = inputUserName();
					customerService.changeAccountDetails(retrievedAccount, "user_name", newUsername);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s Username is now " + newUsername + "."
							+ " Customer service'll be hearin' about this one!");
					isValid = false;
					break;
				case 4: 
					System.out.println("What new password are we thinkin'?");
					String newPassword = inputPassword();
					customerService.changeAccountDetails(retrievedAccount, "user_password", newPassword);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s password is now " + newPassword + "."
							+ " Too bad we ain't got no 'Forgot Password' functionality!");
					isValid = false;
					break;
				case 5: 
					System.out.println("How many bottle caps are we assignin' to their name?");
					int newAmount = AppUIFunctions.handleCurrencyAmmount(input);
					customerService.adminUpdateBottleCaps(retrievedAccount, newAmount);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s bottle cap balance is now " + newAmount + "."
							+ " I hope they're happy with that!");
					break;
				case 6: 
					if (retrievedAccount.secondaryAccount == null) {
						System.out.println("\nUhh...can't delete what don't exist buddy...");
					} else {
						Customer secondaryCustomer = customerService.findCustomerByUserName(retrievedAccount.secondaryAccount);
						customerService.removeSecondaryCustomer(retrievedAccount);
						System.out.println("Looks like " + secondaryCustomer.getUserName() + " won't be moochin' off'a "
									+ retrievedAccount.getUserName() + " any more!");
					}
					break;
				case 7:
					isValid = false;
					AppUIFunctions.exitApplication();
					break;
				default:
					AppUIFunctions.invalidInput();		
					
				}
			}
		}
	}
	
	
	
	
}