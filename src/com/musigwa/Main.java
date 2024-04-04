package com.musigwa;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(STR."Monthly repayment: \{mortgageCalculator()}");
    }

    public static void arithmeticExpressions() {
        //        Arithmetic expressions
        double result = (double) 10 / (double) 3;
        System.out.println(result);
//        Post increment
        int increment = 2;
        increment++;
        System.out.println(increment);
        int inc = increment++;
        System.out.println(inc);
//        Preincrement
        inc = ++increment;
        System.out.println(increment);
        System.out.println(inc);
//        Compound assignment operator
        increment += 2;
        System.out.println(increment);

    }

    public static void referenceTypes() {
        // Reference types
        Date now = new Date();
        System.out.println(STR."This is the time: \{now}");
/*
        A variable referencing another is affected
        because they point to an object in the memory instead of storing the actual value
*/
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        System.out.println(point1);
        System.out.println(point2);
        point1.x = 3;
        System.out.println(point1);
        System.out.println(point2);
/*
        Strings in Java The Strings are also reference types.
        Since they are used often, there's a shortcut to initiate a String variable
        Strings are immutable, they always create a new String
*/
        String printout = "Message";
        System.out.println("Hello \n\tmusigwa");

    }

    public static void primitiveTypes() {
        //      Primitive types
        byte age = 45;
        long viewsCount = 3_010_000_432L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = true;
//      A variable referencing another isn't affected even after updating the main variable
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(x);
        System.out.println(y);
    }

    public static void arrayOperations() {
//        Arrays (have a fixed length, and it should be defined )
        int[] number = {12, 4, 5, 234, 2, 334, 23};
        number[0] = 89;
        System.out.println(number.length);
        System.out.println(Arrays.toString(number));
        Arrays.sort(number);
        System.out.println(Arrays.toString(number));
//        Multi dimensional arrays
        int[][][] d3 = new int[2][3][7];
        int[][] d2 = {{12, 23, 23,}, {323, 23, 2, 23}};
        d3[1][2][4] = 2;
        System.out.println(Arrays.deepToString(d2));
        System.out.println(Arrays.deepToString(d3));
        final float pi = (float) 3.14;
    }

    public static void typeCasting() {
        /*
        Casting and type conversion
        Implicit (automatic) casting byte > short > int > long > float > double
*/
        double r = 1.1;
        int t = (int) r + 2;
        System.out.println(t);
        System.out.println(Double.parseDouble("34.4"));
//        Math class
        int res = (int) Math.ceil(1.1);
        System.out.println(Math.round(45.5));
        System.out.println((int) (Math.random() * 100));
//        Format numbers
        String results = NumberFormat.getPercentInstance().format(.2);
        System.out.println(results);
    }

    public static boolean conditionalOperations(int x, int y) {
        //        Comparison operations
        System.out.println(x == y);
        String role = "admin";
        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;
            case "moderator":
                System.out.println("You're a moderator");
                break;
            default:
                System.out.println("You're a guest");
                break;
        }
        return x == y;
    }

    public static void readInputs(Scanner scanner) {
//        Reading inputs
        System.out.print("Enter your age: ");
        String aging = scanner.nextLine();
        System.out.println(STR."You're \{aging.trim()}");
        double mortgage = mortgageCalculator();
        System.out.println(STR."Mortgage: \{NumberFormat.getCurrencyInstance().format(mortgage)}");
    }

    public static double mortgageCalculator() {
        Scanner scanner = new Scanner(System.in);
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final int THOUSAND = 1_000;
        final int MILLION = 1_000_000;
        int principal = 0;
        System.out.println("Principal (RF1K - RF1M):");
        while (true) {
            principal = scanner.nextInt();
            if (principal >= THOUSAND && principal <= MILLION) break;
            else System.out.println("Enter a number between 1,000 - 1,000,000.");
        }
        System.out.println("Annual Interest Rate:");
        float annualInterestRate = 0;
        String between0And30 = "Enter a value between (0 and 30).";
        while (true) {
            annualInterestRate = scanner.nextInt();
            if (annualInterestRate > 0 && annualInterestRate <= 30) break;
            else System.out.println(between0And30);
        }

        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        byte years = 0;
        System.out.println("Years:");
        while (true) {
            years = scanner.nextByte();
            if (years > 0 && years <= 30) break;
            else System.out.println(between0And30);
        }

        int numberOfPayments = years * MONTHS_IN_YEAR;
        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;
    }

    public static void fizzBuzz(Scanner scanner) {
        System.out.print("Please input an integer number: ");
        int value = scanner.nextInt();
        String fizzBuzz;
        if ((value % 3) == 0 && (value % 5) == 0) fizzBuzz = "FizzBuzz";
        else if ((value % 5) == 0) fizzBuzz = "Buzz";
        else if ((value % 3 == 0)) fizzBuzz = "Fizz";
        else fizzBuzz = Integer.toString(value);
        System.out.println(fizzBuzz);
    }

    public void iterationStatements(Scanner scanner) {
        String input = scanner.next().toLowerCase();
//        While loop
        while (!input.equals("quit")) {
            System.out.print("Please input an integer number: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass")) continue;
            if (input.equals("quit")) break;
            System.out.println(input);
        }

//        Do while loop

        do {
            System.out.print("Please input an integer number: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass")) continue;
            if (input.equals("quit")) break;
            System.out.println(input);
        } while (!input.equals("quit"));

//        For loop

        String[] fruits = {"orange", "apple", "mango"};
        for (int i = 0; i < fruits.length; i++)
            System.out.println(fruits[i]);
//        Foreach loop
        for (String fruit : fruits) System.out.println(fruit);
    }
}
