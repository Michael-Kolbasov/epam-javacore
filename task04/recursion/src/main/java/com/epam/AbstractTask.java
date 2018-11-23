package com.epam;
import com.sun.istack.internal.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class provides common methods {@code setNumber()} and {@code closeStream()}
 * and fields BufferedReader {@code reader}, {@code int number} and {@code long result} for all tasks.
 */
public abstract class AbstractTask {
    protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected int number;
    protected long result;

    protected int setNumber() {
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return number;
    }

    protected void closeStream(@NotNull BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}