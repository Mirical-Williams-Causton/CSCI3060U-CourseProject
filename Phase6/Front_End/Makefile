
output: main.o tickets.o user.o buy.o transaction.o
	g++ main.o tickets.o user.o buy.o transaction.o -o output

main: main.cpp
	g++ -c -std=c++11 main.cpp

tickets.o: tickets.cpp tickets.h
	g++ -c -std=c++11 tickets.cpp

user.o: user.cpp user.h
	g++ -c -std=c++11 user.cpp

buy.o: buy.cpp buy.h
	g++ -c -std=c++11 buy.cpp

transaction.o: transaction.cpp transaction.h
	g++ -c -std=c++11 transaction.cpp

clean:
	rm *.o output