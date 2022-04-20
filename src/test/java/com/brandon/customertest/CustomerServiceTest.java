package com.brandon.customertest;

import java.util.HashSet; 
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.brandon.client.AppUIFunctions;
import com.brandon.repositories.CustomerRepository;
import com.brandon.service.CustomerService;
import com.brandon.users.Customer;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerService customerService; //object under test
	
	@Mock
	private CustomerRepository customerRepository;
	//Basic setup before running tests. Cant test the customerservice without an instance of it. 	
	
	private Set<Customer> mockCustomers;
	
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this); //tells Mockito to initalize mocks
		this.customerService = new CustomerService();
		this.mockCustomers = new HashSet<Customer>();
		this.mockCustomers.add(new Customer("Brandon", "Learned", "blearned", "pw", 530, "sniffer2010", false));
		this.mockCustomers.add(new Customer("Alexa", "Learned", "sniffer2010", "awoo", 20, null, true));
		this.mockCustomers.add(new Customer("David", "Bowie", "fashion80", "justdance!", 15000, null, false));
		this.mockCustomers.add(new Customer("Max", "Bemis", "maxattack", "isarealboy", 2750, null, false));
	}
	
	
	@Test
	public void firstNameInputTestProper() {
		String firstNameInput = "Brandon";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals("Brandon", firstNameOutput);
	}
	
	@Test
	public void firstNameInputTestRandomCasing() {
		String firstNameInput = "bRaNdoN";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals("Brandon", firstNameOutput);
	}
	
	@Test
	public void firstNameInputTestAllLower() {
		String firstNameInput = "brandon";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals("Brandon", firstNameOutput);
	}
	
	@Test
	public void firstNameInputTestBlank() {
		String firstNameInput = "";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals(null, firstNameOutput);
	}
	
	@Test
	public void firstNameInputTestTooManyCharacters() {
		String firstNameInput = "BrandonRobertLearnedTheGreat";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals(null, firstNameOutput);
	}
	
	@Test
	public void firstNameInputTestWithSpaces() {
		String firstNameInput = "Brandon  ";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals(null, firstNameOutput);
	}
		
	@Test
	public void firstNameInputTestWithNumbers() {
		String firstNameInput = "Brandon1";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals(null, firstNameOutput);
	}

	@Test
	public void firstNameInputTestWithSpecialCharacters() {
		String firstNameInput = "Brandon%#$";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals(null, firstNameOutput);
	}

	
	@Test
	public void lastNameInputTestProper() {
		String lastNameInput = "Learned";
		String lastNameOutput = AppUIFunctions.inputLastName(lastNameInput);
		Assertions.assertEquals("Learned", lastNameOutput);
	}
	
	@Test
	public void lastNameInputTestRandomCasing() {
		String firstNameInput = "lEaRnEd";
		String firstNameOutput = AppUIFunctions.inputFirstName(firstNameInput);
		Assertions.assertEquals("Learned", firstNameOutput);
	}
	
	@Test
	public void lastNameInputTestAllLower() {
		String lastNameInput = "learned";
		String lastNameOutput = AppUIFunctions.inputLastName(lastNameInput);
		Assertions.assertEquals("Learned", lastNameOutput);
	}
	
	@Test
	public void lastNameInputTestBlank() {
		String lastNameInput = "";
		String lastNameOutput = AppUIFunctions.inputLastName(lastNameInput);
		Assertions.assertEquals(null, lastNameOutput);
	}
	
	@Test
	public void lastNameInputTestTooManyCharacters() {
		String lastNameInput = "Learnedbutwithwaaaaaaaytoomanycharacters";
		String lastNameOutput = AppUIFunctions.inputLastName(lastNameInput);
		Assertions.assertEquals(null, lastNameOutput);
	}
	
	@Test
	public void lastNameInputTestWithSpaces() {
		String lastNameInput = "Learned      ";
		String lastNameOutput = AppUIFunctions.inputLastName(lastNameInput);
		Assertions.assertEquals(null, lastNameOutput);
	}
		
	@Test
	public void lastNameInputTestWithNumbers() {
		String lastNameInput = "Learned1234";
		String lastNameOutput = AppUIFunctions.inputLastName(lastNameInput);
		Assertions.assertEquals(null, lastNameOutput);
	}

	@Test
	public void lastNameInputTestWithSpecialCharacters() {
		String lastNameInput = "Learned#@%^";
		String lastNameOutput = AppUIFunctions.inputLastName(lastNameInput);
		Assertions.assertEquals(null, lastNameOutput);
	}
	
	@Test
	public void userNameInputTestLettersAndNumbers() {
		String userNameInput = "Blearned92";
		String userNameOutput = AppUIFunctions.inputUserName(userNameInput);
		Assertions.assertEquals("blearned92", userNameOutput);
	}
	
	@Test
	public void userNameInputTestJustNumbers() {
		String userNameInput = "57432888";
		String userNameOutput = AppUIFunctions.inputUserName(userNameInput);
		Assertions.assertEquals("57432888", userNameOutput);
	}
	
	@Test
	public void userNameInputTestJustLetters() {
		String userNameInput = "blearned";
		String userNameOutput = AppUIFunctions.inputUserName(userNameInput);
		Assertions.assertEquals("blearned", userNameOutput);
	}
	
	@Test
	public void userNameInputTestOddCasing() {
		String userNameInput = "bLeArNeD92";
		String userNameOutput = AppUIFunctions.inputUserName(userNameInput);
		Assertions.assertEquals("blearned92", userNameOutput);
	}
	
	@Test
	public void userNameInputTestWithSpaces() {
		String userNameInput = "blear ned92";
		String userNameOutput = AppUIFunctions.inputUserName(userNameInput);
		Assertions.assertEquals(null, userNameOutput);
	}
	
	@Test
	public void userNameInputTestTooShort() {
		String userNameInput = "blear";
		String userNameOutput = AppUIFunctions.inputUserName(userNameInput);
		Assertions.assertEquals(null, userNameOutput);
	}
	
	@Test
	public void userNameInputTestTooShortWithNumbers() {
		String userNameInput = "12345";
		String userNameOutput = AppUIFunctions.inputUserName(userNameInput);
		Assertions.assertEquals(null, userNameOutput);
	}
	
	@Test
	public void userNameInputTestBlank() {
		String userNameInput = "";
		String userNameOutput = AppUIFunctions.inputUserName(userNameInput);
		Assertions.assertEquals(null, userNameOutput);
	}
	
	@Test
	public void passwordInputTestBlank() {
		String passwordInput = "";
		String passwordOutput = AppUIFunctions.inputPassword(passwordInput);
		Assertions.assertEquals(null, passwordOutput);
	}
	
	@Test
	public void passwordInputTestTooShort() {
		String passwordInput = "pw";
		String passwordOutput = AppUIFunctions.inputPassword(passwordInput);
		Assertions.assertEquals(null, passwordOutput);
	}
	
	@Test
	public void passwordInputTestTooLong() {
		String passwordInput = "passwordpasswordpassword";
		String passwordOutput = AppUIFunctions.inputPassword(passwordInput);
		Assertions.assertEquals(null, passwordOutput);
	}
	
	@Test
	public void passwordInputTestWithNumbers() {
		String passwordInput = "password21";
		String passwordOutput = AppUIFunctions.inputPassword(passwordInput);
		Assertions.assertEquals("password21", passwordOutput);
	}
	
	@Test
	public void passwordInputTestOddCasing() {
		String passwordInput = "pAsSwOrD21";
		String passwordOutput = AppUIFunctions.inputPassword(passwordInput);
		Assertions.assertEquals("pAsSwOrD21", passwordOutput);
	}
	
	@Test
	public void passwordInputTestWithSpaces() {
		String passwordInput = "password21    ";
		String passwordOutput = AppUIFunctions.inputPassword(passwordInput);
		Assertions.assertEquals(null, passwordOutput);
	}
	
}
