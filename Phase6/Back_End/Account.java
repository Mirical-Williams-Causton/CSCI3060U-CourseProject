/*
 * Backend of the Ticket Selling Service
 *
 * @author  Mirical Williams-Causton
 * @version 1.0
 * @since   2019-03-16
 */

public class Account {
	String username, user_type;
	float user_credit;

	/*
	 * The Account default constructor
	 *
	 * @return 					Nothing 
	 */
	Account() { }

	/*
	 * The Account constructor
	 *
	 * @param 	username 		The first parameter of the Account constructor
	 * @param 	user_type 		The second parameter of the Account constructor
	 * @param 	user_credit 	The third parameter of the Account constructor
	 * @return 					Nothing
	 */
	Account(String username, String user_type, float user_credit) {
		this.username = username;
		this.user_type = user_type;
		this.user_credit = user_credit;
	}

	/*
	 * The getUsername function gets the user's username.
	 *
	 * @return					The user's username.
	 */
	String getUsername() { return this.username; }

	/*
	 * The getUserType function gets the user's account type.
	 * 
	 * @return 					The user's account type
	 */
	String getUserType() { return this.user_type; }

	/*
	 * The getCredit function gets the user's available credit.
	 *
	 * @return 					The user's available credit
	 */
	float getCredit() { return this.user_credit; }

	/*
	 * The setUsername function sets the user's username.
	 *
	 * @param 	username 		The first parameter of the setUsername method
	 * @return 					Nothing
	 */
	void setUsername(String username) { this.username = username; }

	/*
	 * The setUserType function sets the user's account type.
	 *
	 * @param 	user_type 		The first parameter of the setUserType method
	 * @return 					Nothing
	 */
	void setUserType(String user_type) { this.user_type = user_type; }

	/*
	 * The setCredit function sets the user's available credit.
	 *
	 * @param 	user_credit 	The first parameter of the setCredit method
	 * @return 					Nothing
	 */
	void setCredit(float user_credit) { this.user_credit = user_credit; }
}