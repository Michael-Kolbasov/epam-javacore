package root.solution;

/**
 * Task 3) Write a recursive function: a) for calculating sum of digits of a natural number.
 */
public class SumOfDigits extends AbstractTask {
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
}