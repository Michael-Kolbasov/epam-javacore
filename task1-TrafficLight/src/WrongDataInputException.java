//исключение для ввода отрицательного числа, нуля или слишком большого числа (Integer.MAX_VALUE - 2_147_483_647)

class WrongDataInputException extends Exception {
    WrongDataInputException(String s) {
        System.err.println(s);
    }
}