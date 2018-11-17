package game.players;
import game.launch.AppLauncher;
import game.launch.GameProcess;
import game.objects.Element;
import game.objects.ElementState;
import game.objects.field.GameMap;
import game.objects.ships.Ship;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides logic to a Player for the battle process.
 * {@code firePattern}   is used to check the input for correctness.
 */
public class Human extends AbstractPlayer {
    private Pattern firePattern = Pattern.compile("fire [a-j]{1,1}[0-9]{1,1}");
    private Matcher fireMatcher;
    private String userInput;

    public Human(GameProcess gameProcess) {
        super(gameProcess);
    }

    /**
     * The starting point of a firing process where the input is being checked.
     */
    @Override
    public void fire() {
        while (checkOtherInput(getUserInput())) {
            checkOtherInput(getUserInput());
        }
        int y = getY(userInput);
        int x = getX(userInput);
        GameMap enemyMap = gameProcess.getEnemyMap();
        Element[][] cells = enemyMap.getCells();
        cells[y][x].setCellChecked(true);
        if (cells[y][x].getState() == ElementState.SHIP) {
            madeShot(y, x, enemyMap, cells);
        } else {
            madeMiss();
        }
    }

    private void madeShot(int y, int x, GameMap enemyMap, Element[][] cells) {
        Ship ship = GameMap.getShipFromMap(enemyMap, y, x);
        boolean isShotAlready = false;
        Element elementInShip = ship.getElementByCoordinates(y, x);
        if (!elementInShip.isCellChecked()) {
            ship.markHit(y, x);
            cells[y][x].setSymbol('X');
        } else {
            isShotAlready = true;
        }
        if (ship.checkIsDead()) {
            if (!isShotAlready) {
                System.out.println("Ship has drowned!");
                Element[] shipBody = ship.getBody();
                for (Element element : shipBody) {
                    ArrayList<Element> surround = element.getSurround();
                    for (Element elements : surround) {
                        cells[elements.getY()][elements.getX()].setCellChecked(true);
                    }
                }
                waitOneSecond();
                if (checkIsItVictory(enemyMap)) {
                    System.out.println();
                    System.out.println("Congratulations! You have won!");
                    for (int i = 0; i < cells.length; i++) {
                        for (int j = 0; j < cells[i].length; j++) {
                            cells[i][j].setCellChecked(true);
                        }
                    }
                    waitOneSecond();
                    setVictory(true);
                    setResult(false);
                } else {
                    setResult(true);
                }
            } else {
                System.out.println("Ship has drowned! By the way, you've already shot this cell.");
                waitOneSecond();
                setResult(false);
            }
        } else {
            if (!isShotAlready) {
                System.out.println("It's a shot! Ship is injured.");
                setResult(true);
            } else {
                System.out.println("It's a shot! Ship is injured. By the way, you've already shot this cell.");
                setResult(false);
            }
            waitOneSecond();
        }
    }

    private void madeMiss() {
        System.out.println("No luck this time. You have missed.");
        System.out.println();
        waitOneSecond();
        setResult(false);
    }

    private String getUserInput() {
        try {
            userInput = GameProcess.getReader().readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    private boolean checkOtherInput(String userInput) {
        fireMatcher = firePattern.matcher(userInput);
        if (fireMatcher.matches()) {
            fireMatcher.reset();
            return false;
        } else if (userInput.equalsIgnoreCase("ships")) {
            GameMap enemyMap = gameProcess.getEnemyMap();
            int shipsLeft = GameMap.countHowManyShipsLeft(enemyMap);
            if (shipsLeft == 1) {
                System.out.println("There is " + GameMap.countHowManyShipsLeft(enemyMap) + " ship left.");
            } else {
                System.out.println("There are " + GameMap.countHowManyShipsLeft(enemyMap) + " ships left.");
            }
            enemyMap.displayEnemyMap();
            waitOneSecond();
            return true;
        } else if (userInput.equalsIgnoreCase("quit")) {
            GameProcess.closeConnection();
            System.exit(0);
        } else if (userInput.equalsIgnoreCase("menu")) {
            new AppLauncher().launchRandom();
        } else {
            System.out.println("Wrong input");
            checkOtherInput(getUserInput());
        }
        return false;
    }

    private int getY(String input) {
        input = input.toUpperCase();
        return input.charAt(input.length() - 2) - 65;
    }

    private int getX(String input) {
        return Character.digit(input.charAt(input.length() - 1), 10);
    }
}