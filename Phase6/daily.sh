#!/bin/bash

day=$1;

cd Front_End

name=1;

for i in ../Daily_Script/Daily_Script_Day0$day/*.in;do
	echo "running test $i"
	./output < $i
	mv ../merged_daily_transaction_file.tra ../Daily_Script/Daily_Transaction_Files/Daily_Script_Day0$day/daily_transaction_file_$name.tra
	name=$(($name+1))
	echo " "
done

cd ../Daily_Script/Daily_Transaction_Files/Daily_Script_Day0$day

Output_File="../../../merged_daily_transaction_file.tra"
rm -f $Output_File
touch $Output_File

rm -f "merged_daily_transaction_file.tra"
touch "merged_daily_transaction_file.tra"

rm -f "available_ticketfile.tra"
touch "available_ticketfile.tra"

rm -f "current_useraccount_file.cua"
touch "current_useraccount_file.cua"

for i in *tra;do
	echo "merging file $i"
	cat $i >> $Output_File
	echo " "
done

cat $Output_File >> "merged_daily_transaction_file.tra"

cd ../../../Back_End
java MainDriver

cd ../Daily_Script/Daily_Transaction_Files/Daily_Script_Day0$day
cat "../../../available_ticketfile.tra" >> "available_ticketfile.tra"
cat "../../../current_useraccount_file.cua" >> "current_useraccount_file.cua"