#include <string.h>
#include <iomanip>
#include <fstream>
#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <algorithm>
#include "tickets.h"
#include "transaction.h"
#include "user.h"

using namespace std;

const string whitespace = " ";

string current_useraccount_file = "";
string available_ticketfile = "";
string daily_transaction_file = "";

string currentUserType = "";
string currentUserName = "";
bool loginStatus = false;
bool transactionSuccessful = false;
bool userNameMatch = false;
bool eventTitleMatch = false;
bool eventTitleExists = false;
string loginAgain = "";
bool buyerMatch = false;
bool sellerMatch = false;
bool userExists = false;

/*
 * Function Declaration
 * The options function handles all transactions (e.g. create, delete, etc.) based on
 * the option that user selects once user has been logged in. After a transaction has
 * been completed, the user would be logged out.
 * 
 * @param       login_status        The first parameter of the options method.
 * @return                          Nothing
 */
void options(bool login_status);

/*
 * The trim function trims proceeding underscores, allowing for easier comparing between
 * two different strings.
 *
 * @param       s           The first parameter of the trim method.
 * @return                  The trimmed string
 */
string trim(const string& s) {
    size_t end = s.find_last_not_of(whitespace);
    return (end == string::npos) ? "" : s.substr(0, end + 1);
}

/*
 * The login function allows the user to login and test to see
 * if the user exists in the current_useraccount_file.cua. If user
 * exists, allow the user to be logged in, retrieve the username
 * from the current_useraccount_file.cua, and start the front end
 * session. Otherwise, display error and end session.
 *
 * @param currUser               The current user's username
 * @return                       Nothing
 */
void login(string currUser){

    ifstream file;
    file.open(current_useraccount_file.c_str());

    string line;
    string username;

    while (getline(file, line)) {
        username = trim(line.substr(0, 15));

        if (currUser.substr(0, 15) == username) {
            loginStatus = true;
            currentUserType = line.substr(16,2);
        }
    } file.close();

    if(loginStatus == true) {
        cout << "Valid User" << endl;
        cout << "Logged in " + currentUserType << endl;
        transactionSuccessful = true;
        return;
    } else {
        cout << "Invalid user" << endl;
    }
};

/*
 * The logout function will allow users to logout from the
 * system. This is performed automatically after every
 * transaction. The logout function will write to the daily
 * transaction file after the end of each session then log
 * the user out. The system will then ask the user if they would
 * like to login using another user. If the user says yes, or 1,
 * the system redirects the user to the login screen. Otherwise,
 * program ends.
 *
 * @param   transactionCode             The transaction code corresponding to the
                                        particular transaction being performed
 * @param   username                    The user's username
 * @param   credit                      The amount of credit either
                                        available to the user or the
                                        the amount of credit to be refunded
 * @param   userType                    The user's type
 * @param   title                       The event title
 * @param   seller                      The seller's username
 * @param   tickets                     The amount of tickets available/on-sale
 * @param   price                       The ticket price
 * @param   buyer                       The buyer's username
 * @return                              Nothing
 */
