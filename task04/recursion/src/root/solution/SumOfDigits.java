package root.solution;
import com.sun.istack.internal.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Task 3) Write a recursive function: a) for calculating sum of digits of a natural number.
 */
public class SumOfDigits {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final int number;
    private final int result;

    public SumOfDigits() {
        number = setNumber();
        result = findSumOfDigits(number);
        closeStream(reader);
    }

    @Override
    public String toString() {
        return "Sum of digits of " + number + " = " + result;
    }

    /**
     * @param number    A number which digits are summarized.
     * @return          Sum of digits of {@code number}.
     */
    public int findSumOfDigits(int number) {
        if (number != 0) {
            return number % 10 + findSumOfDigits(number / 10);
        }
        return 0;
    }

    private int setNumber() {
        int number = 0;
        System.out.println("Enter a number to find sum of its digits: ");
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