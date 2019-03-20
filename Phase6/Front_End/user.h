#ifndef USER_H
#define USER_H

using namespace std;

class User {
public:
  User(); // defult Constructor
  User(string userN, string userT, float c); // Constructor
  ~User(); // defult destructor

  string getUsername(); // gets the user name
  string getUserTypes(); // gets the user type
  float getCredit(); // gets the user credit

  void setUsername(string userN);
  void setUserType(string userT);
  void setCredit(float c);
  void addCredit(float c);

  void print();

private:
  string username;
  string userType;
  float credit;
};

#endif // USER_H