void logout(string transactionCode, string username, float credit, string userType, string title, string seller, int tickets, float price, string buyer) {
    if (transactionSuccessful == true) {
        ofstream file;
        file.open(daily_transaction_file.c_str(), fstream::app);

        if (transactionCode == "01") {
            file << transactionCode << " " << username << setw(16-username.length()) << setfill(' ') << 
            " " << userType << " " << setfill('0') << setw(9) << fixed << setprecision(2) << credit << "\n";
            file << "00" << " " << currentUserName << "\n\n";
        } else if (transactionCode == "02") {
            file << transactionCode << " " << username << setw(16-username.length()) << setfill(' ') << 
            " " << userType << " " << setfill('0') << setw(9) << fixed << setprecision(2) << credit << "\n";
            file << "00" << " " << currentUserName << "\n\n";
        } else if (transactionCode == "03") {
            file << transactionCode << " " << title << setw(26-title.length()) << setfill(' ') << " " << currentUserName <<
            setw(14-currentUserName.length()) << setfill(' ') << " " << setfill('0') << setw(3) << tickets << " " << setfill('0') <<
            setw(6) << fixed << setprecision(2) << price << "\n";
            file << "00" << " " << currentUserName << "\n\n";
        } else if (transactionCode == "04") {
            file << transactionCode << " " << title << setw(26-title.length()) << setfill(' ') << " " << seller <<
            setw(14-seller.length()) << setfill(' ') << " " << setfill('0') << setw(3) << tickets << " " << setfill('0') <<
            setw(6) << fixed << setprecision(2) << price << "\n";
            file << "00" << " " << currentUserName << "\n\n";
        } else if (transactionCode == "05") {
            file << transactionCode << " " << buyer << setw(16-buyer.length()) << setfill(' ') << " " << seller <<
            setw(16-seller.length()) << setfill(' ') << " " << setfill('0') << setw(9) << fixed << setprecision(2) <<
            credit << "\n";
            file << "00" << " " << currentUserName << "\n\n";
        } else if (transactionCode == "06") {
            file << transactionCode << " " << username << setw(16-username.length()) << setfill(' ') << " " << userType <<
            " " << setfill('0') << setw(9) << fixed << setprecision(2) << credit << "\n";
            file << "00" << " " << currentUserName << "\n\n";
        }

        file.close();

        cout << "All information has been saved to the daily transaction file." << endl;

        loginStatus = false;

        cout << "Would you like to login with another username: ";
        cin >> loginAgain;

        string input1;

        if (loginAgain == "yes") {
            cout << "Enter 'login' to start" << endl;

            bool correctInput = false;
            while (correctInput == false) {
                cin >> input1;

                if (input1 == "login") {
                    correctInput = true;
                    cout << "\nEnter username" << endl;
                    cin >> currentUserName;
                    login (currentUserName);
                } else  {
                    cout << "Error: Please type 'login' to login into the system." << endl;
                }
            }

            options(loginStatus);
        } else {
            cout << "Thank you for using the Ticket Selling System. Have a great day! " << endl;
            return;
        }

    } else {
        ofstream file;
        file.open(daily_transaction_file.c_str(), fstream::app);

        file << "00" << "_" << currentUserName << "\n\n";

        file.close();

        loginStatus = false;

        cout << "Would you like to login with another username: ";
        cin >> loginAgain;

        string input1;

        if (loginAgain == "yes") {
            cout << "Enter 'login' to start" << endl;

            bool correctInput = false;
            while (correctInput == false) {
                cin >> input1;

                if (input1 == "login") {
                    correctInput = true;
                    cout << "\nEnter username" << endl;
                    cin >> currentUserName;
                    login (currentUserName);
                } else  {
                    cout << "Error: Please type 'login' to login into the system." << endl;
                }
            }

            options(loginStatus);
        } else {
            cout << "Thank you for using the Ticket Selling System. Have a great day! " << endl;
            return;
        }
    }
}

/*
 * The createUser function will allow users to create a new
 * system user with buying or selling privileges. This type of
 * transaction is a privileged transaction, meaning only
 * administrators can create new users. After this transaction is
 * completed, everything is saved to the daily transaction file.
 *
 * @param userName                  The username to be created
 * @param userType                  The type of user to be created
 * @param userCredit                The initial credit the new user
                                    will be starting with
 * @return                          Nothing
 */
