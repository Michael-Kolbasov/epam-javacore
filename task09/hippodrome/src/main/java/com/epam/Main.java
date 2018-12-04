package com.epam;

/**
 * Task #9
 * Create a hippodrome.
 *  Player makes a bet on a horse. Horses have their own constant speed and random acceleration speed.
 *  Each running horse represents a unique thread, so that all horses run in a parallel fashion.
 *
 * @author Michael Kolbasov
 */
public class Main {

    public static void main(String[] args) {
        new Game().launch();
    }
}