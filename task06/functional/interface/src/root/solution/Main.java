package root.solution;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.lambding(() -> System.out.println("Will this lambda work? Let's find out!"));
    }

    private void lambding(Applier a) {
        a.apply();
    }
}