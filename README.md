# Assumptions


There are 2 types of variables in this program:
* A roman numeral variable: This takes the place of roman numerals such as I,V,X,L,C,D, or M.
* A credit variable: This represents a value for credits. For example, Iron could represent 10 credits.


There are 4 main modes in this program:
1) Set a variable as a roman numeral. It is done with the command structure: [var] is [roman numeral]
2) Set a variable with a credit value. Can be appened by roman numeral variables. Command structure: [roman numeral var]+ [credit var] is [int] Credits 
3) Ask for the integer value of roman numeral variables. Structure is: How much is [roman numeral var]+  
4) Ask for credit value with roman numeral and credit vairables. Structure is: How much is [roman numeral var]+ [credit var]+ 


Examples of the 4 modes:
1) glob is V
2) glob glob Silver is 34 Credits
3) How much is glob glob?
4) How much is glob glob Silver?
