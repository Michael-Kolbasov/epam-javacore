package root.solution;
import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class provides common methods {@code setNumber()} and {@code closeStream()}
 * and BufferedReader {@code reader} for all tasks.
 */
public abstract class AbstractTask {
    protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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