package root.solution;

/**
 * Task 1) Write a recursive function for calculating factorial of a natural number N;
 */
public class Factorial extends AbstractTask {
    private int number;
    private long result;

    public Factorial() {
        number = setNumber();
        result = findFactorial(number);
        closeStream(reader);
    }

    /**
     * This constructor is for tests.
     * @param dummy Any number.
     */
    public Factorial(int dummy) { }

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
            throw new IllegalArgumentException("Number should be positive. Your input: " + number);
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * findFactorial(number - 1);
    }
}