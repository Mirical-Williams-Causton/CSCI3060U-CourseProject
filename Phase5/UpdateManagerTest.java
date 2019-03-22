import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class UpdateManagerTest {

    //@Before
    ArrayList<Account> accounts = new ArrayList<Account>();
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public void initialAccounts(){
        accounts.add(new Account("USER01", "AA", 100.00f));
        accounts.add(new Account("USER02", "BS", 1200.39f));
        accounts.add(new Account("USER03", "FS", 90.00f));
        accounts.add(new Account("USER04", "SS", 10000.09f));
    };

    public void initialTickets() {
        tickets.add(new Ticket("Celine Dion Show", "USER04", 100, 120.09f));
        tickets.add(new Ticket("Dumbo", "USER05", 0, 10.10f));
    };

    //create() tests
    @org.junit.Test
    public void createUser() {
            ArrayList<Transaction> users = new ArrayList<Transaction>();
            users.add(new Transaction("USER01", "AA", 100.00f));
            for (Transaction transaction : users) {
                for (Account account : accounts) {
                    assertTrue(account.getUsername() == transaction.getUsername());
                }
            }
    }

    @org.junit.Test
    public void createUserExisted() {
        ArrayList<Transaction> users = new ArrayList<Transaction>();
        users.add(new Transaction("USER08", "AA", 100.00f));
        for (Transaction transaction : users) {
            for (Account account : accounts) {
                assertTrue(account.getUsername() == transaction.getUsername());
            }
        }
    }

    @org.junit.Test
    public void userAdded() {
        ArrayList<Transaction> users = new ArrayList<Transaction>();
        users.add(new Transaction("USER08", "AA", 100.00f));
        for (Transaction transaction : users) {
            for (Account account : accounts) {
                assertTrue(account.getUsername() == transaction.getUsername());
            }
        }
    }

    @org.junit.Test
    public void sellTicket() {
        ArrayList<Transaction> newTicket = new ArrayList<Transaction>();
        newTicket.add(new Transaction("Dumbo", "USER05", 0, 10.10f));
        for (Transaction transaction : newTicket) {
            for (Ticket ticket : tickets) {
                assertTrue(transaction.getEventTitle() == ticket.getEventTitle() && transaction.getSellerUsername() == ticket.getSellerUsername());
            }
        }

    }


    @org.junit.Test
    public void userDeleted() {
        accounts.remove("USER01");
        for (Account account : accounts) {
            assertTrue(account.getUsername() == "USER01");
        }
    }

    @org.junit.Test
    public void addCredit() {
        String username ="USER01";
        float added_credit = 20.00f;

        for (Account account: accounts) {
            if (username.equals(account.getUsername())) {
                float userCredit = account.getCredit() + added_credit;
                account.setCredit(userCredit);
                assertTrue(account.getCredit() == 120.0f);
            }
        }

    }

    @org.junit.Test
    public void creditRefunded() {
        String buyer_username = "USER02";
        String seller_username = "USER04";
        float refund_credit = 100.00f;

        for (Account account : accounts) {
            if (buyer_username.equals(account.getUsername())) {
                float buyer_available_credit = account.getCredit() + refund_credit;
                account.setCredit(buyer_available_credit);
                assertTrue(account.getCredit() == 1300.39f);
            } else if (seller_username.equals(account.getUsername())) {
                float seller_available_credit = account.getCredit() - refund_credit;
                account.setCredit(seller_available_credit);
                assertTrue(account.getCredit() == 9900.09f);
            }
        }
    }

    @org.junit.Test

    public void eventExists() {
        for (Ticket ticket : tickets) {
            assertTrue(ticket.getEventTitle() == "Celine Dion Show");
        }
    }

    @org.junit.Test
    public void updateTicketAmount() {
        int ticket_purchased = 9;
        for (Ticket ticket : tickets) {
            if (ticket.getEventTitle() == "Celine Dion Show") {
                ticket.setNumberTickets(ticket.getNumberTickets() - ticket_purchased);
                assertTrue(ticket.getNumberTickets() == 91);
            }
        }
    }

    @org.junit.Test
    public void negativeTicketAmount() {
        int ticket_purchased = 9;
        for (Ticket ticket : tickets) {
            if (ticket.getEventTitle() == "Dumbo") {
                ticket.setNumberTickets(ticket.getNumberTickets() - ticket_purchased);
                assertTrue(ticket.getNumberTickets() < 0);
            }
        }
    }
}