import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class UpdateManagerTest {

    @org.junit.Test
    public void createUser() {
        String[] userName= {"Buyer05        "};
        String[] user_type = {"BS"};
        String[] user_credit = {"0000000.00"};
        ArrayList<Transaction> createTransactions = UpdateManager.createUser();
        ArrayList<Transaction> create = new ArrayList<>();
        create.add(userName, user_type, user_credit);
        assertEquals(createTransactions.toArray(),create.toArray());

    }

    @org.junit.Test
    public void sellTicket() {
        String[] event_title = {"Concert                   "};
        String[] seller_userName = {"Admin01       "};
        String[] number_tickets = {"100"};
        String[] ticket_price = {"045.00"};
        ArrayList<Transaction> sellTransactions = UpdateManager.sellTicket();
        ArrayList<Transaction> sell = new ArrayList<>();
        sell.add(event_title, seller_userName,number_tickets,ticket_price);
        assertEquals(sellTransactions.toArray(),sell.toArray());
    }

    @org.junit.Test
    public void deleteUser() {
        String[] userName = {"Buyer05        "};
        ArrayList<Transaction> deleteTransactions = UpdateManager.deleteUser();
        ArrayList<Transaction> delete = new ArrayList<>();
        delete.add(userName);
        assertEquals(deleteTransactions.toArray(),delete.toArray());
    }

    @org.junit.Test
    public void addCredit() {
        String[] userName = {"UserExist      "};
        String[] userCredit = {"0000020.00"};
        ArrayList<Transaction> addCreditTransactions = UpdateManager.addCredit();
        ArrayList<Transaction> addCredit = new ArrayList<>();
        addCredit.add(userName, userCredit);
        assertEquals(addCreditTransactions.toArray(),addCredit.toArray());
    }

    @org.junit.Test
    public void refund() {
        String[] buyerName = {"User01         "};
        String[] sellerName= {"Seller01       "};
        String[] refundCredit= {"0000020.00"};
        ArrayList<Transaction> refundTransactions = UpdateManager.refund();
        ArrayList<Transaction> refund = new ArrayList<>();
        refund.add(buyerName, sellerName, refundCredit);
        assertEquals(refundTransactions.toArray(),refund.toArray());
    }

    // with invalid credit
    @org.junit.Test
    public void refund() {
        String[] buyerName = {"User01         "};
        String[] sellerName= {"Seller01       "};
        String[] refundCredit= {"0000000.00"};
        ArrayList<Transaction> refundTransactions = UpdateManager.refund();
        ArrayList<Transaction> refund = new ArrayList<>();
        refund.add(buyerName, sellerName, refundCredit);
        assertEquals(refundTransactions.toArray(),refund.toArray());
    }


    @org.junit.Test
    public void buy() {
        String[] eventTitle = {"opera                     "};
        String[] ticketsPusrchased = {"001"};
        ArrayList<Transaction> buyTransactions = UpdateManager.buy();
        ArrayList<Transaction> buy = new ArrayList<>();
        buy.add(eventTitle, ticketsPusrchased);
        assertEquals(buyTransactions.toArray(),buy.toArray());
    }
    // with invalid ticketpurchase number
    @org.junit.Test
    public void buy1() {
        String[] eventTitle = {"opera                     "};
        String[] ticketsPusrchased = {"000"};
        ArrayList<Transaction> buyTransactions = UpdateManager.buy();
        ArrayList<Transaction> buy = new ArrayList<>();
        buy.add(eventTitle, ticketsPusrchased);
        assertEquals(buyTransactions.toArray(),buy.toArray());
    }
}