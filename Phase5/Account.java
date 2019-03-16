public class Account {
	String username, user_type;
	float user_credit;

	Account() { }

	Account(String username, String user_type, float user_credit) {
		this.username = username;
		this.user_type = user_type;
		this.user_credit = user_credit;
	}

	String getUsername() { return this.username; }
	String getUserType() { return this.user_type; }
	float getCredit() { return this.user_credit; }

	void setUsername(String username) { this.username = username; }
	void setUserType(String user_type) { this.user_type = user_type; }
	void setCredit(float user_credit) { this.user_credit = user_credit; }
}