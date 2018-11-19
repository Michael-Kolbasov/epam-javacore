package root.solution;

/**
 * Task #6 Lambda
 * Create a functional interface and use it with lambda expression.
 * @author Michael Kolbasov
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.lambding(() -> System.out.println("Will this lambda work? Let's find out!"));
        int x = 5;
        int y = 10;
        int z = main.summing((a, b) -> (a + b), x, y);
        main.lambding(() -> System.out.println(z));
    }

    private void lambding(Applier a) {
        a.apply();
    }

    private int summing(Summer summer, int a, int b) {
        return summer.apply(a, b);
    }
}