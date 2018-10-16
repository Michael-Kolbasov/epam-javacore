package root.solution;
import java.util.Scanner;

/**
 * @author Michael Kolbasov
 *
 *  Recursion
 *      Task 1) Write a rucirsive function for calculating factorial of a natural number N;
 *      Task 2) Write a rucirsive function for calculating power N of a real number N (N - natural number);
 *      Task 3) Write a recursive function:
 *                  a) for calculation sum of digits of a natural number;
 *                  b) for calculationg amount of digits of a natural number.
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Find factorial
        System.out.print("Enter a number to find its factorial: ");
        int factorialBase = sc.nextInt();
        Factorial f = new Factorial();
        int factorialResult = 0;
        for(int i = factorialBase; i > 2; i--) {
            factorialResult += f.findFactorial(i);
        }
        System.out.println(factorialBase + "! = " + factorialResult);

        //Find power
        Power pow = new Power();
        System.out.println("Enter a number to find its power:");
        int base = sc.nextInt();
        System.out.println("Enter power:");
        int power = sc.nextInt();
        int result = 0;
        for (int i = power; i > 1; i--) {
            result = pow.findPower(power, base);
        }
        System.out.println(base + " to the power " + power + " is: " + result);

        //Find sum of digits
        SumOfDigits sumOfDigits = new SumOfDigits();
        System.out.println("Enter number to get sum of its digits: ");
        int numberToSumDigits = sc.nextInt();
        int resultOfDigitsSum = sumOfDigits.findSumOfDigits(numberToSumDigits);
        System.out.println("Sum of digits of a number " + numberToSumDigits + " is: " + resultOfDigitsSum);

        //Find amount of digits
        AmountOfDigits aod = new AmountOfDigits();
        System.out.println("Enter number to find the amount of its digits:");
        int numberToDigitsAmount = sc.nextInt();
        int digitsInNumber = aod.findAmountOfDigits(numberToDigitsAmount);
        System.out.println("Amount of digits of a number " + numberToDigitsAmount + " is: " + digitsInNumber);
    }
}