package com.epam;

/**
 * com.epam.Field class provides common distance length for all horse to run.
 * 1600 meters is an average length for hippodrome field due to google.
 */
public class Field {
    private int length = 1600;
    private int finishing = length - 400;

    public int getLength() {
        return length;
    }

    public int getFinishing() {
        return finishing;
    }
}