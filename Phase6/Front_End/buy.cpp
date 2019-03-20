#include <iostream>
#include <fstream>
#include "buy.h"

using namespace std;

/**
 * Constructors
 */
Buy::Buy() {
  buyersName;
  eventTitle;
  numTickets;
  ticketPrice;
  sellersName;
}


Buy::Buy(string buyerN, string eventT, int numT, float ticketP, string sellersN){
  buyersName = buyerN;
  eventTitle = eventT;
  numTickets = numT;
  ticketPrice = ticketP;
  sellersName = sellersN;
}

/**
 * Destructor
 */
Buy::~Buy(){}

/**
 * Accessors
 * @returns The current buyers name
 * @returns The event Title
 * @returns The number of tickets for sale
 * @returns The price per ticket
 * @retunrs The sellers namel
 */
 string Buy::getBuyersName(){
  return buyersName;
 }
 string Buy::getEventTitle(){
   return eventTitle;
 }
 int Buy::getNumberTickets(){
   return numTickets;
 }
 float Buy::getTicketPrice(){
   return ticketPrice;
 }
 string Buy::getSellersName(){
   return sellersName;
 }

 /**
  * Mutators
  * @param buyers sets the buyers name
  * @param eventT sets the event titles
  * @param numT sets the number of tickets being sold
  * @param ticketP sets the price per ticket
  * @param sellersN sets the sellers name
  */
 void Buy::setBuyersName(string buyerN){
   buyersName = buyerN;
 }
 void Buy::setEventTitle(string eventT){
   eventTitle = eventT;
 }
 void Buy::setNumberTickets(int numT){
   numTickets = numT;
 }
 void Buy::setTicketsPrice(float ticketP){
   ticketPrice = ticketP;
 }
 void Buy::setSellersName(string sellersN){
   sellersName = sellersN;
 }

 /**
  * Print buy information will be used for debugging
  */
 void Buy::print(){
   // TO Do
 }
