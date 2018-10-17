package root.solution;
import com.sun.istack.internal.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Task 3) Write a recursive function: b) for calculating amount of digits of a natural number.
 */
public class AmountOfDigits {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final int number;
    private final int result;

    public AmountOfDigits() {
        number = setNumber();
        result = findAmountOfDigits(number);
        closeStream(reader);
    }

    @Override
    public String toString() {
        return "The amount of digits in number " + number + " = " + result;
    }

    /**
     * @param number    A number to calculate the amount of its digits.
     * @return          The amount of digits of {@code number}.
     */
    public int findAmountOfDigits(int number) {
        if (number < 0) {
            number *= -1;
        }
        if (number < 10) {
            return 1;
        } else {
            return 1 + findAmountOfDigits(number / 10);
        }
    }

    private int setNumber() {
        int number = 0;
        System.out.println("Enter a number to find the amount of its digits: ");
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return number;
    }

    private void closeStream(@NotNull BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}