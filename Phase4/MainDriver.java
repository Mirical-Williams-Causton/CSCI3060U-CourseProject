import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.lang.*;

/*
 * Back-End
 * Daily Transaction File
 * This program is for merging the daily Transaction File outputs from the Front-End
 *
 * @author  Agilan Ampigaipathar, Mirical Williams-Causton
 * @version 1.0
 * @since   2019-03-10
 */

public class MainDriver {
  /*
   * The main function calls other classes and their functions,
   * sends filenames to the MergedTransaction and UpdateManager classes
   * to be accessed by their methods, and starts the backend session.
   *
   * @param           args              The first parameter of the main method
   * @return                            Nothing
   * @exception       IOException       On file not found error
   * @see             IOException
   */
  public static void main(String[] args) throws IOException {
    UpdateManager update = new UpdateManager();
    String fileName = "NewAccounts.txt";
    update.fileReader(fileName);

    String newTransactionFile = "NewTransactions.txt";
    UpdateManager toRead = new UpdateManager();
    String contentsToAppend = toRead.fileReader(newTransactionFile);

    MergedTransaction merge = new MergedTransaction();
    merge.appendFile(contentsToAppend);
  }
}