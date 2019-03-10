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

public class MergedTransaction {

  /*
   * The appendFile function appends all new transactions from the old daily transaction
   * file to a new daily transaction file.
   *
   * @param 		contents		The first parameter of the appendFile method
   * @return 						Nothing
   * @exception 	IOException 	On file not found error
   * @see 			IOException
   */	
  public static void appendFile(String contents) throws IOException {

    // TO-DO: Delete last 00 from previous day's transaction file last line

    String historicalTransactions = "HistoricalTransactions.txt";
    File file = new File(historicalTransactions);
		FileWriter fr = null;
		BufferedWriter br = null;
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
      UpdateManager toRead = new UpdateManager();
			for (int i = 0; i < toRead.lineCount; i++) {
				br.newLine();
				// you can use write or append method
				br.write(contents);
			}
      // TO-DO: Append the 00 line at the end of the transaction file.
  }
}