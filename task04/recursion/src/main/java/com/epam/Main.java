package com.epam;

/**
 * @author Michael Kolbasov
 *
 *  Recursion
 *      Task 1) Write a recursive function for calculating factorial of a natural number N;
 *      Task 2) Write a recursive function for calculating power A of a real number N (N - natural number);
 *      Task 3) Write a recursive function:
 *                  a) for calculating sum of digits of a natural number;
 *                  b) for calculating amount of digits of a natural number.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a number to find its factorial:\n" + new Factorial());
        System.out.println("Enter a number to find its power:\n" + new Power());
        System.out.println("Enter a number to find sum of its digits:\n" + new SumOfDigits());
        System.out.println("Enter a number to find amount of its digits:\n" + new AmountOfDigits());
    }
}