package root.solution;

public class Power {

    public int findPower(int power, int base) {
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return base;
        }
        int result;
        result = findPower(power - 1, base) * base;
        return result;
    }
}