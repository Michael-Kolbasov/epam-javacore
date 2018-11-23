package com.epam;

/**
 *
 *  com.epam.Task #2 String Manipulations
 *  @author Michael Kolbasov
 *
 *  Given a word. Output its:
 *  1) third symbol;
 *  2) last symbol;
 *  3) K-th symbol;
 *
 *  4) Given a sentence. Find the amount of identical adjacent symbols in it;
 *  5) Given a word. Flip its second and fifth letters;
 *  6) Enter a sentence from keyboard. Flip its letters. Example: this code is great -> siht edoc si taerg.
 */
public class Main {

    public static void main(String[] args) {
        Task task = new Task("Check for the fourth task: a bb ccc 4444 ccc"); //12 adjacent symbols
        System.out.println("Initial message: \n" + task.getMessage() + "\n");

        System.out.println(task.doFirstTask(task) + "\n");
        waitTwoSeconds();

        System.out.println(task.doSecondTask(task) + "\n");
        waitTwoSeconds();

        System.out.println(task.doThirdTask(task) + "\n");
        waitTwoSeconds();

        System.out.println(task.doFourthTask(task) + "\n");
        waitTwoSeconds();

        System.out.println(task.doFifthTask(task) + "\n");
        waitTwoSeconds();

        System.out.println(task.doSixthTask());
    }

    private static void waitTwoSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}