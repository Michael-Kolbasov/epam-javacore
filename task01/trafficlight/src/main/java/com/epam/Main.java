package com.epam;

import java.util.Scanner;

/**
 * Task #1 Traffic light
 * @author Michael Kolbasov
 * Create a traffic light that outputs a signal colour. You enter a minute (from zero to n) and get
 * a current signal light. First two minutes is red light, next three minutes is yellow and last five minutes is green.
 */
public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * Infinite cycle. Defines a signal and asks if you want to continue defining or to exit program.
     * All non-numeric data (letters, symbols etc.) is deleted from the input and the number is parsed.
     * @throws  WrongDataInputException
     *          If the {@code currentMinute} argument is a negative number, zero or a too big number.
     * @throws  NumberFormatException
     *          If the {@code userInput} is empty.
     */
    private void run() {
        Scanner sc = new Scanner(System.in);
        StringBuilder userInput = new StringBuilder();
        double currentMinute;

        while (true) {
            System.out.println("Enter time in minutes to get the traffic light colour: ");
            userInput.append(sc.nextLine());
            try {
                currentMinute = Double.parseDouble(userInput.toString().replaceAll("[^0-9.-]", ""));
                if (currentMinute <= 0 || currentMinute > Double.MAX_VALUE) {
                    throw new WrongDataInputException("Something bad happened, sorry. Check your input, it must be a positive number");
                }
                while (currentMinute > 10) {
                    currentMinute %= 10;
                }
                TrafficLight trafficLight = new TrafficLight(currentMinute);
                System.out.println(trafficLight);
            } catch (WrongDataInputException | NumberFormatException e) {
                e.printStackTrace();
            }
            userInput.delete(0, userInput.length());
            System.out.println("\nEnter EXIT to exit or any key to continue: ");
            userInput.append(sc.nextLine());
            if (userInput.toString().equalsIgnoreCase("exit")) {
                sc.close();
                break;
            }
            userInput.delete(0, userInput.length());
            System.out.println();
        }
    }
}