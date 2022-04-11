package com.brandon.users;

public class User {
	
	//instance field. Has-a relationships
	public String firstName;
	public String lastName;
	protected String userName;
	protected String password;

	public User(String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	
	public static void main(String[] args) {
		User brandon = new User("Brandon", "Learned", "blearned92", "password111");
		System.out.println(brandon);
		//prints password111
	}
	


	//Add User methods here
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nUsername: " + userName + "\nPassword: "
				+ password;
	}




}

//
//public class SavingsAccount {
//	  
//	  int balance;
//	  
//	  public SavingsAccount(int initialBalance){
//	    balance = initialBalance;
//	  }
//
//	  public void checkBalance() {
//	      System.out.println("Hello!");
//	      System.out.println("Your balance is "+balance);
//	    }
//
//	  public void deposit(int amountToDeposit) {
//	    balance = balance + amountToDeposit;
//	    System.out.println("You just deposited " + amountToDeposit);
//	  }
//	  
//	  public int withdraw(int amountToWithdraw){
//	    balance = balance - amountToWithdraw;
//	    System.out.println("You just withdrew " + amountToWithdraw);
//	    return amountToWithdraw;
//	  }
//
//	  public static void main(String[] args){
//	    SavingsAccount savings = new SavingsAccount(2000);
//	   
//	    //Withdrawing:
//	    savings.checkBalance();
//	    savings.withdraw(450);
//	    savings.checkBalance();
//	    savings.deposit(450);
//	    savings.checkBalance();
//
//	    
//	    
//
//	  }       
//	}