void createUser(string userName, string userType, float userCredit){
    if (userName.length() > 15) {
        cout << "Error: Username can only be 15 characters long." << endl;
        transactionSuccessful = false;
        logout("", "", 0.0, "", "", "", 0, 0.0, "");
    } else if (userCredit > 999999) {
        cout << "Error: Credit amount cannot exceed 999,999." << endl;
        transactionSuccessful = false;
        logout("", "", 0.0, "", "", "", 0, 0.0, "");
    } else {
        ifstream file;
        file.open(current_useraccount_file.c_str());

        string line = "";
        string username = "";

        while (getline(file, line)) {

            username = trim(line.substr(0, 15));

            if (userName.substr(0, 15) == username) {
                userNameMatch = true;
            }
        } file.close();

        if (userNameMatch == true) {
            cout << "Error: Username already exists." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        } else {
            cout << "Account Creation Successful." << endl;
            transactionSuccessful = true;
            logout("01", userName, userCredit, userType, "", "", 0, 0.0, "");
        }
    }
};

/*
 * The deleteUserTransaction function will allow the user to either
 * cancel a pending transaction or delete a user from the system.
 * This type of transaction is a privileged transaction, meaning
 * only administrators can delete users or cancel transactions.
 * After this transaction is completed, everything is saved to
 * the daily transaction file.
 *
 * @param  userName                 The username to be deleted
 * @return Nothing
 */
void deleteUser(string userName){
    if (userName == currentUserName) {
        cout << "Error: You cannot delete the current user." << endl;
        transactionSuccessful = false;
        logout("", "", 0.0, "", "", "", 0, 0.0, "");
    } else {
        ifstream file;
        file.open(current_useraccount_file.c_str());

        string line = "";
        string username = "";
        string type = "";
        string userType = "";
        float userCredit = 0.0;
        float credit = 0.0;

        while (getline(file, line)) {
            username = trim(line.substr(0, 15));
            type = line.substr(16,2);
            credit = stof(line.substr(19, 9));

            if (userName == username) {
                userNameMatch = true;
                userType = type;
                userCredit = credit;
            }
        } file.close();

        if (userNameMatch == true) {
            transactionSuccessful = true;
            cout << "User '" + userName + "'" + " has been deleted from the system." << endl;
            logout("02", userName, userCredit, userType, "", "", 0, 0.0, "");
        } else {
            cout << "Error: Username does not exist." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        }
    }
};

/*
 * The sellTicket function will allow the user to sell tickets
 * to a specific event. This type of transaction is semi-privileged,
 * meaning everyone except buy-standard can sell tickets. After this
 * transaction is completed, everything is saved to the daily
 * transaction file.
 *
 * @param  event_title      The title of the event
 * @param  sale_price       The ticket price
 * @param  number_tickets   The number of tickets available
 * @return                  Nothing
 */
void sellTicket(string event_title, float sale_price, int number_tickets){
    ifstream file;
    file.open(available_ticketfile.c_str());

    string line = "";
    string title = "";
    string username = "";

    while (getline(file, line)) {
        title = trim(line.substr(0, 25));
        username = trim(line.substr(26, 13));

        if (title == event_title && username == currentUserName) {
            eventTitleMatch = true;
            break;
        }
    } file.close();

    if (eventTitleMatch == true) {
        cout << "Error: Seller cannot have duplicate event titles." << endl;
        transactionSuccessful = false;
        logout("", "", 0.0, "", "", "", 0, 0.0, "");
    } else {
        if (sale_price > 999.99) {
            cout << "Error: The ticket price cannot exceed $999.99." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        } else if (event_title.length() > 25) {
            cout << "Error: The event title cannot exceed 25 characters." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        } else if (number_tickets > 100) {
            cout << "Error: The maximum number of tickets available for sale cannot exceed 100." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        } else {
            cout << "The event has been created." << endl;
            transactionSuccessful = true;
            logout("03", "", 0.0, "", event_title, currentUserName, number_tickets, sale_price, "");
        }
    }
};

/*
 * The buyTicket function will allow users to buy a ticket to a
 * specific event. This type of transaction is semi-privileged,
 * meaning everyone except sell-standard can buy tickets.
 * After each transaction is performed, the information is saved
 * to the daily transaction file.
 *
 * @param  event_title          The title of the event
 * @param  number_tickets       The number of tickets to be purchased
 * @param  seller_username      The seller's username
 * @param  confirmation         The response from the user whether
                                they would like a confirmation form displayed
 * @return                      Nothing
 */
