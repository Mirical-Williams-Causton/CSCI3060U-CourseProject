/*
 * Backend of the Ticket Selling Service
 *
 * @author  Mirical Williams-Causton
 * @version 1.0
 * @since   2019-03-16
 */

public class Ticket {
	String event_title, seller_username;
	int number_tickets;
	float ticket_price;

	/*
	 * The Ticket default constructor
	 *
	 * @return 						Nothing
	 */
	Ticket() { }

	/*
	 * The Ticket constructor
	 *
	 * @param 	event_title 		The first parameter of the Ticket constructor
	 * @param 	seller_username		The second parameter of the Ticket constructor
	 * @param 	number_tickets 		The third parameter of the Ticket constructor
	 * @param 	ticket_price 		The fourth parameter of the Ticket constructor
	 * @return 						Nothing
	 */
	Ticket(String event_title, String seller_username, int number_tickets, float ticket_price) {
		this.event_title = event_title;
		this.seller_username = seller_username;
		this.number_tickets = number_tickets;
		this.ticket_price = ticket_price;
	}

	/*
	 * The getEventTitle function gets the event title.
	 *
	 * @return 						The event title
	 */
	String getEventTitle() { return this.event_title; }

	/*
	 * The getSellerUsername function gets the sellers username.
	 *
	 * @return 						The sellers username
	 */
	String getSellerUsername() { return this.seller_username; }

	/*
	 * The getNumberTickets function gets the number of tickets for an event.
	 *
	 * @return 						The number of tickets for an event
	 */
	int getNumberTickets() { return this.number_tickets; }

	/*
	 * The getTicketPrice function gets the ticket price for an event.
	 *
	 * @return 						The cost of an individual ticket for an event.
	 */
	float getTicketPrice() { return this.ticket_price; }

	/*
	 * The setEventTitle function sets the event title.
	 *
	 * @param 	event_title 		The first parameter of the setEventTitle method.
	 * @return 						Nothing
	 */
	void setEventTitle(String event_title) { this.event_title = event_title; }

	/*
	 * The setSellerUsername function sets the sellers username.
	 *
	 * @param 	seller_username		The first parameter of the setSellerUsername method.
	 * @return 						Nothing
	 */
	void setSellerUsername(String seller_username) { this.seller_username = seller_username; }

	/*
	 * The setNumberTickets function sets the number of tickets for an event.
	 *
	 * @param 	number_tickets 		The first parameter of the setNumberTickets method.
	 * @return 						Nothing
	 */
	void setNumberTickets(int number_tickets) { this.number_tickets = number_tickets; }

	/*
	 * The setTicketPrice function sets the ticket price for an event.
	 *
	 * @param 	ticket_price 		The first parameter of the setTicketPrice method.
	 * @return 						Nothing
	 */
	void setTicketPrice(float ticket_price) { this.ticket_price = ticket_price; }
}