package com.epam.algorithms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A Binary Search realization class.
 * It finds an element position in an already sorted array and returns its position number.
 * If no such element found, it returns -1.
 *
 * {@code digitsPattern} is a pattern for checking number to find input. If input does not match this pattern,
 *                      it throws IllegalArgumentException.
 * {@throws} IllegalArgumentException.
 */
public class BinarySearch {
    private Pattern digitsPattern = Pattern.compile("[0-9]+");

    public int search(int[] targetArray) {
        int elementToFind = enterElementToFind();
        int lowerBound = 0;
        int highBound = targetArray.length - 1;

        while(lowerBound <= highBound) {
            int middleBound = lowerBound + (highBound - lowerBound) / 2;
            if (elementToFind < targetArray[middleBound]) {
                highBound = middleBound - 1;
            } else if (elementToFind > targetArray[middleBound]) {
                lowerBound = middleBound + 1;
            } else {
                return middleBound;
            }
        }
        return -1;
    }

    private int enterElementToFind() {
        System.out.println("Enter a number in array to find its position: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String element = "";
        try {
            element = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int elementToFind;
        Matcher digitsMatcher = digitsPattern.matcher(element);
        if (!digitsMatcher.matches()) {
            throw new IllegalArgumentException(element + " is not a number");
        } else {
            elementToFind = Integer.parseInt(element);
        }
        return elementToFind;
    }
}