void buyTicket(string event_title, int number_tickets, string seller_username, string confirmation) {
    ifstream file;
    file.open(available_ticketfile.c_str());

    string line;
    string eventTitle;
    int ticket_amount;
    float ticket_price;
    float total_ticket_price;
    string seller;
    int ticketRemainder = 0;

    while (getline(file, line)) {
        eventTitle = trim(line.substr(0, 25));
        ticket_amount = stoi(line.substr(40, 3));
        ticket_price = stof(line.substr(44, 6));
        seller = trim(line.substr(26, 13));
        ticketRemainder = ticket_amount - number_tickets;

        if ((eventTitle == event_title) && (seller == seller_username)) {
            eventTitleExists = true;
            break;
        }
    } file.close();

    if (eventTitleExists == true) {
        if (ticket_amount > 0) {
            if (ticketRemainder < 0) {
                cout << "Error: You cannot purchase more tickets than what is available." << endl;
                transactionSuccessful = false;
                logout("", "", 0.0, "", "", "", 0, 0.0, "");
            } else {
                cout << "There are tickets available for the '" + event_title + "'." << endl;

                if (number_tickets <= 4 || (number_tickets > 4 && currentUserType == "AA")) {
                    total_ticket_price = ticket_price * number_tickets;
                    cout << "The cost per ticket is $" << ticket_price << ".\n" <<
                    "The total cost for all tickets is $" << total_ticket_price << ".\n" << endl;
                    if (confirmation == "yes") {
                        cout << "Confirmation Form Displayed." << endl;
                    }
                    cout << "Your purchase has been completed, thank you!" << endl;
                    cout << "There are now " << ticketRemainder <<
                    " tickets available to the '" << event_title << "'." << endl;
                    transactionSuccessful = true;
                    logout("04", "", 0.0, "", event_title, seller_username, number_tickets, ticket_price, "");
                } else if (number_tickets > 4 && currentUserType != "AA") {
                    cout << "Error: You cannot purchase more than 4 tickets for an event. " <<
                    "If you want to purchase more tickets, please contact the system administrator." << endl;
                    transactionSuccessful = false;
                    logout("", "", 0.0, "", "", "", 0, 0.0, "");
                }
            }
        } else {
            cout << "Error: Tickets to this event are unavailable." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        }
    } else {
        cout << "Error: That event does not exist." << endl;
        transactionSuccessful = false;
        logout("", "", 0.0, "", "", "", 0, 0.0, "");
    }
};

/*
 * The refund function will allow the user to perform a refund
 * for a ticket previously purchased. This type of transaction
 * is privileged, meaning only administrators will be
 * allowed to administer refunds. After each transaction is
 * performed, the information is saved to the daily transaction
 * file.
 *
 * @param  buyer_username           The buyer's username
 * @param  seller_username          The seller's username
 * @param  credit_amount            The credit amount to be refunded
 * @return                          Nothing
 */
void refund(string buyer_username, string seller_username, float credit_amount){
    ifstream file;
    file.open(current_useraccount_file.c_str());

    string line = "";
    float seller_credit = 0.0;
    float buyer_credit = 0.0;
    float buyerNewCredit = 0.0;
    float sellerNewCredit = 0.0;
    string username = "";
    string userType = "";
    float userCredit = 0.0;
    float total = 0.0;

    while (getline(file, line)) {
        username = trim(line.substr(0, 15));
        userType = line.substr(16,2);
        userCredit = stof(line.substr(19, 9));

        if (username == seller_username && userType == "SS") {
            buyerMatch = true;
            seller_credit = userCredit;
        }

        if (username == buyer_username && userType == "BS") {
            sellerMatch = true;
            buyer_credit = userCredit;
        }
    } file.close();

    total = seller_credit - credit_amount;

    if (sellerMatch == true && buyerMatch == true) {
        if (total < credit_amount) {
            cout << "Error: Seller does not have enough credit to perform refund." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        } else {
            buyerNewCredit = buyer_credit + credit_amount;
            sellerNewCredit = seller_credit - credit_amount;
            cout << "Buyers new credit amount is $" << buyerNewCredit << "." << endl;
            cout << "Sellers new credit amount is $" << sellerNewCredit << "." << endl;
            cout << "Refund completed." << endl;
            transactionSuccessful = true;
            logout("05", "", credit_amount, "", "", seller_username, 0, 0.0, buyer_username);
        }
    } else {
        cout << "Error: Seller username and/or Buyer username does not exist." << endl;
        transactionSuccessful = false;
        logout("", "", 0.0, "", "", "", 0, 0.0, "");
    }
};

