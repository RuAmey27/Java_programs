//1. Simple Java Program
class HelloWorld
{
public static void main(String args[])
{
System.out.println("Hello World by Technolamror");
}
}
/*2. Print Integer in java
class Integers {
public static void main(String[] arguments) {
int c; //declaring a variable
 Using for loop to repeat instruction execution 
for (c = 1; c <= 10; c++) {
System.out.println(c);
}
}
}
3. Command Line Argument in java
class Arguments {
public static void main(String[] args) {
for (String t: args) {
System.out.println(t);
}
}
}
4. How to get Using input using Scanner
Program in java
import java.util.Scanner;
class GetInputFromUser
{
public static void main(String args[])
{
int a;
float b;
String s;
Scanner in = new Scanner(System.in);
System.out.println("Enter a string");
s = in.nextLine();
System.out.println("You entered string "+s);
System.out.println("Enter an integer");
a = in.nextInt();
System.out.println("You entered integer "+a);
System.out.println("Enter a float");
b = in.nextFloat();
System.out.println("You entered float "+b);
}
}
5. How to convert Fahrenheit to Celsius
Program in java
import java.util.*;
class FahrenheitToCelsius {
public static void main(String[] args) {
float temperatue;
Scanner in = new Scanner(System.in);
System.out.println("Enter temperatue in Fahrenheit");
temperatue = in.nextInt();
temperatue = ((temperatue - 32)*5)/9;
System.out.println("Temperatue in Celsius = " + temperatue);
}
}
icientfutomation ProA
6. How to swap 2 no using 3rd variable Program
in java
import java.util.Scanner;
class SwapNumbers
{
public static void main(String args[])
{
int x, y, temp;
System.out.println("Enter x and y");
Scanner in = new Scanner(System.in);
x = in.nextInt();
y = in.nextInt();
System.out.println("Before Swapping\nx = "+x+"\ny = "+y);
temp = x;
x = y;
y = temp;
System.out.println("After Swapping\nx = "+x+"\ny = "+y);
}
}
7. How to swap 2 no without using 3rd variable
Program in java
import java.util.Scanner;
class SwapNumbers
{
public static void main(String args[])
{
int x, y;
System.out.println("Enter x and y");
Scanner in = new Scanner(System.in);
x = in.nextInt();
y = in.nextInt();
System.out.println("Before Swapping\nx = "+x+"\ny = "+y);
icientfutomation ProA
x = x + y;
y = x - y;
x = x - y;
System.out.println("After Swapping\nx = "+x+"\ny = "+y);
}
}
8. How to add two number Program in java
import java.util.Scanner;
class AddNumbers
{
public static void main(String args[])
{
int x, y, z;
System.out.println("Enter two integers to calculate their sum ");
Scanner in = new Scanner(System.in);
x = in.nextInt();
y = in.nextInt();
z = x + y;
System.out.println("Sum of entered integers = "+z);
}
}
//For Large Number
import java.util.Scanner;
import java.math.BigInteger;
class AddingLargeNumbers {
public static void main(String[] args) {
String number1, number2;
Scanner in = new Scanner(System.in);
System.out.println("Enter first large number");
number1 = in.nextLine();
System.out.println("Enter second large number");
number2 = in.nextLine();
BigInteger first = new BigInteger(number1);
BigInteger second = new BigInteger(number2);
BigInteger sum;
sum = first.add(second);
System.out.println("Result of addition = " + sum);
}
Automation Proficient
}
9. Find Largest no in java Program
import java.util.Scanner;
class LargestOfThreeNumbers
{
public static void main(String args[])
{
int x, y, z;
System.out.println("Enter three integers ");
Scanner in = new Scanner(System.in);
x = in.nextInt();
y = in.nextInt();
z = in.nextInt();
if ( x > y && x > z )
System.out.println("First number is largest.");
else if ( y > x && y > z )
System.out.println("Second number is largest.");
else if ( z > x && z > y )
System.out.println("Third number is largest.");
else
System.out.println("Entered numbers are not distinct.");
}
}
10. If Else clause in java
class Condition {
public static void main(String[] args) {
boolean learning = true;
if (learning) {
System.out.println("Java programmer");
}
else {
System.out.println("What are you doing here?");
}
}
}
Automation Proficient
11. If Else clause in java- Program 2
// If else in Java code
import java.util.Scanner;
class IfElse {
public static void main(String[] args) {
int marksObtained, passingMarks;
passingMarks = 40;
Scanner input = new Scanner(System.in);
System.out.println("Input marks scored by you");
marksObtained = input.nextInt();
if (marksObtained >= passingMarks) {
System.out.println("You passed the exam.");
}
else {
System.out.println("Unfortunately you failed to pass the exam.");
}
}
}
12. Nested If Else clause in java
import java.util.Scanner;
class NestedIfElse {
public static void main(String[] args) {
int marksObtained, passingMarks;
char grade;
passingMarks = 40;
Scanner input = new Scanner(System.in);
System.out.println("Input marks scored by you");
marksObtained = input.nextInt();
if (marksObtained >= passingMarks) {
if (marksObtained > 90)
grade = 'A';
Automation Proficient
else if (marksObtained > 75)
grade = 'B';
else if (marksObtained > 60)
grade = 'C';
else
grade = 'D';
System.out.println("You passed the exam and your grade is " + grade);
}
else {
grade = 'F';
System.out.println("You failed and your grade is " + grade);
}
}
}
13. How to check Odd and Even Number in java.
import java.util.Scanner;
class OddOrEven
{
public static void main(String args[])
{
int x;
System.out.println("Enter an integer to check if it is odd or even ");
Scanner in = new Scanner(System.in);
x = in.nextInt();
if ( x % 2 == 0 )
System.out.println("You entered an even number.");
else
System.out.println("You entered an odd number.");
}
}
14. Find factorial for given no Program in Java
import java.util.Scanner;
class Factorial
{
public static void main(String args[])
{
int n, c, fact = 1;
System.out.println("Enter an integer to calculate it's factorial");
Scanner in = new Scanner(System.in);
n = in.nextInt();
Automation Proficient
if ( n < 0 )
System.out.println("Number should be non-negative.");
else
{
for ( c = 1 ; c <= n ; c++ )
fact = fact*c;
System.out.println("Factorial of "+n+" is = "+fact);
}
}
}
//Calculate factorial for large No
import java.util.Scanner;
import java.math.BigInteger;
class BigFactorial
{
public static void main(String args[])
{
int n, c;
BigInteger inc = new BigInteger("1");
BigInteger fact = new BigInteger("1");
Scanner input = new Scanner(System.in);
System.out.println("Input an integer");
n = input.nextInt();
for (c = 1; c <= n; c++) {
fact = fact.multiply(inc);
inc = inc.add(BigInteger.ONE);
}
System.out.println(n + "! = " + fact);
}
}
15. How to complete 2 string in Java program
import java.util.Scanner;
class CompareStrings
{
public static void main(String args[])
{
String s1, s2;
Scanner in = new Scanner(System.in);
System.out.println("Enter the first string");
s1 = in.nextLine();
Automation Proficient
System.out.println("Enter the second string");
s2 = in.nextLine();
if ( s1.compareTo(s2) > 0 )
System.out.println("First string is greater than second.");
else if ( s1.compareTo(s2) < 0 )
System.out.println("First string is smaller than second.");
else
System.out.println("Both strings are equal.");
}
}
16. Simple For Loop Program in Java
//Java for loop program
class ForLoop {
public static void main(String[] args) {
int c;
for (c = 1; c <= 10; c++) {
System.out.println(c);
}
}
}
17. Print Star console using Loop
class Stars {
public static void main(String[] args) {
int row, numberOfStars;
for (row = 1; row <= 10; row++) {
for(numberOfStars = 1; numberOfStars <= row; numberOfStars++) {
System.out.print("*");
}
System.out.println(); // Go to next line
}
}
}
Automation Proficient
18. Print Star console using Loop
class Stars {
public static void main(String[] args) {
int row, numberOfStars;
for (row = 1; row <= 10; row++) {
for(numberOfStars = 1; numberOfStars <= row; numberOfStars++) {
System.out.print("*");
}
System.out.println(); // Go to next line
}
}
}
19. While loop Program in java
import java.util.Scanner;
class WhileLoop {
public static void main(String[] args) {
int n;
Scanner input = new Scanner(System.in);
System.out.println("Input an integer");
while ((n = input.nextInt()) != 0) {
System.out.println("You entered " + n);
System.out.println("Input an integer");
}
System.out.println("Out of loop");
}
Automation Proficient
}
20. Print Reverse number in java program
import java.util.Scanner;
class ReverseNumber
{
public static void main(String args[])
{
int n, reverse = 0;
System.out.println("Enter the number to reverse");
Scanner in = new Scanner(System.in);
n = in.nextInt();
while( n != 0 )
{
reverse = reverse * 10;
reverse = reverse + n%10;
n = n/10;
}
System.out.println("Reverse of entered number is "+reverse);
}
}
21. While loop using break Program in java
import java.util.Scanner;
class BreakWhileLoop {
public static void main(String[] args) {
int n;
Scanner input = new Scanner(System.in);
while (true) {
System.out.println("Input an integer");
n = input.nextInt();
if (n == 0) {
break;
}
System.out.println("You entered " + n);
}
}
}
icientfutomation ProA
22. While loop using break and continue
Program in java
import java.util.Scanner;
class BreakContinueWhileLoop {
public static void main(String[] args) {
int n;
Scanner input = new Scanner(System.in);
while (true) {
System.out.println("Input an integer");
n = input.nextInt();
if (n != 0) {
System.out.println("You entered " + n);
continue;
}
else {
break;
}
}
}
}
23. Print all alphabet using for loop Program in
java
class Alphabets
{
public static void main(String args[])
{
char ch;
for( ch = 'a' ; ch <= 'z' ; ch++ )
System.out.println(ch);
}
}
icientfutomation ProA
24. Enhance loop in java Program
class EnhancedForLoop {
public static void main(String[] args) {
int primes[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
for (int t: primes) {
System.out.println(t);
}
}
}
//For String
class EnhancedForLoop {
public static void main(String[] args) {
String languages[] = { "C", "C++", "Java", "Python", "Ruby"};
for (String sample: languages) {
System.out.println(sample);
}
}
}
25. Print Multiplication table Program in java
import java.util.Scanner;
class MultiplicationTable
{
public static void main(String args[])
{
int n, c;
System.out.println("Enter an integer to print it's multiplication
table");
Scanner in = new Scanner(System.in);
n = in.nextInt();
System.out.println("Multiplication table of "+n+" is :-");
for ( c = 1 ; c <= 10 ; c++ )
System.out.println(n+"*"+c+" = "+(n*c));
}
}
//For Any Number
import java.util.Scanner;
class Tables
{
public static void main(String args[])
{
int a, b, c, d;
icientfutomation ProA
System.out.println("Enter range of numbers to print their multiplication
table");
Scanner in = new Scanner(System.in);
a = in.nextInt();
b = in.nextInt();
for (c = a; c <= b; c++) {
System.out.println("Multiplication table of "+c);
for (d = 1; d <= 10; d++) {
System.out.println(c+"*"+d+" = "+(c*d));
}
}
}
}
26. Print prime no Program in java
import java.util.*;
class PrimeNumbers
{
public static void main(String args[])
{
int n, status = 1, num = 3;
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of prime numbers you want");
n = in.nextInt();
if (n >= 1)
{
System.out.println("First "+n+" prime numbers are :-");
System.out.println(2);
}
for ( int count = 2 ; count <=n ; )
{
for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
{
if ( num%j == 0 )
{
status = 0;
break;
}
}
if ( status != 0 )
{
System.out.println(num);
count++;
}
icientfutomation ProA
status = 1;
num++;
}
}
}
27. Check no is Armstrong or not in java
Program
import java.util.Scanner;
class ArmstrongNumber
{
public static void main(String args[])
{
int n, sum = 0, temp, remainder, digits = 0;
Scanner in = new Scanner(System.in);
System.out.println("Input a number to check if it is an Armstrong
number");
n = in.nextInt();
temp = n;
// Count number of digits
while (temp != 0) {
digits++;
temp = temp/10;
}
temp = n;
while (temp != 0) {
remainder = temp%10;
sum = sum + power(remainder, digits);
temp = temp/10;
}
if (n == sum)
System.out.println(n + " is an Armstrong number.");
else
System.out.println(n + " is not an Armstrong number.");
}
static int power(int n, int r) {
int c, p = 1;
for (c = 1; c <= r; c++)
p = p*n;
return p;
icientfutomation ProA
}
}
28. Print Floyd’s Triangle in java Program
import java.util.Scanner;
class FloydTriangle
{
public static void main(String args[])
{
int n, num = 1, c, d;
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of rows of floyd's triangle you
want");
n = in.nextInt();
System.out.println("Floyd's triangle :-");
for ( c = 1 ; c <= n ; c++ )
{
for ( d = 1 ; d <= c ; d++ )
{
System.out.print(num+" ");
num++;
}
System.out.println();
}
}
}
29. Find All substring of string in java Program
import java.util.Scanner;
class SubstringsOfAString
{
public static void main(String args[])
{
String string, sub;
int i, c, length;
Scanner in = new Scanner(System.in);
System.out.println("Enter a string to print it's all substrings");
string = in.nextLine();
length = string.length();
icientfutomation ProA
System.out.println("Substrings of \""+string+"\" are :-");
for( c = 0 ; c < length ; c++ )
{
for( i = 1 ; i <= length - c ; i++ )
{
sub = string.substring(c, c+i);
System.out.println(sub);
}
}
}
}
30. Print reverse string in java Program
import java.util.*;
class ReverseString
{
public static void main(String args[])
{
String original, reverse = "";
Scanner in = new Scanner(System.in);
System.out.println("Enter a string to reverse");
original = in.nextLine();
int length = original.length();
for ( int i = length - 1 ; i >= 0 ; i-- )
reverse = reverse + original.charAt(i);
System.out.println("Reverse of entered string is: "+reverse);
}
}
//Using Internal java Methog
class InvertString
{
public static void main(String args[])
{
StringBuffer a = new StringBuffer("Java programming is fun");
System.out.println(a.reverse());
}
}
*/
