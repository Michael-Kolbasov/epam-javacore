package root.solution;
import com.sun.istack.internal.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Task 1) Write a recursive function for calculating factorial of a natural number N;
 */
public class Factorial {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final int number;
    private final long result;

    public Factorial() {
        number = setNumber();
        result = findFactorial(number);
        closeStream(reader);
    }

    @Override
    public String toString() {
        return number + "! = " + result;
    }

    /**
     * @param number   Number to find its factorial.
     * @return         Factorial of {@code number}.
     */
    public long findFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number should be positive.");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * findFactorial(number - 1);
    }

    private int setNumber() {
        int number = 0;
        System.out.println("Enter a number to find its factorial: ");
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