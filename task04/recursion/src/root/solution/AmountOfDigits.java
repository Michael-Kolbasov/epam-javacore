package root.solution;

/**
 * Task 3) Write a recursive function: b) for calculating amount of digits of a natural number.
 */
public class AmountOfDigits extends AbstractTask {
    private int number;
    private int result;

    public AmountOfDigits() {
        number = setNumber();
        result = findAmountOfDigits(number);
        closeStream(reader);
    }

    /**
     * This constructor is for tests.
     * @param dummy Any number.
     */
    public AmountOfDigits(int dummy) { }

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
}