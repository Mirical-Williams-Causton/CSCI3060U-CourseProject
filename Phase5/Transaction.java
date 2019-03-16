/*
 * Backend of the Ticket Selling Service
 *
 * @author  Mirical Williams-Causton
 * @version 1.0
 * @since   2019-03-16
 */

public class Transaction {
	String username, user_type, event_title, seller_username, buyers_username;
	float user_credit, ticket_price;
	double refund_credit;
	int number_tickets;

	/*
	 * The Transaction default constructor
	 *
	 * @return 					Nothing
	 */
	Transaction() {}
	
	/*
	 * The Transaction constructor
	 *
	 * @param 	username 		The first parameter of the Transaction constructor
	 * @param 	user_type 		The second parameter of the Transaction constructor
	 * @param 	user_credit 	The third parameter of the Transaction constructor
	 * @return 					Nothing
	 */
	Transaction(String username, String user_type, float user_credit) {
		this.username = username;
		this.user_type = user_type;
		this.user_credit = user_credit;
	}

	/*
	 * The Transaction constructor
	 *
	 * @param 	event_title 		The first parameter of the Transaction constructor
	 * @param 	seller_username		The second parameter of the Transaction constructor
	 * @param 	number_tickets 		The third parameter of the Transaction constructor
	 * @param 	ticket_price 		The fourth parameter of the Transaction constructor
	 * @return 						Nothing
	 */
	Transaction(String event_title, String seller_username, int number_tickets, float ticket_price) {
		this.event_title = event_title;
		this.seller_username = seller_username;
		this.number_tickets = number_tickets;
		this.ticket_price = ticket_price;
	}

	/*
	 * The Transaction constructor
	 *
	 * @param 	buyers_username 	The first parameter of the Transaction constructor
	 * @param 	seller_username		The second parameter of the Transaction constructor
	 * @param 	refund_credit 		The third parameter of the Transaction constructor
	 * @return 						Nothing
	 */
	Transaction(String buyers_username, String seller_username, double refund_credit) {
		this.buyers_username = buyers_username;
		this.seller_username = seller_username;
		this.refund_credit = refund_credit;
	}

	/*
	 * The getUsername function gets the user's username.
	 *
	 * @return					The user's username.
	 */
	String getUsername() { return this.username; }

	/*
	 * The getUserType function gets the user's account type.
	 * 
	 * @return 					The user's account type
	 */
	String getUserType() { return this.user_type; }

	/*
	 * The getCredit function gets the user's available credit.
	 *
	 * @return 					The user's available credit
	 */
	float getCredit() { return this.user_credit; }

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
	 * The getBuyersUsername function gets the buyers username.
	 *
	 * @return 						The buyers username
	 */
	String getBuyersUsername() { return this.buyers_username; }

	/*
	 * The setUsername function sets the user's username.
	 *
	 * @param 	username 		The first parameter of the setUsername method
	 * @return 					Nothing
	 */
	void setUsername(String username) { this.username = username; }

	/*
	 * The setUserType function sets the user's account type.
	 *
	 * @param 	user_type 		The first parameter of the setUserType method
	 * @return 					Nothing
	 */
	void setUserType(String user_type) { this.user_type = user_type; }

	/*
	 * The setCredit function sets the user's available credit.
	 *
	 * @param 	user_credit 	The first parameter of the setCredit method
	 * @return 					Nothing
	 */
	void setCredit(float user_credit) { this.user_credit = user_credit; }

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

	/*
	 * The setBuyersUsername sets the buyers username.
	 * 
	 * @param 	buyers_username		The first parameter of the setBuyersUsername method.
	 * @return 						Nothing
	 */
	void setBuyersUsername(String buyers_username) { this.buyers_username = buyers_username; }
}