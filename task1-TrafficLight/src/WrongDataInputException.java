//исключение для ввода отрицательного числа, нуля или слишком большого числа (Double.MAX_VALUE - 1.7*10^308)

class WrongDataInputException extends Exception {
    WrongDataInputException(String s) {
        System.err.println(s);
    }
}