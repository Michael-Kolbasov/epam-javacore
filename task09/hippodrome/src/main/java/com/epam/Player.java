package com.epam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * com.epam.Player class provides methods for betting money and continuing or quiting the game.
 */
public class Player {
    private int money;
    private int bet;
    private Game game;
    private List<Horse> horses;
    BufferedReader reader;

    public Player(Game game) {
        money = 1000;
        this.game = game;
        horses = game.getHorses();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * This method makes it possible to bet on a com.epam.Horse from the com.epam.Game instance.
     * @return  com.epam.Horse that player bets on.
     */
    public Horse chooseAHorse() {
        System.out.println("Choose a horse between:");
        for (Horse horse : horses) {
            System.out.println(horse);
        }
        String horseBettingName = "";
        try {
            horseBettingName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Horse horse : horses) {
            if (horseBettingName.equalsIgnoreCase(horse.getName())) {
                return horse;
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("com.epam.Horse wasn't chosen.");
    }

    /**
     * Here player makes a bet.
     * It is impossible to bet less than 200 or more that player's money left.
     */
    public void makeABet() {
        if (money < 200) {
            System.out.println("You don't have enough money, good bye!");
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        } else {
            System.out.println("Enter your bet:");
            String userInput = "";
            try {
                userInput = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Pattern betPattern = Pattern.compile("[0-9]+");
            Matcher betMatcher = betPattern.matcher(userInput);
            if (betMatcher.matches()) {
                bet = Integer.parseInt(userInput);
                if (bet < 200 || bet > money) {
                    System.out.println("Minimal bet is 200. Wrong bet or you don't have enough money. Your input: " + userInput);
                    makeABet();
                } else {
                    System.out.println("You bet " + bet);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    placeBet(bet);
                }
            } else {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException("Wrong input. " + "\"" + userInput + "\"" + " is not a bet.");
            }
        }
    }

    public void win() {
        money += bet * 2;
    }

    public boolean checkQuit() {
        System.out.println("Do you want to quit? Enter 'yes' or 'no'.");
        String userInput = "";
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (userInput.equalsIgnoreCase("yes")) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        return false;
    }

    public int getMoney() {
        return money;
    }

    private void placeBet(int bet) {
        money -= bet;
    }
}