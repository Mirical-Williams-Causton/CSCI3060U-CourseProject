import java.util.*;
import java.io.*;

/*
 * Backend of the Ticket Selling Service
 *
 * @author  Mirical Williams-Causton
 * @version 1.0
 * @since   2019-03-16
 */

public class MainDriver {
	public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public static ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static ArrayList<Transaction> createTransactions = new ArrayList<Transaction>();
	public static ArrayList<Transaction> buyTransactions = new ArrayList<Transaction>();
	public static ArrayList<Transaction> deleteTransactions = new ArrayList<Transaction>();
	public static ArrayList<Transaction> refundTransactions = new ArrayList<Transaction>();
	public static ArrayList<Transaction> addCreditTransactions = new ArrayList<Transaction>();
	public static ArrayList<Transaction> sellTransactions = new ArrayList<Transaction>();

	/*
	 * The readAvailableTicketFile function reads the events and corresponding
	 * seller username, numbers of tickets, and ticket price from the available
	 * tickets file and stores it in an arraylist.
	 * 
	 * @param	filename	The first parameter of the readAvailableTicketFile method
	 * @return 				Nothing
	 */
	public static void readAvailableTicketFile(String filename) {
		String line = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			while ((line = bufferedReader.readLine()) != null) {
				String event_title = line.substring(0, 25);
				String seller_username = line.substring(26, 39);
				int number_tickets = Integer.parseInt(line.substring(40, 43));
				float ticket_price = Float.parseFloat(line.substring(44, 50));
				tickets.add(new Ticket(event_title, seller_username, number_tickets, ticket_price));
			} bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The readCurrentUserAccountFile function reads the user accounts from the
	 * current user accounts file and stores it in an arraylist.
	 *
	 * @param 	filename 	The first parameter of the readCurrentUserAccountFile method
	 * @return 				Nothing
	 */
	public static void readCurrentUserAccountFile(String filename) {
		String line = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			while ((line = bufferedReader.readLine()) != null) {
				String username = line.substring(0, 15);
				String user_type = line.substring(16, 18);
				float user_credit = Float.parseFloat(line.substring(19, 28));
				accounts.add(new Account(username, user_type, user_credit));
			} bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The readDailyTransactionFile function reads the daily transaction file and stores
	 * transactions, based on the transaction code, in their designated arraylist.
	 *
	 * @param 	filename	The first parameter of the readDailyTransactionFile method
	 * @return 				Nothing
	 */
	public static void readDailyTransactionFile(String filename) {
		String line, username, user_type, event_title, seller_username, buyers_username = "";
		int number_tickets = 0;
		float user_credit, ticket_price = 0.0f;
		double refund_credit = 0.0;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			while ((line = bufferedReader.readLine()) != null) {
				if (line.startsWith("01")) {
					username = line.substring(3, 18);
					user_type = line.substring(19, 21);
					user_credit = Float.parseFloat(line.substring(22, 31));
					createTransactions.add(new Transaction(username, user_type, user_credit));
				} else if (line.startsWith("02")) {
					username = line.substring(3, 18);
					user_type = line.substring(19, 21);
					user_credit = Float.parseFloat(line.substring(22, 31));
					deleteTransactions.add(new Transaction(username, user_type, user_credit));
				} else if (line.startsWith("03")) {
					event_title = line.substring(3, 28);
					seller_username = line.substring(29, 42);
					number_tickets = Integer.parseInt(line.substring(43, 46));
					ticket_price = Float.parseFloat(line.substring(47, 53));
					sellTransactions.add(new Transaction(event_title, seller_username, number_tickets, ticket_price));
				} else if (line.startsWith("04")) {
					event_title = line.substring(3, 28);
					seller_username = line.substring(29, 42);
					number_tickets = Integer.parseInt(line.substring(43, 46));
					ticket_price = Float.parseFloat(line.substring(47, 53));
					buyTransactions.add(new Transaction(event_title, seller_username, number_tickets, ticket_price));
				} else if (line.startsWith("05")) {
					buyers_username = line.substring(3, 18);
					seller_username = line.substring(19, 34);
					refund_credit = Float.parseFloat(line.substring(35, 44));
					refundTransactions.add(new Transaction(buyers_username, seller_username, refund_credit));
				} else if (line.startsWith("06")) {
					if (line.contains("NA")) {
						continue;
					}
					username = line.substring(3, 18);
					user_type = line.substring(19, 21);
					user_credit = Float.parseFloat(line.substring(22, 31));
					addCreditTransactions.add(new Transaction(username, user_type, user_credit));
				}
			} bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The main function sends the available ticket file, current user account file, and
	 * daily transaction file to the their specific functions to retrieve their contents and
	 * start the backend of the ticket selling service.
	 * 
	 * @return 		Nothing
	 */
	public static void main(String[] args) {
		readAvailableTicketFile("available_ticketfile.tra");
		readCurrentUserAccountFile("current_useraccount_file.cua");
		readDailyTransactionFile("daily_transaction_file.tra");

		UpdateManager updateManager = new UpdateManager();

		//updateManager.buy(buyTransactions, tickets); // - Do not uncomment until testing, this function is complete
		//updateManager.addCredit(addCreditTransactions, accounts); // - Do not uncomment until testing, this function is complete
		//updateManager.deleteUser(deleteTransactions, accounts); // - Do not uncomment until testing, this function is complete
		//updateManager.refund(refundTransactions, accounts); // - Do not uncomment until testing, this function is complete
		//updateManager.createUser(createTransactions, accounts); // Do not uncomment until testing, this function is complete
		//updateManager.sellTicket(sellTransactions, tickets); // Do not uncomment until testing, this function is complete
	}
}