package com.epam;

/**
 * Task 3) Write a recursive function: a) for calculating sum of digits of a natural number.
 */
public class SumOfDigits extends AbstractTask {

    public SumOfDigits() {
        number = setNumber();
        result = findSumOfDigits(number);
        closeStream(reader);
    }

    /**
     * This constructor is for tests.
     * @param dummy Any number.
     */
    public SumOfDigits(int dummy) { }

    @Override
    public String toString() {
        return "Sum of digits of " + number + " = " + result;
    }

    /**
     * @param number    A number which digits are summarized.
     * @return          Sum of digits of {@code number}.
     */
    public long findSumOfDigits(int number) {
        if (number < 0) {
            number *= -1;
        }
        if (number != 0) {
            return number % 10 + findSumOfDigits(number / 10);
        }
        return 0;
    }
}