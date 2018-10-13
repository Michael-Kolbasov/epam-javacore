package root.solution;

public class SumOfDigits {

    public int findSumOfDigits(int number) {
        int result = 0;
        if (number != 0) {
            result = number % 10 + findSumOfDigits(number / 10);
        }
        return result;
    }
}
