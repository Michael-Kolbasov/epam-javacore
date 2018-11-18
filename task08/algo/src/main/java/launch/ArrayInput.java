package launch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides resources for initial input array and then getting copy of this array for all sorting algorithms.
 * {@code} digitsPattern is a pattern that checks if an input consists from digits.
 * {@throws}    IllegalArgumentException if {@code input} result does not match {@code} digitsPattern.
 * {@throws}    IllegalArgumentException if {@code input} result length is less than 2.
 */
public class ArrayInput {
    private int[] arrayToSort;
    private Pattern digitsPattern = Pattern.compile("[0-9]+");

    public ArrayInput() {
        arrayToSort = input();
    }

    public int[] getArrayToSort() {
        return arrayToSort;
    }

    public int[] getCopyOfInputArray() {
        return Arrays.copyOf(getArrayToSort(), getArrayToSort().length);
    }

    private int[] input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers for the array in one line separated by whitespaces. Example: 12 8 100 15");
        String userInput = "";
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] inputChunks = userInput.split(" ");
        for (String string : inputChunks) {
            Matcher digitsMatcher = digitsPattern.matcher(string);
            if (!digitsMatcher.matches()) {
                throw new IllegalArgumentException("Wrong input. \"" + string + "\" is not a number");
            }
        }
        arrayToSort = new int[inputChunks.length];
        if (arrayToSort.length < 2) {
            throw new IllegalArgumentException("Wrong input. Quantity of numbers must be at least 2. Your quantity: " +
            arrayToSort.length);
        }
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = Integer.parseInt(inputChunks[i]);
        }
        return arrayToSort;
    }
}