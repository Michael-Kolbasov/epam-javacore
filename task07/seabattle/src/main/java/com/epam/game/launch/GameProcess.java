package com.epam.game.launch;
import com.epam.game.objects.field.GameMap;
import com.epam.game.players.Computer;
import com.epam.game.players.AbstractPlayer;
import com.epam.game.players.Human;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GameProcess is a class where the interaction of the Player and the Computer takes place.
 */
public class GameProcess {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String userInput;
    private boolean victory;
    private AbstractPlayer player;
    private AbstractPlayer enemy;

    public GameProcess() {
        player = new Human(this);
        enemy = new Computer(this);
    }

    /**
     * @return a static instance of BufferedReader. It is used in this class to start the game
     * and in the Player class to perform actions.
     */
    public static BufferedReader getReader() {
        return reader;
    }

    public static void closeConnection() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameMap getEnemyMap() {
        return enemy.getMap();
    }

    public GameMap getPlayerMap() {
        return player.getMap();
    }

    /**
     * This method starts the game.
     */
    public void process() {
        System.out.println("Enter 'Start' to start the game.");
        userInput = getUserInput();
        if (userInput.equalsIgnoreCase("start")) {
            startBattle();
        } else if (userInput.equalsIgnoreCase("quit")) {
            closeConnection();
            System.exit(0);
        } else {
            System.out.println("Wrong input");
            process();
        }
    }

    /**
     * The battle becomes!
     * It is an infinite cycle until someone wins or the "menu" or "quit" options are entered.
     */
    private void startBattle() {
        while (!getVictory()) {
            playerPerformHit();
            enemyPerformHit();
        }
        closeConnection();
        player.getMap().displayMap();
        enemy.getMap().displayEnemyMap();
    }

    private void playerPerformHit() {
        do {
            if (checkFinish()) {
                break;
            }
            player.getMap().displayMap();
            enemy.getMap().displayEnemyMap();
            System.out.println("Your time to shoot");
            player.fire();
            if (checkFinish()) {
                break;
            }
        } while (player.getResult());
    }

    private void enemyPerformHit() {
        do {
            if (checkFinish()) {
                break;
            }
            System.out.println("Enemy shoots");
            enemy.fire();
            if (checkFinish()) {
                break;
            }
        } while (enemy.getResult());
    }

    private String getUserInput() {
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    private boolean checkFinish() {
        if (checkVictory()) {
            setVictory(true);
            return true;
        } else {
            return false;
        }
    }

    private boolean checkVictory() {
        return player.getVictory() || enemy.getVictory();
    }

    private boolean getVictory() {
        return victory;
    }

    private void setVictory(boolean victory) {
        this.victory = victory;
    }
}