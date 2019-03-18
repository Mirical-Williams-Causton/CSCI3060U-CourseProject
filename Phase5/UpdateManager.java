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
	public static void createUser(ArrayList<Transaction> createTransactions, ArrayList<Account> accounts) {
		// TODO: Complete - Add new users to the current user account file
		// 				  - Check if user exists
	}

	public static void sellTicket(ArrayList<Transaction> sellTransactions, ArrayList<Ticket> tickets) {
		// TODO: Complete - Add event to available ticket file
	}

	public static void deleteUser(ArrayList<Transaction> deleteTransactions, ArrayList<Account> accounts) {
		// TODO: Complete - Delete user from current users file
	}

	/*
	 * The addCredit function crossmatches each username from the add credit transaction with the corresponding
	 * username in the current user account file and updates the available credit amount. After all user
	 * accounts have been updated, the new user accounts file is written.
	 *
	 * @param 		addCreditTransactions 		The first parameter of the addCredit method
	 * @param 		accounts 					The second parameter of the addCredit method
	 * @return 									Nothing
	 */
	public static void addCredit(ArrayList<Transaction> addCreditTransactions, ArrayList<Account> accounts) {
		String username;
		float user_credit; 

		for (Transaction transaction : addCreditTransactions) {
			username = transaction.getUsername();
			user_credit = transaction.getCredit();
			for (Account account : accounts) {
				if (username.trim().equals((account.getUsername()).trim())) {
					account.setCredit(user_credit);
				}
			}
		}

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("current_useraccount_file.cua"));

			NumberFormat money_format = new DecimalFormat("#000000.00");

			for (Account account : accounts) {
				bufferedWriter.write(account.getUsername() + account.getUserType() + " " + 
					money_format.format(account.getCredit()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void refund(ArrayList<Transaction> refundTransactions, ArrayList<Account> accounts) {
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
		int available_tickets, number_tickets, tickets_purchased;
		String event_title;

		for (Transaction transaction : buyTransactions) {
			event_title = transaction.getEventTitle();
			tickets_purchased = transaction.getNumberTickets();
			for (Ticket ticket : tickets) {
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
			
			for (Ticket ticket : tickets) {
				bufferedWriter.write(ticket.getEventTitle() + ticket.getSellerUsername() + 
					String.format("%03d", ticket.getNumberTickets()) + " " + money_format.format(ticket.getTicketPrice()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}