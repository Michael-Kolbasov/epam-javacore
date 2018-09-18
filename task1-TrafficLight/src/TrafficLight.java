public class TrafficLight {
    //здесь храним цвет светофора
    private String colour;

    //строковые константы для изменения цвета текста вывода
    //не работает в Windows shell, но работает в Idea и Unix
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    private String setColour(String s) {
        return colour = s;
    }

    //если в конструкторе при инициализации что-то пошло не по плану, вместо цвета передастся строка о поломке
    TrafficLight(double currentMinute) {
        if (currentMinute > 0 && currentMinute <= 2) {
            setColour("red");
        } else if (currentMinute > 2 && currentMinute <= 5) {
            setColour("yellow");
        }
        //currentMinute == 0 нужно для проверки ввода чисел, которые больше и кратны 10 (20, 30...).
        //currentMinute == 0 на изначальном вводе с клавиатуры выбрасывает WrongDataInputException
        else if ((currentMinute > 5 && currentMinute <= 10) || currentMinute == 0) {
            setColour("green");
        } else
            setColour("Oops, this shouldn't happen. The traffic light is broken, call your system administrator");
    }

    //здесь выводим цвет светофора
    @Override
    public String toString() {
        switch (colour) {
            case ("red") :
                return ANSI_RED + "The light is " + colour + ANSI_RESET;
            case ("yellow") :
                return ANSI_YELLOW + "The light is " + colour + ANSI_RESET;
            case ("green") :
                return ANSI_GREEN + "The light is " + colour + ANSI_RESET;
            default:
                return colour;
        }
    }
}