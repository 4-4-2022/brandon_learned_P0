package com.brandon.client;

import java.util.InputMismatchException;   
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.brandon.repositories.CustomerRepository;
import com.brandon.repositories.CustomerRepositoryImpl;
import com.brandon.repositories.EmployeeRepository;
import com.brandon.repositories.EmployeeRepositoryImpl;
import com.brandon.screens.AdminLoggedInScreen;
import com.brandon.screens.CustomerLoggedInScreen;
import com.brandon.screens.CustomerScreen;
import com.brandon.screens.EmployeeLoggedInScreen;
import com.brandon.screens.SecondaryCustomerLoggedInScreen;
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
				+ "\n7: Previous Screen");
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
	
	public static String inputFirstName(String firstNameInput) {
			Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(firstNameInput);
			boolean b = m.find();
			if(b == true) {
				System.out.println("Special characters and numbers are not allowed in First Names.");
				return null;
			} else if(firstNameInput.length() > 20) {
				System.out.println("Name Length Cannot Exceed 20 Characters.");
				return null;
			} else if(firstNameInput.length() < 1) {
				System.out.println("You must input a First Name \n");
				return null;
			} else {
				String firstName = firstNameInput.substring(0, 1).toUpperCase() + firstNameInput.substring(1).toLowerCase();
				return firstName;
			}
		}
	
	
	public static String inputLastName(String lastNameInput) {
		Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(lastNameInput);
		boolean b = m.find();
		if(b == true) {
			System.out.println("Special characters and numbers are not allowed in First Names.");
			return null;
		} else if(lastNameInput.length() > 20) {
			System.out.println("Name Length Cannot Exceed 20 Characters.");
			return null;
		} else if(lastNameInput.length() < 1) {
			System.out.println("You must input a First Name \n");
			return null;
		} else {
			String firstName = lastNameInput.substring(0, 1).toUpperCase() + lastNameInput.substring(1).toLowerCase();
			return firstName;
		}
	}
	
	public static String inputUserName(String userNameInput) {
		Pattern p = Pattern.compile("[^a-zA-Z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(userNameInput);
		boolean b = m.find();
		if(b == true) {
			System.out.println("Special characters are not allowed in Usernames.");
			return null;
		} else if(userNameInput.length() > 16 || userNameInput.length() < 8) {
			System.out.println("Username Length must be 8-16 characters long.");
			return null;
		} else {
			String userName = userNameInput.toLowerCase();
			return userName;
		}
	}

	
	public static String inputPassword(String passwordInput) {
        for (int i = 0; i < passwordInput.length(); i++) {
        	 
            // Checking the character for not being a
            // letter,digit or space
            if (Character.isWhitespace(passwordInput.charAt(i))) {
            	System.out.println("Spaces are not allowed in passwords");
            	return null;
            }
        }
			if(passwordInput.length() > 20 || passwordInput.length() < 8) {
				System.out.println("Password Length must be 8-20 characters long.");
				return null;
			} else {
				return passwordInput;
			}
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
				String firstNameOutput = null;
				while (firstNameOutput == null) {
					System.out.println("Please enter a First Name:");
					String firstNameInput = input.nextLine();
					firstNameOutput = inputFirstName(firstNameInput);
				}
				String lastNameOutput = null;
				while (lastNameOutput == null) {
					System.out.println("Please enter a Last Name:");
					String lastNameInput = input.nextLine();
					lastNameOutput = inputLastName(lastNameInput);
				}
				String userNameOutput = null;
				while (userNameOutput == null) {
					System.out.println("Please enter a Username:");
					String userNameInput = input.nextLine();
					userNameOutput = inputUserName(userNameInput);
				}
				
				String passwordOutput = null;
				while (passwordOutput == null) {
					System.out.println("Please enter a Password:");
					String passwordInput = input.nextLine();
					passwordOutput = inputPassword(passwordInput);
				}
			
				if (customerService.findCustomerByUserName(userNameOutput) != null) {
					System.out.println("That Username is already taken.");
					} else {
						isValid = true;
						System.out.println("First Name: " + firstNameOutput + "\nLast Name: " + 
								lastNameOutput + "\nUsername: " + userNameOutput + "\nPassword: " + 
								passwordOutput + "\nIs this information correct?\n 1: Yes   2: No \n");
						
						int response = input.nextInt();
						switch(response) {
						case 1: 
							Customer createdCustomer = new Customer(firstNameOutput, lastNameOutput, userNameOutput, passwordOutput);
							customerService.createNewCustomer(createdCustomer);
							System.out.println("User " + userNameOutput + " Successfully Created! \n ");
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
			System.out.println("You already have a secondary user associated with you account!");
		} else {
			boolean isRunning = true;
			while(isRunning) {
				Scanner input = new Scanner(System.in);
				boolean isValid = false;
				while (isValid == false) {
					String firstNameOutput = null;
					while (firstNameOutput == null) {
						System.out.println("Enter your First Name:");
						String firstNameInput = input.nextLine();
						firstNameOutput = inputFirstName(firstNameInput);
					}
					
					String lastNameOutput = null;
					while (lastNameOutput == null) {
						System.out.println("Enter your Last Name:");
						String lastNameInput = input.nextLine();
						lastNameOutput = inputLastName(lastNameInput);
					}
					
					String userNameOutput = null;
					while (userNameOutput == null) {
						System.out.println("Please enter a Username:");
						String userNameInput = input.nextLine();
						userNameOutput = inputUserName(userNameInput);
					}
					
					String passwordOutput = null;
					while (passwordOutput == null) {
						System.out.println("Please enter a Password:");
						String passwordInput = input.nextLine();
						passwordOutput = inputPassword(passwordInput);
					}

					if (customerService.findCustomerByUserName(userNameOutput) != null) {
						System.out.println("That Username is already taken.");
						} else {
							isValid = true;
							System.out.println("First Name: " + firstNameOutput + "\nLast Name: " + 
									lastNameOutput + "\nUsername: " + userNameOutput + "\nPassword: " + 
									passwordOutput + "\nIs this information correct?\n 1: Yes   2: No \n");
							
							int response = input.nextInt();
							switch(response) {
							case 1: 
								Customer createdSecondaryCustomer = new Customer(firstNameOutput, lastNameOutput, userNameOutput, passwordOutput);
								customerService.createNewCustomer(createdSecondaryCustomer);
								customerService.createSecondaryCustomer(loggedInCustomer, createdSecondaryCustomer);
								System.out.println("Secondary User " + userNameOutput + " Successfully Created! \n ");
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
		System.out.println("\nPlease enter the Username associated with the account you would like to view:");
		String desiredAccount = input.nextLine();
		Customer retrievedAccount = customerService.findCustomerByUserName(desiredAccount);
		
		if (retrievedAccount == null) {
			System.out.println("\nUsername does not exist.");
		} else {
			System.out.println("\nUser found:");
			System.out.println("\nName: " + retrievedAccount.getFirstName() + " " + retrievedAccount.getLastName() + "\nUsername: " 
					+ retrievedAccount.getUserName() + "\nPassword: " + retrievedAccount.getPassword() + "\nBottle Caps: " 
					+ retrievedAccount.getBottleCaps() + "\nSecondary Account: " + retrievedAccount.secondaryAccount 
					+ "\nSecondary Account Status: " + retrievedAccount.isSecondaryAccount + "\n ");
		}
	}
	
	public static void cancelCapKeeperAccount() {
		Scanner input = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		System.out.println("Please enter the Username associated with the account you would like to delete:");
		String desiredAccount = input.nextLine();
		Customer retrievedAccount = customerService.findCustomerByUserName(desiredAccount);
		
		if (retrievedAccount == null) {
			System.out.println("\nUsername does not exist.");
		} else {
			if(retrievedAccount.secondaryAccount == null) {
				customerService.deleteCustomer(retrievedAccount);
				System.out.println("Cap Keeper User: " + retrievedAccount.getUserName() 
				+ " successfully deleted.");
			} else {
				Customer secondaryCustomer = customerService.findCustomerByUserName(retrievedAccount.secondaryAccount);
				customerService.deleteCustomer(secondaryCustomer);
				customerService.deleteCustomer(retrievedAccount);
				System.out.println("Cap Keeper Accounts: " + retrievedAccount.getUserName() + " and "
						+ secondaryCustomer.getUserName() + "  successfully deleted.");
			}
		}
	}
	
	public static void modifyAccountDetails() {
		Scanner input = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		System.out.println("Please enter the Username associated with the account you would like to modify:");
		String desiredAccount = input.nextLine();
		Customer retrievedAccount = customerService.findCustomerByUserName(desiredAccount);
		if (retrievedAccount == null) {
			System.out.println("\nUsername does not exist.");
		} else {
			System.out.println("\nUser found:");
			System.out.println("\nName: " + retrievedAccount.getFirstName() + " " + retrievedAccount.getLastName() + "\nUsername: " 
				+ retrievedAccount.getUserName() + "\nPassword: " + retrievedAccount.getPassword() + "\nBottle Caps: " 
				+ retrievedAccount.getBottleCaps() + "\nSecondary Account: " + retrievedAccount.secondaryAccount 
				+ "\nSecondary Account Status: " + retrievedAccount.isSecondaryAccount + "\n ");			
			boolean isValid = true;
			while(isValid) {
				System.out.println("What would you like to modify about account " + retrievedAccount.getUserName() + "? \n");
				customerModificationOptions();
				int userSelection = AppUIFunctions.handleUserSelection(input);
				switch(userSelection) {
				case 1: 
					String firstNameOutput = null;
					while (firstNameOutput == null) {
						System.out.println("Enter your First Name:");
						String firstNameInput = input.nextLine();
						firstNameOutput = inputFirstName(firstNameInput);
					}
					customerService.changeAccountDetails(retrievedAccount, "first_name", firstNameOutput);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s first name changed to " + firstNameOutput + ".");
					isValid = false;
					break;
				case 2: 
					String lastNameOutput = null;
					while (lastNameOutput == null) {
						System.out.println("Enter your First Name:");
						String lastNameInput = input.nextLine();
						lastNameOutput = inputFirstName(lastNameInput);
					}					customerService.changeAccountDetails(retrievedAccount, "last_name", lastNameOutput);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s last name changed to " + lastNameOutput + ".");
					isValid = false;
					break;
				case 3: 
					String userNameOutput = null;
					while (userNameOutput == null) {
						System.out.println("Please enter a Username:");
						String userNameInput = input.nextLine();
						userNameOutput = inputUserName(userNameInput);
					}
					customerService.changeAccountDetails(retrievedAccount, "user_name", userNameOutput);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s Username changed to " + userNameOutput + ".");
					isValid = false;
					break;
				case 4: 
					String passwordOutput = null;
					while (passwordOutput == null) {
						System.out.println("Please enter a Password:");
						String passwordInput = input.nextLine();
						passwordOutput = inputPassword(passwordInput);
					}
					customerService.changeAccountDetails(retrievedAccount, "user_password", passwordOutput);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s password changed to " + passwordOutput + ".");
					isValid = false;
					break;
				case 5: 
					System.out.println("Please enter a new bottlecap balance: ");
					int newAmount = AppUIFunctions.handleCurrencyAmmount(input);
					customerService.adminUpdateBottleCaps(retrievedAccount, newAmount);
					System.out.println("Account: " + retrievedAccount.getUserName() + "'s new bottle cap balance is: " + newAmount + ".");
					break;
				case 6: 
					if (retrievedAccount.secondaryAccount == null) {
						System.out.println("\nThere is no secondary account associated with user " + retrievedAccount.getUserName() + ".");
					} else {
						Customer secondaryCustomer = customerService.findCustomerByUserName(retrievedAccount.secondaryAccount);
						customerService.removeSecondaryCustomer(retrievedAccount);
						System.out.println("Secondary User Account " + secondaryCustomer.getUserName() + " has been removed from Primary "
								+ "account " + retrievedAccount.getUserName() + ".");
					}
					break;
				case 7:
					isValid = false;
					AppUIFunctions.backspace();
					break;
				default:
					AppUIFunctions.invalidInput();		
					
				}
			}
		}
	}
	
	
	
	
}