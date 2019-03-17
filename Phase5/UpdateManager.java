import java.util.*;
import java.io.*;
import java.text.*;

/*
 * Backend of the Ticket Selling Service
 *
 * @author  Mirical Williams-Causton
 * @version 1.0
 * @since   2019-03-16
 */

public class UpdateManager {
	public static void createUser() {
		// TODO: Complete - Add user to current users file
	}

	public static void sellTicket() {
		// TODO: Complete - Add event to available ticket file
	}

	public static void deleteUser() {
		// TODO: Complete - Delete user from current users file
	}

	public static void addCredit() {
		// TODO: Complete - Add credit onto a specific user in the current users account file
		//				  - Subtract from user who added credit in the current users acount file
	}

	public static void refund() {
		// TODO: Complete - Refund credit from seller to buyer, update credit amounts in current users account file
	}

	/*
	 * The buy function crossmatches each buy transaction event title with the corresponding event title in the
	 * available tickets file and updates the number of tickets available for that event. No negative ticket are allowed by
	 * the system. If buy transaction produces a negative ticket amount, it skips over it and produces an error. After all
	 * available tickets have been updated, the new available ticket file is written.
	 *  
	 * @param 		buyTransactions 		The first parameter of the buy method.
	 * @param 		tickets 				The second parameter of the buy method.
	 * @return 								Nothing
	 */
	public static void buy(ArrayList<Transaction> buyTransactions, ArrayList<Ticket> tickets) {
		ArrayList<Transaction> transactions = buyTransactions;
		ArrayList<Ticket> availableTickets = tickets;
		int available_tickets, number_tickets, tickets_purchased;
		String event_title;

		for (Transaction transaction : buyTransactions) {
			event_title = transaction.getEventTitle();
			tickets_purchased = transaction.getNumberTickets();
			for (Ticket ticket : availableTickets) {
				if (event_title.equals(ticket.getEventTitle())) {
					number_tickets = ticket.getNumberTickets();
					available_tickets = number_tickets - tickets_purchased;
					if (available_tickets < 0) {
						System.out.println("Error: You cannot have a negative available ticket amount.");
						continue;
					} else {
						ticket.setNumberTickets(available_tickets);
					}
				}
			}
		}

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("available_ticketfile.tra"));

			NumberFormat money_format = new DecimalFormat("#000.00");
			
			for (Ticket ticket : availableTickets) {
				bufferedWriter.write(ticket.getEventTitle() + ticket.getSellerUsername() + 
					String.format("%03d", ticket.getNumberTickets()) + " " + money_format.format(ticket.getTicketPrice()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}