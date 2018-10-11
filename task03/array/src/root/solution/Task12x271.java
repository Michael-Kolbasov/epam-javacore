package root.solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 12.271
 * Write a program that prints a word, built by symbols of several following indexes from some line of an array.
 */

public class Task12x271 extends AbstractTask {
    private Integer[] indexes;

    public Task12x271() {
        dataArray = fillArray();
        indexes = fillIndexes();
        result = resolveTask(dataArray, indexes);
    }

    /**
     * This constructor is used for tests.
     */
    public Task12x271(Integer[] indexes) {
        dataArray = fillArray();
        this.indexes = indexes;
        result = resolveTask(dataArray, indexes);
    }

    public Integer[] getIndexes() {
        return indexes;
    }

    /**
     * @return a word, built by symbols of several following {@param indexes} from some line of an {@param array}.
     */
    public String resolveTask(Character[][] array, Integer[] indexes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append("\n");
            stringBuilder.append("\tRow ").append(i).append(": ");
            for (int j = 0; j < array[i].length; j++) {
                if (j >= indexes[0] && j <= indexes[indexes.length - 1]) {
                    stringBuilder.append(array[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * @throws IllegalArgumentException if {@code input} is null, empty, too short or too long,
     *                                  if {@code input} contains of any number but 0, 1, 2, 3 or 4.
     *                                  if {@code input} is not an appropriate growing by one numeric sequence.
     */
    public Integer[] fillIndexes() {
        String userInput = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please, enter indexes for task 2. Example: 0 1 2 or 012. Indexes are 0-based.");
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char lowBorder = '0';
        char highBorder = '4';
        if (userInput == null || userInput.length() == 0) {
            throw new IllegalArgumentException("Wrong input. Must enter at least one index. Your input: " + userInput);
        }
        userInput = userInput.replaceAll(" ", "");
        if (userInput.length() > 4) {
            throw new IllegalArgumentException("Wrong input. Must enter less than 5 indexes. Your input: " + userInput);
        }
        if (userInput.charAt(0) < lowBorder || userInput.charAt(userInput.length() - 1) > highBorder) {
            throw new IllegalArgumentException("Please, enter numbers between 0 and 4 including. Your input: " + userInput);
        }
        for (int i = 1; i < userInput.length(); i++) {
            if (userInput.charAt(i) < userInput.charAt(i - 1) || userInput.charAt(i) - userInput.charAt(i - 1) != 1) {
                throw new IllegalArgumentException("Please, enter a correct sequence of indexes. It must be a growing by one numeric sequence between 0 and 4. Your input: " + userInput);
            }
        }
        Integer[] array = new Integer[userInput.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.digit(userInput.charAt(i), 10);
        }
        return array;
    }
}