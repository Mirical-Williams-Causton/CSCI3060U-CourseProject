/**
 *  This class is the user class which gets users information
 */
#include <iostream>
#include "user.h"

using namespace std;

/**
 * Constructor
 */
User::User() {
  username;
  userType;
  credit;
}

User::User(string userN, string userT, float c) {
  username = userN;
  userType =  userT;
  credit = c;
}

/**
 * Destructor
 */
User::~User() {

}

/**
 * getters
 * these three functions below act as getters
 * getUserName() - gets the user name and returns it
 * getUserTypes() - gets the user type and returns it
 * getCredit() - gets the users credit and returns it
 */
string User::getUsername(){return username;}
string User::getUserTypes(){return userType;}
float User::getCredit(){return credit;}

/**
 * setters
 * these three functions below act as setters
 */
void User::setUsername(string userN){username = userN;}
void User::setUserType(string userT){userType = userT;}
void User::setCredit(float userC){credit = userC;}

// mutators
void User::addCredit(float c) {credit = credit + c;}

/**
 * Print user information will be used for debugging
 */
void User::print(){
}
