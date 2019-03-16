public class Ticket {
	String event_title, seller_username;
	int number_tickets;
	float ticket_price;

	Ticket() { }

	Ticket(String event_title, String seller_username, int number_tickets, float ticket_price) {
		this.event_title = event_title;
		this.seller_username = seller_username;
		this.number_tickets = number_tickets;
		this.ticket_price = ticket_price;
	}

	String getEventTitle() { return this.event_title; }
	String getSellerUsername() { return this.seller_username; }
	int getNumberTickets() { return this.number_tickets; }
	float getTicketPrice() { return this.ticket_price; }

	void setEventTitle(String event_title) { this.event_title = event_title; }
	void setSellerUsername(String seller_username) { this.seller_username = seller_username; }
	void setNumberTickets(int number_tickets) { this.number_tickets = number_tickets; }
	void setTicketPrice(float ticket_price) { this.ticket_price = ticket_price; }
}