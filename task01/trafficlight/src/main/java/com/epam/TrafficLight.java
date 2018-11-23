package com.epam;

/**
 * @value ANSI_RED and other String constants change the colour of console output text.
 *        It doesn't work in Windows shell, but it works in Idea and UNIX.
 */
public class TrafficLight {
    private String colour;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    private String setColour(String s) {
        return colour = s;
    }

    /**
     * If something goes wrong in constructor, the {@code colour} argument will be an error message.
     * @param currentMinute must be a non-negative digit.
     */
    public TrafficLight(double currentMinute) {
        if (currentMinute > 0 && currentMinute <= 2) {
            setColour("red");
        } else if (currentMinute > 2 && currentMinute <= 5) {
            setColour("yellow");
        }
        else if ((currentMinute > 5 && currentMinute <= 10) || currentMinute == 0) {
            setColour("green");
        } else
            setColour("Oops, this shouldn't happen. The traffic light is broken, call your system administrator");
    }

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