/*java code to add all the number in the array.



int[] numbers = {1, 2, 3, 4, 5};
int sum = 0;

for (int num : numbers) {
    sum += num;
}

System.out.println("The sum of the numbers in the array is: " + sum);
---------------------------------------------------
java code to add all the number in the array. Take input from user

import java.util.Scanner;

class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("The sum of the numbers in the array is: " + sum);
    }
}

/*---------------------------------


Addition of 2 Array

int[] array1 = {1, 2, 3};
int[] array2 = {4, 5, 6};
int[] sum = new int[array1.length];

for (int i = 0; i < array1.length; i++) {
    sum[i] = array1[i] + array2[i];
}

System.out.println("The sum of the arrays is: " + Arrays.toString(sum));

------------
Using Function

public static int addArray(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return sum;
}

int[] numbers = {1, 2, 3, 4, 5};
int result = addArray(numbers);
System.out.println("The sum of the numbers in the array is: " + result);

---------------------

Simple java code to add all the number in the array by passing array to function

Refine code. Take input from user



import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int result = addArray(numbers);
        System.out.println("The sum of the numbers in the array is: " + result);
    }

    public static int addArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}


/*-------------------------


Using Function

public class ArrayAddition {
    public static int[] addArrays(int[] array1, int[] array2) {
        int[] sum = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            sum[i] = array1[i] + array2[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] result = addArrays(array1, array2);
        System.out.println("The sum of the arrays is: " + Arrays.toString(result));
    }
}

-----------

CLASSES

Java code for Addition of 2 number using class

public class NumberAdder {
    private int num1;
    private int num2;

    public NumberAdder(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add() {
        return num1 + num2;
    }

    public static void main(String[] args) {
        NumberAdder adder = new NumberAdder(5, 7);
        int result = adder.add();
        System.out.println("The result of adding the two numbers is: " + result);
    }
}

his code defines a class called NumberAdder which has two instance variable num1 and num2. It has a constructor which accepts two integers as parameters and assigns them to the instance variable num1 and num2. It also has a method called add() which returns the sum of num1 and num2.
In the main method, an object of the class is created and passed two integers 5 and 7 as arguments, then the add method is called on this object and the result is printed to the console using the System.out.println() method.
You can change the numbers passed in the constructor and re-run the code to get the sum of different numbers.

--------------------------------
Java code for Addition of 2 number using class. Take input from user*/


import java.util.Scanner;

class NumberAdder {
    private int num1;
    private int num2;

    public NumberAdder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        this.num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        this.num2 = scanner.nextInt();
    }

    public int add() {
        return num1 + num2;
    }

    public static void main(String[] args) {
        NumberAdder adder = new NumberAdder();
        int result = adder.add();
        System.out.println("The result of adding the two numbers is: " + result);
    }
}


/*This code defines a class called NumberAdder which has two instance variable num1 and num2. It has a constructor which accepts two integers as parameters and assigns them to the instance variable num1 and num2. It also has a method called add() which returns the sum of num1 and num2.
In the main method, an object of the class is created and passed two integers 5 and 7 as arguments, then the add method is called on this object and the result is printed to the console using the System.out.println() method.
You can change the numbers passed in the constructor and re-run the code to get the sum of different numbers.
-----------------------

Refine previous code. Pass number as parameter to function.

public class NumberAdder {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        NumberAdder adder = new NumberAdder();
        int result = adder.add(num1, num2);
        System.out.println("The result of adding the two numbers is: " + result);
    }
}

-----------------------------*/

