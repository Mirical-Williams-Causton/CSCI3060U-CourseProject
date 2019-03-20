/**
 * This class is the tickets class, the main point of this class
 * is to save all the tickets to tickets file available_ticketsfile
 */
#include <iostream>
#include <fstream>
#include "tickets.h"
#include "user.h"

using namespace std;

/**
 * All the tickets available will be saved to this file
 */
 string availableTicketsFile = "available_ticketsfile.tra";

/**
 * Constructor
 */
 Tickets::Tickets() {
   currentUsername;
   eventTitle;
   sellersUsername;
   numTickets;
   ticketPrice;
 }


 Tickets::Tickets(string currentUN, string eventT, string sellersUN, int numT, float ticketP) {
   currentUsername = currentUN;
   eventTitle = eventT;
   sellersUsername = sellersUN;
   numTickets = numT;
   ticketPrice = ticketP;
 }

/**
 * Destructor
 */
 Tickets::~Tickets() {
   // TO DO
 }

 /**
  * Accessors
  * @returns The current user that is logged in
  * @returns The event Title
  * @returns The sellers username
  * @returns The number of tickets for sale
  * @retunrs The price per ticket
  */
  string Tickets::getCurrentUsername(){
   return currentUsername;
  }
  string Tickets::getEventTitle(){
    return eventTitle;
  }
  string Tickets::getSellersUsername(){
    return sellersUsername;
  }
  int Tickets::getNumberTickets(){
    return numTickets;
  }
  float Tickets::getTicketPrice(){
    return ticketPrice;
  }

  /**
   * Mutators
   * @param currntUN Sets the current user logged in
   * @param eventT Sets the event Title
   * @param sellersUN Sets the sellers username
   * @param numT Sets the number of tickets being sold
   * @param ticketP Sets the price per ticket
   */
  void Tickets::setCurrentUsername(string currentUN){
    currentUsername = currentUN;
  }
  void Tickets::setEventType(string eventT){
    eventTitle = eventT;
  }
  void Tickets::setSellersUserType(string sellersUN){
    sellersUsername = sellersUN;
  }
  void Tickets::setNumberTickets(int numT){
    numTickets = numT;
  }
  void Tickets::setTicketPrice(float ticketP){
    ticketPrice = ticketP;
  }

  /**
   * Print Ticketd information will be used for debugging
   */
  void Tickets::print(){
    // TO DO
  }

  /**
   * Save tickets to the available tickets file
   */
  void Tickets::storeAvailableTickets(){
    // TO DO
  }
