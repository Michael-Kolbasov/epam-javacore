package root.solution;
import java.io.IOException;

/**
 * Task 2) Write a recursive function for calculating power A of a real number N (N - natural number);
 */
public class Power extends AbstractTask {
    private int power;

    public Power() {
        number = setNumber();
        power = setPower();
        result = findPower(power, number);
        closeStream(reader);
    }

    /**
     * This constructor is for tests.
     * @param dummy Any number.
     */
    public Power(int dummy) { }

    @Override
    public String toString() {
        return number + "^" + power + " = " + result;
    }

    /**
     * @param number    Number for calculating.
     * @param power     Power for calculating.
     * @return          Number {@code number} in power {@code power}.
     */
    public long findPower(int number, int power) {
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return number;
        }
        return number * findPower(number, power - 1);
    }

    private int setPower() {
        int power = 0;
        System.out.println("Enter power: ");
        try {
            power = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return power;
    }
}