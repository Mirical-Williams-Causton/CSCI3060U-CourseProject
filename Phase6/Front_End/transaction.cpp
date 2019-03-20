/**
 * This class is the transaction class, the main point of this class
 * is to save all the transactions that happen every session to the
 * daily_transaction_file.
 */
#include <iostream>
#include <fstream>
#include "transaction.h"
#include "user.h"

/**
 * All transactions will be saved to this file after every session
 */
string dailyTransactionFile ="daily_transaction_file.tra";

/**
 * Constructors
 */
Transaction::Transaction() {
        currentUsername;
        currentUserType;
        transactionType;
        currentUserCredit;
        eventTitle;
        sellersUsername;
        numTickets;
        ticketPrice;
}

Transaction::Transaction(string currentUN, string currentUT, string currentTT, float currentUC,
                         string eventT, string sellersUN, int numT, float ticketP){
        currentUsername = currentUN;
        currentUserType = currentUT;
        transactionType = currentTT;
        currentUserCredit = currentUC;
        eventTitle = eventT;
        sellersUsername = sellersUN;
        numTickets = numT;
        ticketPrice = ticketP;
}

/**
 * Destructor
 */
Transaction::~Transaction(){
  // TO DO
}

/**
 * Accessors
 * @returns The current user that is logged in
 * @return The current user's account type ie. AA, BS, FS, SS
 * @return The type of transaction executed by the user
 * @return The current credit in the user's account
 * @returns The event Title
 * @returns The sellers username
 * @returns The number of tickets for sale
 * @retunrs The price per ticket
 */
 string Transaction::getCurrentUsername(){
  return currentUsername;
 }
string Transaction::getCurrentUserType(){
  return currentUserType;
}
string Transaction::getTransactionType(){
  return transactionType;
}
float Transaction::getCurrentUserCredit(){
  return currentUserCredit;
}
string Transaction::getEventTitle(){
  return eventTitle;
}
string Transaction::getSellersUsername(){
  return sellersUsername;
}
int Transaction::getNumberTickets(){
  return numTickets;
}
float Transaction::getTicketPrice(){
  return ticketPrice;
}

/**
 * Mutators
 * @param currntUN Sets the current user logged in
 * @param currentUT Sets the current user type
 * @param currentTT Sets the current transaction type
 * @param currentUC Sets the current users credit
 * @param eventT Sets the event Title
 * @param sellersUN Sets the sellers username
 * @param numT Sets the number of tickets being sold
 * @param ticketP Sets the price per ticket
 */
void Transaction::setCurrentUsername(string currentUN){
  currentUsername = currentUN;
}
void Transaction::setCurrentUserType(string currentUT){
  currentUserType = currentUT;
}
void Transaction::setTransactionType(string currentTT){
  transactionType = currentTT;
}
void Transaction::setCurrentUserCredit(float currentUC){
  currentUserCredit = currentUC;
}
void Transaction::setEventType(string eventT){
  eventTitle = eventT;
}
void Transaction::setSellersUserType(string sellersUN){
  sellersUsername = sellersUN;
}
void Transaction::setNumberTickets(int numT){
  numTickets = numT;
}
void Transaction::setTicketPrice(float ticketP){
  ticketPrice = ticketP;
}

/**
 * Print Transaction information primarily used for debugging
 */
void Transaction::print(){
  // TO DO
}

/**
 * Save transactions to the daily transaction file
 */
void Transaction::storeDailyTransaction(){
  // TO DO
}