/*
 * The addcredit function will allow the user to add credit to
 * another users account. After each transaction is
 * performed, the information is saved to the daily transaction
 * file.
 *
 * @param   credit_amount           The amount of credit to be added
 * @param   userName                The username where the credit would be added to
                                    This would be NULL if any user apart from AA is logged in
 * @return                          Nothing
 */
void addCredit(float credit_amount, string userName){
    if (currentUserType == "AA") {
        if (credit_amount > 1000) {
            cout << "Error: Credit amount cannot exceed $1000.00." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        } else {
            ifstream file;
            file.open(current_useraccount_file.c_str());

            string line = "";
            string username = "";
            float credit = 0.0;
            float userCredit = 0.0;
            float userNewCredit = 0.0;
            string userType = "";
            string type = "";


            while (getline(file, line)) {
                username = trim(line.substr(0, 15));
                userType = line.substr(16,2);
                credit = stof(line.substr(19, 9));

                if (userName.substr(0, 15) == username) {
                    type = userType;
                    userExists = true;
                    userCredit = credit;
                }
            } file.close();

            if (userExists == true) {
                userNewCredit = userCredit + credit_amount;
                cout << "Credit to be added to '" << userName << "': $" << credit_amount << "." << endl;
                cout << "'" << userName << "'s new credit balance: $" << userNewCredit << "." << endl;
                transactionSuccessful = true;
                logout("06", userName, userNewCredit, type, "", "", 0, 0.0, "");
            } else {
                cout << "Error: Username does not exist." << endl;
                transactionSuccessful = false;
                logout("", "", 0.0, "", "", "", 0, 0.0, "");
            }
        }
    } else {
        if (credit_amount > 1000) {
            cout << "Error: Credit added cannot exceed $1000.00." << endl;
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        } else {
            cout << "Credit to be added to user: $" << credit_amount << "." << endl;
            transactionSuccessful = true;
            logout("06", "NA", credit_amount, "NA", "", "", 0, 0.0, "");
        }
    }
};

/*
 * Function Definition
 * The options function handles all transactions (e.g. create, delete, etc.) based on
 * the option that user selects once user has been logged in. After a transaction has
 * been completed, the user would be logged out.
 * 
 * @param       login_status        The first parameter of the options method.
 * @return                          Nothing
 */
