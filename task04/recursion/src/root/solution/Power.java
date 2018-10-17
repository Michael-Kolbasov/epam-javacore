package root.solution;
import com.sun.istack.internal.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Task 2) Write a recursive function for calculating power A of a real number N (N - natural number);
 */
public class Power extends AbstractTask {
    private final int number;
    private final int power;
    private final long result;

    public Power() {
        number = setNumber();
        power = setPower();
        result = findPower(power, number);
        closeStream(reader);
    }

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