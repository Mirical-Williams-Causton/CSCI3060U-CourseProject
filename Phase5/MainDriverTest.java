
import static org.junit.Assert.*;
import java.io.*;

public class MainDriverTest {

    @org.junit.Test
    public void readAvailableTicketFile() {
        String[] args = new String[]{"available_ticketfile.tra"};
        MainDriver mainDriver = new MainDriver(args);
        assertEquals(args.length,1);

    }

    @org.junit.Test
    public void readCurrentUserAccountFile() {
        String[] args = new String[]{"current_useraccount.cua"};
        MainDriver mainDriver = new MainDriver(args);
        assertEquals(args.length,1);
    }

    @org.junit.Test
    public void readDailyTransactionFile() {
        String[] args = new String[]{"daily_transaction_file.tra"};
        MainDriver mainDriver = new MainDriver(args);
        assertEquals(args.length,1);
    }
}