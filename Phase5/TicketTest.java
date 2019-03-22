//package com.agilan.learn;

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

public class TicketTest {
	
	public Ticket TicketTesting;
	private static final String eventTitleTest = "My Birthday        ";
	private static final String sellerNameTest = "Sam            ";
	private static final int numTicketsTest = 79;
	private static final float ticketPriceTest = 20.52f;
	
	@Before
	public void setUp() throws Exception {
		// Call default constructor 
		TicketTesting = new Ticket();
	}

	@Test
	public void testSetGetEventTitle() {
		// Call Ticket constructor with sample values
		TicketTesting = new Ticket("My Party           ", "Jim            ", 40, 34.56f);
		// Make sure event title is not null
		assertNotNull(TicketTesting.getEventTitle());
		String capturedEventTitle = TicketTesting.getEventTitle();
		System.out.println(capturedEventTitle);
		// Set new event title
		TicketTesting.setEventTitle(eventTitleTest);
		
		System.out.println(TicketTesting.getEventTitle());
		//Make sure the event title received from getter matches the one given in the setter 
		assertEquals(TicketTesting.getEventTitle(), eventTitleTest);
	}
	
	@Test
	public void testSetGetSellerName() {
		// Call Ticket constructor with sample values
		TicketTesting = new Ticket("Halloween          ", "Tim            ", 50, 54.56f);
		assertNotNull(TicketTesting.getSellerUsername());
		String capturedSellerUsername = TicketTesting.getSellerUsername();
		System.out.println(capturedSellerUsername);
		// Set new seller name
		TicketTesting.setSellerUsername(sellerNameTest);
		
		System.out.println(TicketTesting.getSellerUsername());
		//Make sure the seller name received from getter matches the one given in the setter 
		assertEquals(TicketTesting.getSellerUsername(), sellerNameTest);
	}
	
	@Test
	public void testSetGetNumTickets() {
		// Call Ticket constructor with sample values
		TicketTesting = new Ticket("Christmas          ", "Dale           ", 60, 74.56f);
		assertNotNull(TicketTesting.getNumberTickets());
		int capturedNumTickets = TicketTesting.getNumberTickets();
		System.out.println(capturedNumTickets);
		// Set new number of tickets
		TicketTesting.setNumberTickets(numTicketsTest);
		
		System.out.println(TicketTesting.getNumberTickets());
		//Make sure the number of tickets received from getter matches the one given in the setter 
		assertEquals(TicketTesting.getNumberTickets(), numTicketsTest);
	}
	
	@Test
	public void testSetGetTicketPrice() {
		// Call Ticket constructor with sample values
		TicketTesting = new Ticket("Coffee Day         ", "Bale           ", 62, 32.56f);
		assertNotNull(TicketTesting.getTicketPrice());
		float capturedTicketPrice = TicketTesting.getTicketPrice();
		System.out.println(capturedTicketPrice);
		// Set new ticket price
		TicketTesting.setTicketPrice(ticketPriceTest);
		
		System.out.println(TicketTesting.getTicketPrice());
		//Make sure the ticket price received from getter matches the one given in the setter 
		assertEquals(TicketTesting.getTicketPrice(), ticketPriceTest, 0.0f);
	}

}
