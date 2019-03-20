#ifndef TICKETS_H
#define TICKETS_H

using namespace std;

class Tickets {
public:
  Tickets(); // defult Constructor
  Tickets(string currntUN, string eventT, string sellersUN, int numT, float ticketP);
  ~Tickets(); // Destructor

  // Accessors
  string getCurrentUsername();
  string getEventTitle();
  string getSellersUsername();
  int getNumberTickets();
  float getTicketPrice();

  // Mutators
  void setCurrentUsername(string currntUN);
  void setEventType(string eventTitle);
  void setSellersUserType(string sellersUN);
  void setNumberTickets(int numT);
  void setTicketPrice(float ticketP);

  void print(); // print
  void storeAvailableTickets(); // saving to the file

private:
  string currentUsername;
  string eventTitle;
  string sellersUsername;
  int numTickets;
  float ticketPrice;
};

#endif
