package root.solution;
import com.sun.istack.internal.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Task 1) Write a recursive function for calculating factorial of a natural number N;
 */
public class Factorial extends AbstractTask {
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
}