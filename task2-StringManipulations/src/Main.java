import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Дано слово. Вывести на экран:
 * 1) его третий символ
 * 2) его последний символ
 * 3) его k-ый символ
 * 4) Дано предложение. Определить, сколько в нем одинаковых соседних букв
 * 5) Дано слово. Поменять местами его вторую и пятую буквы.
 * 6) Ввести предложение с консоли. Сделать реверт букв. Пример: каша вкусная - ашак яансукв.
 */

public class Main {

    public static void main(String[] args) {
        String message = "Check for the fourth task: a bb ccc 4444 ccc"; //12
        System.out.println("Initial message: \n" + message + "\n");

        doFirstTask(message);
        waitTwoSeconds();

        doSecondTask(message);
        waitTwoSeconds();

        doThirdTask(message);
        waitTwoSeconds();

        doFourthTask(message);
        waitTwoSeconds();

        doFifthTask(message);
        waitTwoSeconds();

        doSixthTask();

    }

    /**
     * Prints the third symbol from the {@code string}.
     */
    private static void doFirstTask(@NotNull String string) {
        System.out.println("First task:");
        System.out.println(string.charAt(2) +"\n");
    }

    /**
     * Prints the last symbol from the {@code string}
     */
    private static void doSecondTask(@NotNull String string) {
        System.out.println("Second task:");
        System.out.println(string.charAt(string.length() - 1) + "\n");
    }

    /**
     * Prints the {@code position - input via keyboard} symbol from the {@code string}.
     * Index count starts from 0.
     * @throws InputMismatchException if the input is not a digit.
     */
    private static void doThirdTask(@NotNull String string) {
        System.out.println("Third task:");
        System.out.println("Please, enter a symbol position number.");
        try (Scanner sc = new Scanner(System.in)) {
            int position = sc.nextInt();
            System.out.println("Your letter is: " + string.charAt(position) + "\n");
        } catch (InputMismatchException e) {
            System.err.println("Please, enter a digit.");
        }
    }

    /**
     * Prints the amount of identical adjacent symbols in the {@param string}.
     */
    private static void doFourthTask(@NotNull String string) {
        System.out.println("Fourth task:");
        int count = 0;
        boolean isNeighbor = false;
        for (int i = 0; i < string.length(); i++) {
            if (i == string.length() - 1) {
                if (isNeighbor) {
                    count++;
                }
                break;
            } else if (string.charAt(i) == string.charAt(i + 1)) {
                count++;
                isNeighbor = true;
            }
            if (isNeighbor) {
                if (string.charAt(i) != string.charAt(i + 1)) {
                    count++;
                    isNeighbor = false;
                }
            }
        }
        System.out.println("This string has " + count + "identical adjacent symbols.\n");
    }

    /**
     * Changes the second and fifth symbols in the {@code string} and prints it.
     */
    private static void doFifthTask(@NotNull String string) {
        System.out.println("Fifth task:");
        if (string.length() < 5) {
            System.out.println("Input is too short, must be 5 or more symbols");
            return;
        }
        char[] letters = string.toCharArray();
        char secondChar = letters[1];
        char fifthChar = letters[4];
        letters[1] = fifthChar;
        letters[4] = secondChar;
        String modifiedString = new String(letters);
        System.out.println("Modified string: \n" + modifiedString);
    }

    /**
     * Flips the words in the {@code userInput} backwards.
     * Note: it flips the words, not the whole sentence.
     */
    private static void doSixthTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter something:");
        String userInput = sc.nextLine();
        String[] array = userInput.split("\\W");
        StringBuilder modifiedString = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            temp.append(array[i]).reverse().append(" ");
            modifiedString.append(temp);
            temp.setLength(0);
        }
        System.out.println("Your reversed words are: \n" + modifiedString);
    }

    private static void waitTwoSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
