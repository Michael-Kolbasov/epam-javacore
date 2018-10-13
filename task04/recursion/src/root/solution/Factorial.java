package root.solution;

class Factorial {

    public int findFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        if(n == 0 || n == 1) return 1;
        int result;
        result = findFactorial(n - 1) * n;
        return result;
    }
}