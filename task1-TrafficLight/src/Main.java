/* Домашнее задание #1 Светофор
 * Колбасов Михаил
 * Сделать светофор с выводом цвета в консоль. Вы вводите минуту (от нуля до n) и получаете какой
 * свет горит на светофоре. Первые две минуты красный, потом три минуты желтый и пять минут зеленый. */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    /* бесконечный цикл; определяет цвет светофора, ловит исключения WrongDataInputException и NumberFormatException
       и предлагает начать ввод снова или выйти из программы */
    private void run() {
        Scanner sc = new Scanner(System.in);
        StringBuilder userInput = new StringBuilder();
        double currentMinute;

        while (true) {
            System.out.println("Enter time in minutes to get the traffic light colour: ");
            userInput.append(sc.nextLine());

            /* отрицательное число, ноль или слишком большое число (Integer.MAX_VALUE - 2_147_483_647) выбросят WrongDataInputException
             * все нечисловые данные (буквы, символы и т.д.) из ввода удаляются и парсится число. Regex: [^0-9.-]
             * пустой ввод выбросит NumberFormatException */
            try {
                currentMinute = Double.parseDouble(userInput.toString().replaceAll("[^0-9.-]", ""));

                if (currentMinute <= 0 || currentMinute > Integer.MAX_VALUE) {
                    throw new WrongDataInputException("Something bad happened, sorry. Check your input, it must be a positive number");
                }
                if (userInput.toString().isEmpty()) {
                    throw new NumberFormatException();
                }

                /* сокращаем ввод излишне большого числа до [0 - 10]
                 * здесь currentMinute может принимать значение 0, когда вводится число, кратное и больше 10 (20, 30...)
                 * это нужно для корректного определения зеленого цвета */
                while (currentMinute > 10) {
                    currentMinute %= 10;
                }

                /* здесь происходит магия определения цвета светофора
                 * (0 - 2] - красный, (2 - 5] - желтый, (5 - 10] и 0 - зеленый */
                TrafficLight trafficLight = new TrafficLight(currentMinute);
                System.out.println(trafficLight);
            } catch (WrongDataInputException | NumberFormatException e) {
                e.printStackTrace();
            }

            //очищаем ввод и предлагаем повторить или выйти из программы
            userInput.delete(0, userInput.length());
            System.out.println("\nEnter EXIT to exit or any key to continue: ");
            userInput.append(sc.nextLine());

            if (userInput.toString().equalsIgnoreCase("exit")) {
                sc.close();
                System.exit(0);
            }

            userInput.delete(0, userInput.length());
            System.out.println();
        }
    }
}
