package com.agilan.learn;

/*
 * JUnit Testing of the Backend for the Ticket Selling Service
 *
 * @author  Agilan Ampigaipathar
 * @version 1.0
 * @since   2019-03-19
 */

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class AccountTest {
	
	public Account AccountTesting;
	private static final String userNameTest = "Bob            ";
	private static final String userTypeTest = "AA";
	private static final float creditTest = 342.56f;
	
	@Before
	public void setUp() throws Exception {
		// Call default constructor 
		AccountTesting = new Account();
	}

	@Test
	public void testSetGetUsername() {
		// Call Account constructor with sample values
		AccountTesting = new Account("Billy          ", "FS", 34.34f);
		// Make sure username is not null
		assertNotNull(AccountTesting.getUsername());
		String capturedUsername = AccountTesting.getUsername();
		System.out.println(capturedUsername);
		// Set new username
		AccountTesting.setUsername(userNameTest);
		
		System.out.println(AccountTesting.getUsername());
		//Make sure the user name received from getter matches the one given in the setter 
		assertEquals(AccountTesting.getUsername(), userNameTest);
	}
	
	@Test
	public void testSetGetUserType() {
		// Call Account constructor with sample values
		AccountTesting = new Account("Jack           ", "BS", 24.14f);
		assertNotNull(AccountTesting.getUserType());
		String capturedUserType = AccountTesting.getUserType();
		System.out.println(capturedUserType);
		// Set new user type
		AccountTesting.setUserType(userTypeTest);
		
		System.out.println(AccountTesting.getUserType());
		//Make sure the user type received from getter matches the one given in the setter 
		assertEquals(AccountTesting.getUserType(), userTypeTest);
	}
	
	@Test
	public void testSetGetCredit() {
		// Call Account constructor with sample values
		AccountTesting = new Account("Adam           ", "SS", 12.12f);
		assertNotNull(AccountTesting.getCredit());
		float capturedCredit = AccountTesting.getCredit();
		System.out.println(capturedCredit);
		// Set new user credit
		AccountTesting.setCredit(creditTest);
		
		System.out.println(AccountTesting.getCredit());
		//Make sure the credit received from getter matches the one given in the setter 
		assertEquals(AccountTesting.getCredit(), creditTest, 0.0f);
	}

}
