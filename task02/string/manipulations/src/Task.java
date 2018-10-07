import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Task {
    private String message;

    public Task(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    /**
     * @throws  IllegalArgumentException if the {@code message} is null or its length is less than 3.
     * @return  third symbol in the {@code message}.
     */
    public char doFirstTask(Task task) {
        System.out.println("First task.");
        if (task.getMessage() == null || task.getMessage().length() < 3) {
            throw new IllegalArgumentException("Sentence must have at least 3 symbols.");
        }
        System.out.println("The third symbol is:");
        return getMessage().charAt(2);
    }

    /**
     * @throws  IllegalArgumentException if the {@code message} is null or empty.
     * @return  last symbol in the {@code message}.
     */
    public char doSecondTask(Task task) {
        System.out.println("Second task.");
        if (task.getMessage() == null || task.getMessage().length() == 0) {
            throw new IllegalArgumentException("Error: empty string.");
        }
        System.out.println("The last symbol is:");
        return getMessage().charAt(getMessage().length() - 1);
    }

    /**
     * Note:    Index count starts from 0.
     * @throws  InputMismatchException if the {@code position} is not a digit.
     * @throws  IllegalArgumentException if the {@code message} is null or empty.
     * @return  K-th symbol {@code position - input via keyboard} in the {@code message}.
     */
    public char doThirdTask(Task task) {
        System.out.println("Third task.");
        if (task.getMessage() == null || task.getMessage().length() == 0) {
            throw new IllegalArgumentException("Error: empty string.");
        }
        char output = '\u0000';
        int position = 0;
        System.out.println("Please, enter a symbol position number. Index count starts from 0.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            position = Integer.parseInt(input);
            output = task.getMessage().charAt(position);
        } catch (IOException | StringIndexOutOfBoundsException e) {
            System.err.println("Please, enter a positive and not too big number. Length of message is: "
                    + task.getMessage().length());
        }
        System.out.println(position + " symbol is:");
        return output;
    }

    /**
     * @throws  IllegalArgumentException if the {@code message} is null or empty.
     * @return  amount of identical adjacent symbols in the {@code message}.
     */
    public int doFourthTask(Task task) {
        System.out.println("Fourth task.");
        if (task.getMessage() == null || task.getMessage().length() == 0) {
            throw new IllegalArgumentException("Error: empty string.");
        }
        int count = 0;
        boolean isNeighbor = false;

        for (int i = 0; i < task.getMessage().length(); i++) {
            if (i == task.getMessage().length() - 1) {
                if (isNeighbor) {
                    count++;
                }
                break;
            } else if (task.getMessage().charAt(i) == task.message.charAt(i + 1)) {
                count++;
                isNeighbor = true;
            }
            if (isNeighbor) {
                if (task.getMessage().charAt(i) != task.getMessage().charAt(i + 1)) {
                    count++;
                    isNeighbor = false;
                }
            }
        }
        System.out.println("This sentence has following amount of identical adjacent symbols:");
        return count;
    }

    /**
     * @throws  IllegalArgumentException if the {@code message} is null or its length is less than 5.
     * @return  modified {@code message} which second and fifth symbols are flipped.
     */
    public String doFifthTask(Task task) {
        System.out.println("Fifth task.");
        if (task.getMessage() == null || task.getMessage().length() < 5) {
            throw new IllegalArgumentException("Input is too short, must be 5 or more symbols.");
        }
        char[] letters = task.getMessage().toCharArray();
        char secondChar = letters[1];
        char fifthChar = letters[4];
        letters[1] = fifthChar;
        letters[4] = secondChar;
        System.out.println("Changed second and fifth symbols:");
        return new String(letters);
    }

    /**
     * Note: it flips the words, not the whole sentence.
     * @throws  IllegalArgumentException if the {@code message} is empty.
     * @return  modified {@code userInput} with flipped letters in the words.
     */
    public String doSixthTask() {
        System.out.println("Sixth task.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter something:");
        String userInput = "";
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (userInput.length() == 0) {
            throw new IllegalArgumentException("Error: empty string.");
        }
        String[] array = userInput.split("\\W");
        StringBuilder modifiedString = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).reverse().append(" ");
            modifiedString.append(temp);
            temp.setLength(0);
        }
        System.out.println("Your flipped words are:");
        return modifiedString.toString();
    }
}