void options(bool login_status) {
    while (loginStatus == true) {
        string input2;

        cout << "\nChoose command: \nCreate\nDelete\nBuy\nSell\nRefund\nAdd Credit\nLogout" << endl;
        getline(cin >> ws, input2);
        cout << endl;

        if (input2 == "create") {
            if (currentUserType == "AA") {
                string userName;
                string userType;
                float userCredit;

                cout << "Please enter username: ";
                getline(cin >> ws, userName);
                cout << "Please enter userType: ";
                cin >> userType;
                cout << "Please enter credit amount: ";
                cin >> userCredit;

                createUser(userName, userType, userCredit);
                break;
            } else {
                cout << "Error: Only Administrative users can create accounts." << endl;
                transactionSuccessful = false;
                logout("", "", 0.0, "", "", "", 0, 0.0, "");
            }
        } else if (input2 == "delete") {
            if (currentUserType == "AA") {
                string userName;

                cout << "Enter the username you would like to delete: ";
                getline(cin >> ws, userName);
                deleteUser(userName);
                break;
            } else {
                cout << "Error: Only Administrative users can delete users." << endl;
                transactionSuccessful = false;
                logout("", "", 0.0, "", "", "", 0, 0.0, "");
            }
        } else if (input2 == "sell") {
            if (currentUserType == "BS") {
                cout << "Error: Buy-Standard users cannot sell tickets." << endl;
                transactionSuccessful = false;
                logout("", "", 0.0, "", "", "", 0, 0.0, "");
            } else {
                string event_title;
                int number_tickets;
                float sale_price;

                cout << "What is the event title: ";
                getline(cin >> ws, event_title);

                cout << "What is the sale price: ";
                cin >> sale_price;

                cout << "How many tickets are you selling: ";
                cin >> number_tickets;

                sellTicket(event_title, sale_price, number_tickets);
                break;
            }
        } else if (input2 == "buy") {
            if (currentUserType == "SS") {
                cout << "Error: Sell-Standard users cannot purchase tickets." << endl;
                transactionSuccessful = false;
                logout("", "", 0.0, "", "", "", 0, 0.0, "");
            } else {
                string event_title, confirmation, seller_username;
                int number_tickets;

                cout << "What is the event title: ";
                getline(cin >> ws, event_title);

                cout << "How many tickets would you like to purchase: ";
                cin >> number_tickets;

                cout << "What is the seller's username: ";
                cin >> seller_username;

                cout << "Would you like a confirmation form: ";
                cin >> confirmation;

                buyTicket(event_title, number_tickets, seller_username, confirmation); 
                break;
            }
        } else if (input2 == "refund") {
            if (currentUserType == "AA") {
                string buyer_username;
                string seller_username;
                float credit_amount;

                cout << "What is the buyer's username: ";
                getline(cin >> ws, buyer_username);

                cout << "What is the seller's username: ";
                getline(cin >> ws, seller_username);

                cout << "How much credit would you like to transfer: ";
                cin >> credit_amount;

                refund(buyer_username, seller_username, credit_amount);

                break;
            } else {
                cout << "Error: Only Administrative users can issue refunds." << endl;
                transactionSuccessful = false;
                logout("", "", 0.0, "", "", "", 0, 0.0, "");
            }
        } else if (input2 == "add credit") {
            float credit_amount;
            string userName;

            if (currentUserType == "AA") {
                cout << "How much credit would you like to transfer: ";
                cin >> credit_amount;

                cout << "What username would you like to add credit to: ";
                getline(cin >> ws, userName);

                addCredit(credit_amount, userName);

                break;
            } else {
                cout << "How much credit would you like to transfer: ";
                cin >> credit_amount;

                addCredit(credit_amount, "");

                break;
            }
        } else if (input2 == "logout") {
            transactionSuccessful = false;
            logout("", "", 0.0, "", "", "", 0, 0.0, "");
        }
    }
};

/*
 * The main function loads the files needed for the front end and then
 * starts the front end.
 *
 * @return Nothing
 */
int main(int argc, char const *argv[]) {
    current_useraccount_file = argv[1];
    available_ticketfile = argv[2];
    daily_transaction_file = argv[3];

    string input1;

    cout << "\nLoading files..." << endl;
    cout << current_useraccount_file << endl;
    cout << available_ticketfile << endl;
    cout << daily_transaction_file << endl;

    cout << "Welcome To Ticket Sales" << endl;

    cout << "Enter 'login' to start" << endl;

    bool correctInput = false;
    while (correctInput == false) {
        cin >> input1;

        if (input1 == "login") {
            correctInput = true;
            cout << "\nEnter username" << endl;
            cin >> currentUserName;
            login (currentUserName);
        } else  {
            cout << "Error: Please type 'login' to login into the system." << endl;
        }
    }

    options(loginStatus);

    return 0;
}