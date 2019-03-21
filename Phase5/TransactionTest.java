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

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class TransactionTest {
	
	public Transaction TransactionTesting;
	private static final String userNameTest = "Tam            ";
	private static final String userTypeTest = "FS";
	private static final float userCreditTest = 10.52f;
	
	private static final String eventTitleTest = "My Music Party     ";
	private static final String sellerNameTest = "Nim            ";
	private static final int numTicketsTest = 72;
	private static final float ticketPriceTest = 20.52f;
	
	private static final String buyerNameTest = "Gem            ";
	private static final String sellerNameTest2 = "Ram            ";
	private static final double refundCreditTest = 15.64;
	
	@Before
	public void setUp() throws Exception {
		// Call default constructor 
		TransactionTesting = new Transaction();
	}
	
	@Test
	public void testSetGetUserName() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("Jem            ", "FS", 34.56f);
		// Make sure username is not null
		assertNotNull(TransactionTesting.getUsername());
		String capturedUserName = TransactionTesting.getUsername();
		System.out.println(capturedUserName);
		// Set new username
		TransactionTesting.setUsername(userNameTest);
		
		System.out.println(TransactionTesting.getUsername());
		//Make sure the username received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getUsername(), userNameTest);
	}
	
	@Test
	public void testSetGetUserType() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("Jim            ", "SS", 24.56f);
		// Make sure user type is not null
		assertNotNull(TransactionTesting.getUserType());
		String capturedUserType = TransactionTesting.getUserType();
		System.out.println(capturedUserType);
		// Set new user type
		TransactionTesting.setUserType(userTypeTest);
		
		System.out.println(TransactionTesting.getUserType());
		//Make sure the user type received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getUserType(), userTypeTest);
	}
	
	@Test
	public void testSetGetUserCredit() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("Sid            ", "AA", 12.56f);
		// Make sure user credit is not null
		assertNotNull(TransactionTesting.getCredit());
		float capturedCredit = TransactionTesting.getCredit();
		System.out.println(capturedCredit);
		// Set new user credit
		TransactionTesting.setCredit(userCreditTest);
		
		System.out.println(TransactionTesting.getCredit());
		//Make sure the user credit received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getCredit(), userCreditTest, 0.0f);
	}

	@Test
	public void testSetGetEventTitle() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("My Party           ", "Jim            ", 40, 34.56f);
		// Make sure event title is not null
		assertNotNull(TransactionTesting.getEventTitle());
		String capturedEventTitle = TransactionTesting.getEventTitle();
		System.out.println(capturedEventTitle);
		// Set new event title
		TransactionTesting.setEventTitle(eventTitleTest);
		
		System.out.println(TransactionTesting.getEventTitle());
		//Make sure the event title received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getEventTitle(), eventTitleTest);
	}
	
	@Test
	public void testSetGetSellerName() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("Halloween          ", "Tim            ", 50, 54.56f);
		assertNotNull(TransactionTesting.getSellerUsername());
		String capturedSellerUsername = TransactionTesting.getSellerUsername();
		System.out.println(capturedSellerUsername);
		// Set new seller name
		TransactionTesting.setSellerUsername(sellerNameTest);
		
		System.out.println(TransactionTesting.getSellerUsername());
		//Make sure the seller name received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getSellerUsername(), sellerNameTest);
	}
	
	@Test
	public void testSetGetNumTickets() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("My House Party     ", "Dale           ", 60, 74.56f);
		assertNotNull(TransactionTesting.getNumberTickets());
		int capturedNumTickets = TransactionTesting.getNumberTickets();
		System.out.println(capturedNumTickets);
		// Set new number of tickets
		TransactionTesting.setNumberTickets(numTicketsTest);
		
		System.out.println(TransactionTesting.getNumberTickets());
		//Make sure the number of tickets received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getNumberTickets(), numTicketsTest);
	}
	
	@Test
	public void testSetGetTicketPrice() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("Coffee Day         ", "Bale           ", 62, 32.56f);
		assertNotNull(TransactionTesting.getTicketPrice());
		float capturedTicketPrice = TransactionTesting.getTicketPrice();
		System.out.println(capturedTicketPrice);
		// Set new ticket price
		TransactionTesting.setTicketPrice(ticketPriceTest);
		
		System.out.println(TransactionTesting.getTicketPrice());
		//Make sure the ticket price received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getTicketPrice(), ticketPriceTest, 0.0f);
	}
	
	@Test
	public void testSetGetBuyerUserName() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("Jem            ", "Bale           ", 4.56);
		// Make sure buyer username is not null
		assertNotNull(TransactionTesting.getBuyersUsername());
		String capturedBuyersUserName = TransactionTesting.getBuyersUsername();
		System.out.println(capturedBuyersUserName);
		// Set new buyer username
		TransactionTesting.setBuyersUsername(buyerNameTest);
		
		System.out.println(TransactionTesting.getBuyersUsername());
		//Make sure the buyer username received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getBuyersUsername(), buyerNameTest);
	}
	
	@Test
	public void testSetGetSellerUserType() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("Jim            ", "Jem            ", 24.56);
		// Make sure seller username is not null
		assertNotNull(TransactionTesting.getSellerUsername());
		String capturedSellerUserName = TransactionTesting.getSellerUsername();
		System.out.println(capturedSellerUserName);
		// Set new seller username
		TransactionTesting.setSellerUsername(sellerNameTest2);
		
		System.out.println(TransactionTesting.getSellerUsername());
		//Make sure the seller username received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getSellerUsername(), sellerNameTest2);
	}
	
	@Test
	public void testSetGetRefundCredit() {
		// Call Transaction constructor with sample values
		TransactionTesting = new Transaction("Sid            ", "Jim            ", 17.53);
		// Make sure refund credit is not null
		assertNotNull(TransactionTesting.getRefundCredit());
		double capturedRefundCredit = TransactionTesting.getRefundCredit();
		System.out.println(capturedRefundCredit);
		// Set new refund credit
		TransactionTesting.setRefundCredit(refundCreditTest);
		
		System.out.println(TransactionTesting.getRefundCredit());
		//Make sure the refund credit received from getter matches the one given in the setter 
		assertEquals(TransactionTesting.getRefundCredit(), refundCreditTest, 0.0);
	}

}
