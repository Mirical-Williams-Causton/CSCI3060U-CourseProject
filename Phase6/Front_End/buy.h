#ifndef BUY_H
#define BUY_H

using namespace std;

class Buy {
public:
  Buy(); // defult Constructor
  Buy(string buyerN, string eventT, int numT, float ticketP, string sellersN);
  ~Buy();

  string getBuyersName(); // gets the buyers name
  string getEventTitle(); // gets the event title
  int getNumberTickets(); // gets the number of tickets
  float getTicketPrice(); // gets the ticket price
  string getSellersName(); //gets the sellers name

  void setBuyersName(string buyerN);
  void setEventTitle(string eventT);
  void setNumberTickets(int numT);
  void setTicketsPrice(float ticketP);
  void setSellersName(string sellersN);

  void print(); // will be used for debugging

private:
  string buyersName;
  string eventTitle;
  int numTickets;
  float ticketPrice;
  string sellersName;
};

#endif
