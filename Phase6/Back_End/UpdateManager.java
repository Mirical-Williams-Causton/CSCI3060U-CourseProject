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
	/*
	 * The createUser function crossmatches each username from the create transactions with the corresponding
	 * username in the current user account file. If the username to be added exists in the users account
	 * file, it is not added and produces an error. Otherwise, all new accounts are added to the user accounts file.
	 * 
	 * @param 		createTransactions 			The first parameter of the createUser method.
	 * @param 		accounts 					The second parameter of the createUser method.
	 * @return 									Nothing
	 */
	public static void createUser(ArrayList<Transaction> createTransactions, ArrayList<Account> accounts) {
		String username, user_type;
		float user_credit;
		boolean found = false;

		ArrayList<Account> users = accounts;

		for (Transaction transaction : createTransactions) {
			username = transaction.getUsername();
			user_type = transaction.getUserType();
			user_credit = transaction.getCredit();
			for (Account account : accounts) {
				if (username.equals(account.getUsername())) {
					System.out.println("Error: Username has to be unique.");
					found = true;
					break;
				} else {
					found = false;
				}
			}
			if (found == false) {
				users.add(new Account(username, user_type, user_credit));
			}
		}

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("../current_useraccount_file.cua"));

			NumberFormat money_format = new DecimalFormat("#000000.00");

			for (Account account : users) {
				bufferedWriter.write(account.getUsername() + " " + account.getUserType() + " " + 
					money_format.format(account.getCredit()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println("Error: File not found.");
			e.printStackTrace();
		}
	}

	/*
	 * The sellTicket function crossmatches the event title and seller username from the sell transactions with the
	 * event title and seller username in the available tickets file. If the seller username and event title match,
	 * an error is produced. Otherwise, the new event is added to the available tickets file.
	 *
	 * @param 		sellTransactions 			The first parameter of the sellTicket method.
	 * @param 		tickets 					The second parameter of the sellTicket method.
	 * @return 									Nothing
	 */
	public static void sellTicket(ArrayList<Transaction> sellTransactions, ArrayList<Ticket> tickets) {
		String seller_username, event_title;
		int number_tickets;
		float ticket_price;
		boolean found = false;

		for (Transaction transaction : sellTransactions) {
			event_title = transaction.getEventTitle();
			seller_username = transaction.getSellerUsername();
			number_tickets = transaction.getNumberTickets();
			ticket_price = transaction.getTicketPrice();
			for (Ticket ticket : tickets) {
				if (event_title.equals(ticket.getEventTitle()) && seller_username.equals(ticket.getSellerUsername())) {
					System.out.println("Error: Seller cannot have duplicate events.");
					found = true;
					break;
				} else {
					found = false;
				}
			}
			if (found == false) {
				tickets.add(new Ticket(event_title, seller_username, number_tickets, ticket_price));
			}
		}

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("../available_ticketfile.tra"));

			NumberFormat money_format = new DecimalFormat("#000.00");
			
			for (Ticket ticket : tickets) {
				bufferedWriter.write(ticket.getEventTitle() + " " + ticket.getSellerUsername() + " " + 
					String.format("%03d", ticket.getNumberTickets()) + " " + money_format.format(ticket.getTicketPrice()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println("Error: File not found.");
			e.printStackTrace();
		}
	}

	/*
	 * The deleteUser function crossmatches each username from the delete transactions with the corresponding
	 * username in the current user account file. If username to be deleted is found, the username, along with associated
	 * information, is deleted. After all deletions have been completed, the new user accounts file is written.
	 *
	 * @param 		deleteTransactions 			The first parameter of the deleteUser method.
	 * @param 		accounts 					The second parameter of the deleteUser method.
	 * @return 									Nothing.
	 */
	public static void deleteUser(ArrayList<Transaction> deleteTransactions, ArrayList<Account> accounts) {
		String username;
		Iterator<Account> iterator = accounts.iterator();
		boolean found = false;

		for (Transaction transaction : deleteTransactions) {
			username = transaction.getUsername();
			while(iterator.hasNext()) {
				Account account = iterator.next();
				if (username.equals(account.getUsername())) {
					found = true;
					break;
				} else {
					found = false;
				}
			}
			if (found == true) {
				iterator.remove();
			}
		}

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("../current_useraccount_file.cua"));

			NumberFormat money_format = new DecimalFormat("#000000.00");

			for (Account account : accounts) {
				bufferedWriter.write(account.getUsername() + " " + account.getUserType() + " " + 
					money_format.format(account.getCredit()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println("Error: File not found.");
			e.printStackTrace();
		}
	}

	/*
	 * The addCredit function crossmatches each username from the add credit transactions with the corresponding
	 * username in the current user account file and updates the available credit amount. After all user
	 * accounts have been updated, the new user accounts file is written.
	 *
	 * @param 		addCreditTransactions 		The first parameter of the addCredit method.
	 * @param 		accounts 					The second parameter of the addCredit method.
	 * @return 									Nothing
	 */
	public static void addCredit(ArrayList<Transaction> addCreditTransactions, ArrayList<Account> accounts) {
		String username;
		float user_credit; 

		for (Transaction transaction : addCreditTransactions) {
			username = transaction.getUsername();
			user_credit = transaction.getCredit();
			for (Account account : accounts) {
				if (username.equals(account.getUsername())) {
					account.setCredit(user_credit);
				}
			}
		}

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("../current_useraccount_file.cua"));

			NumberFormat money_format = new DecimalFormat("#000000.00");

			for (Account account : accounts) {
				bufferedWriter.write(account.getUsername() + " " + account.getUserType() + " " + 
					money_format.format(account.getCredit()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println("Error: File not found.");
			e.printStackTrace();
		}
	}

	/*
	 * The refund function crossmatches the seller username and buyer username from the refund transactions with the
	 * corresponding buyer username and seller username in the current user accounts files and updates the available
	 * credit amount. After all user accounts have been updated, the new user accounts file is written.
	 *
	 * @param 		refundTransactions 		The first parameter of the refund method.
	 * @param 		accounts 				The second parameter of the refund method.
	 * @return 								Nothing
	 */
	public static void refund(ArrayList<Transaction> refundTransactions, ArrayList<Account> accounts) {
		for (Transaction transaction : refundTransactions) {
			String buyer_username = transaction.getBuyersUsername();
			String seller_username = transaction.getSellerUsername();
			double refund_credit = transaction.getRefundCredit();

			for (Account account : accounts) {
				String user_name = account.getUsername();
				if (buyer_username.equals(user_name)) {
					float available_credit = account.getCredit() + (float) refund_credit;
					account.setCredit(available_credit);
				} else if (seller_username.equals(user_name)) {
					float available_credit = account.getCredit() - (float) refund_credit;
					account.setCredit(available_credit);
				}
			}
		}

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("../current_useraccount_file.cua"));

			NumberFormat money_format = new DecimalFormat("#000000.00");

			for (Account account : accounts) {
				bufferedWriter.write(account.getUsername() + " " + account.getUserType() + " " + 
					money_format.format(account.getCredit()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println("Error: File not found.");
			e.printStackTrace();
		}
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
						break;
					} else {
						ticket.setNumberTickets(available_tickets);
					}
				}
			}
		}

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("../available_ticketfile.tra"));

			NumberFormat money_format = new DecimalFormat("#000.00");
			
			for (Ticket ticket : tickets) {
				bufferedWriter.write(ticket.getEventTitle() + " " + ticket.getSellerUsername() + " " + 
					String.format("%03d", ticket.getNumberTickets()) + " " + money_format.format(ticket.getTicketPrice()) + "\n");
			}

			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println("Error: File not found.");
			e.printStackTrace();
		}
	}
}