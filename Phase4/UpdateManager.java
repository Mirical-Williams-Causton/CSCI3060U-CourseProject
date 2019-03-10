import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.lang.*;
import java.util.Scanner;

/*
 * Back-End
 * Tickets and Accounts
 * This program is for Updating the Accounts and Tickets at the end of the day.
 * 
 * @author  Agilan Ampigaipathar, Mirical Williams-Causton
 * @version 1.0
 * @since   2019-03-10
 *
 */

public class UpdateManager {

  public static int lineCount = 0;

  /*
   * The fileReader function takes in a filename, either the current
   * users account file or the available tickets file.
   *
   * @param         filename            The first parameter of the fileReader method
   * @return        String              This returns the contents of the file
   * @exception     IOException         On file not found error
   * @see           IOException
   */
  public static String fileReader(String filename) throws IOException {
    Charset cs = StandardCharsets.UTF_8;
    StringBuilder stringBuffer = new StringBuilder();
    BufferedReader bf = null;
    Reader reader = new InputStreamReader(new FileInputStream(filename), cs);
    char[] buff = new char[500];

    for (int charsRead; (charsRead = reader.read(buff)) != -1; ) {
        stringBuffer.append(buff, 0, charsRead);
        // TODO: Complete
    }
    System.out.println(lineCount);
    System.out.println(stringBuffer);
    reader.close();
    
    // TODO: Complete

    String sampleContents = "";
    
    newEntries(sampleContents);

    return stringBuffer.toString();
  }

  /*
   * The newEntries function appends the new entries of the day to the history
   * files.
   * 
   * @param       appendContents        The first parameter of the newEntries method
   * @return                            Nothing
   */
  public static void newEntries(String appendContents) {
      // TO-DO
      // User Accounts Entry
      // Take substring of the appended contents for the username
      // Check if username already exists
      // Calls checkNewUser(String username) with the parameter being the substring

      // TO-DO
      // Ticket Entry
      // Take substring of the appended contents for the integer value of the number of tickets
      // Check if it passes the nummber of ticket constraint is met
      // Calls numOfTicketConstraint(String line)
  }

  /*
   * The numOfTicketConstraint function checks to see any entries from the daily transaction
   * file surpass the number of tickets available. Essentially, if there are any negative
   * ticket numbers.
   * 
   * @param       line              The first parameter of the numOfTicketConstraint method
   * @return      Boolean           This returns true or false whether number of tickets is negative or not
   */
  public static boolean numOfTicketConstraint(String line){
    // TO-DO:
    // if the 35th to 37th characters are not negative after
    // being converted to an int, then return true
    // Give error if not in form of "ERROR: <msg>"
    return true;
  }

  /*
   * The checkNewUser function checks to see if the username already exists in the system.
   *
   * @param      username           The first parameter of the checkNewUser method
   * @return     Boolean            This returns true or false whether user exists or not
   */
  public static boolean checkNewUser(String username) {
      // TO-DO:
      // the first to 15th characters are put into an array of string usernames
      // the new username would be checked if it already exists in the array to return true
      // Give error if not in form of "ERROR: <msg>"
      return true;
  }
}