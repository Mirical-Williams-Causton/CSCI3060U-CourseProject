#ifndef TRANSACTION_H
#define TRANSACTION_H

using namespace std;

class Transaction{
public:
  Transaction(); // defult Constructor
  Transaction(string currntUN, string currentUT, string currentTT, float currentUC,
              string eventT, string sellersUN, int numT, float ticketP);
  ~Transaction(); // Destructor

  // Accessors
  string getCurrentUsername();
  string getCurrentUserType();
  string getTransactionType();
  float getCurrentUserCredit();
  string getEventTitle();
  string getSellersUsername();
  int getNumberTickets();
  float getTicketPrice();

  // Mutators
  void setCurrentUsername(string currntUN);
  void setCurrentUserType(string currentUT);
  void setTransactionType(string currentTT);
  void setCurrentUserCredit(float currentUC);
  void setEventType(string eventTitle);
  void setSellersUserType(string sellersUN);
  void setNumberTickets(int numT);
  void setTicketPrice(float ticketP);

  void print(); // print
  void storeDailyTransaction(); // saving to the file

private:
  string currentUsername;
  string currentUserType;
  string transactionType;
  float currentUserCredit;
  string eventTitle;
  string sellersUsername;
  int numTickets;
  float ticketPrice;
};

#endif
