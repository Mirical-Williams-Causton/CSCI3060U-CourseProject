import java.util.*;
import java.io.*;

public class MainDriver {
	public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	public static ArrayList<Account> accounts = new ArrayList<Account>();

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
				String event_title = line.substring(0, 19);
				String seller_username = line.substring(19, 33);
				int number_tickets = Integer.parseInt(line.substring(33, 36));
				float ticket_price = Float.parseFloat(line.substring(36, 43));
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
				String user_type = line.substring(15, 17);
				float user_credit = Float.parseFloat(line.substring(18, 27));
				accounts.add(new Account(username, user_type, user_credit));
			} bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readAvailableTicketFile("available_ticketfile.tra");
		readCurrentUserAccountFile("current_useraccount_file.cua");
		// TODO : Read from daily transaction file, Finish rest of main function
	}
}