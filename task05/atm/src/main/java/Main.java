package main.java;

/**
 * Task #5 Thread-safe Automated Teller Machine
 * @author Michael Kolbasov
 */
public class Main {

    public static void main(String[] args) {
        ATMRunnable atmRunnable = new ATMRunnable();
        Thread thread = new Thread(atmRunnable);
        thread.start();
        Thread thread1 = new Thread(atmRunnable);
        thread1.start();
        Thread thread2 = new Thread(atmRunnable);
        thread2.start();
    }
}