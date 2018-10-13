package root.solution;

public class AmountOfDigits {

    public int findAmountOfDigits(int num) {
        if (num < 0) {
            num *= -1;
        }
        if (num < 10) {
            return 1;
        } else {
            return 1 + findAmountOfDigits(num / 10);
        }
    }
}