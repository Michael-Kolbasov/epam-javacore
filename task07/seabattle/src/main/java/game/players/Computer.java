package game.players;
import game.launch.GameProcess;
import game.objects.Element;
import game.objects.ElementState;
import game.objects.field.GameMap;
import game.objects.ships.Ship;
import java.util.ArrayList;
import java.util.Random;

/**
 * Computer class provides AI logic for the battle process.
 * <p>
 * {@code hunting}  is set when a first hit on a non-1-deck-ship occurs for remembering the coordinates and changing
 * hit logic from random to consistent.
 * {@code directingLock}    happens when {@code hunting} is true and it is a second hit on a non-2-deck-ship.
 * {@code firstHitY} is a Y coordinate of a first hit.
 * {@code firstHitX} is a X coordinate of a first hit.
 * firstHitY and firstHitX help to remember the initial position to perform hunt.
 * {@code updatedY} is used when searching other ship's cells.
 * {@code updatedX} same.
 * {@code direction} is used when hunting to define the direction of a large ship.
 * {@code listOfDirections} is just of all directions.
 * <p>
 * Note: when some direction becomes invalid due to a miss hit or an invalid cell coordinates
 * (like {-1;0}, for example), this direction becomes removed from the list. It is later refilled.
 */
public class Computer extends AbstractPlayer {
    private boolean hunting;
    private boolean directionLock;
    private int firstHitY;
    private int firstHitX;
    private int updatedY;
    private int updatedX;
    private ShootDirection direction;
    private ArrayList<ShootDirection> listOfDirections;

    private enum ShootDirection {
        UP, DOWN, LEFT, RIGHT;

        public ShootDirection revert() {
            if (this == UP) {
                return DOWN;
            } else if (this == DOWN) {
                return UP;
            } else if (this == LEFT) {
                return RIGHT;
            } else if (this == RIGHT) {
                return LEFT;
            } else {
                return null;
            }
        }
    }

    public Computer(GameProcess gameProcess) {
        super(gameProcess);
        listOfDirections = refillDirections();
    }

    /**
     * This method defines if a Computer shoots randomly or is hunting a ship.
     */
    @Override
    public void fire() {
        GameMap enemyMap = gameProcess.getPlayerMap();
        Element[][] cells = enemyMap.getCells();
        if (isHunting()) {
            if (isDirectionLocked()) {
                direction = getDirection();
                setUpNewCoordinates(getUpdatedY(), getUpdatedX(), direction, cells);
                performUpdatedHit(getUpdatedY(), getUpdatedX(), direction, enemyMap, cells);
            } else {
                setUpNewCoordinates(getUpdatedY(), getUpdatedX(), direction, cells);
                performUpdatedHit(getUpdatedY(), getUpdatedX(), direction, enemyMap, cells);
            }
        } else {
            Random rand = new Random();
            int y = rand.nextInt(10);
            int x = rand.nextInt(10);
            performHit(y, x, direction, enemyMap, cells);
        }
    }

    /**
     * This method performs random hits and or redirects to the performUpdatedHit() if hunting.
     */
    private void performHit(int y, int x, ShootDirection direction, GameMap enemyMap, Element[][] cells) {
        if (cells[y][x].isCellChecked()) {
            fire();
        } else {
            if (direction == null) {
                Character yAsCharacter = (char) (y + 65);
                System.out.println("Computer shoots cell " + yAsCharacter + x);
                if (cells[y][x].getState() == ElementState.SHIP) {
                    madeShot(y, x, direction, enemyMap, cells);
                } else {
                    madeMiss(y, x, direction, cells);
                }
            } else {
                setUpNewCoordinates(getUpdatedY(), getUpdatedX(), direction, cells);
                performUpdatedHit(getUpdatedY(), getUpdatedX(), direction, enemyMap, cells);
            }
        }
    }

    /**
     * This method performs a hit when hunting. It defines the new coordinates and checks the result.
     */
    private void performUpdatedHit(int y, int x, ShootDirection direction, GameMap enemyMap, Element[][] cells) {
        if (cells[y][x].isCellChecked()) {
            setUpNewCoordinates(y, x, direction, cells);
            performUpdatedHit(getUpdatedY(), getUpdatedX(), direction, enemyMap, cells);
        } else {
            Character yAsCharacter = (char) (getUpdatedY() + 65);
            System.out.println("Computer shoots cell " + yAsCharacter + x);
            cells[y][x].setCellChecked(true);
            waitOneSecond();
            if (cells[y][x].getState() == ElementState.SHIP) {
                madeShot(y, x, direction, enemyMap, cells);
            } else {
                madeMiss(y, x, direction, cells);
            }
        }
    }

    /**
     * This method is used to set random direction if none is applied
     * and sets new coordinates to hit if direction is set.
     */
    private void setUpNewCoordinates(int y, int x, ShootDirection direction, Element[][] cells) {
        if (direction == null) {
            direction = getRandomDirection();
        }
        if (directionLock) {
            if (direction == ShootDirection.DOWN) {
                setUpdatedY(y + 1);
            } else if (direction == ShootDirection.UP) {
                setUpdatedY(y - 1);
            } else if (direction == ShootDirection.RIGHT) {
                setUpdatedX(x + 1);
            } else if (direction == ShootDirection.LEFT) {
                setUpdatedX(x - 1);
            }
        } else {
            if (direction == ShootDirection.LEFT) {
                if (x == 0) {
                    listOfDirections.remove(ShootDirection.LEFT);
                    this.direction = null;
                    setUpNewCoordinates(y, x, null, cells);
                } else if (cells[y][x - 1].isCellChecked()) {
                    listOfDirections.remove(ShootDirection.LEFT);
                    this.direction = null;
                    setUpNewCoordinates(y, x, null, cells);
                } else {
                    setDirection(ShootDirection.LEFT);
                    setUpdatedX(x - 1);
                }
            } else if (direction == ShootDirection.RIGHT) {
                if (x == 9) {
                    listOfDirections.remove(ShootDirection.RIGHT);
                    direction = getRandomDirection();
                    setUpNewCoordinates(y, x, direction, cells);
                } else if ((cells[y][x + 1].isCellChecked())) {
                    listOfDirections.remove(ShootDirection.RIGHT);
                    this.direction = null;
                    setUpNewCoordinates(y, x, null, cells);
                } else {
                    setDirection(ShootDirection.RIGHT);
                    setUpdatedX(x + 1);
                }
            } else if (direction == ShootDirection.UP) {
                if (y == 0) {
                    listOfDirections.remove(ShootDirection.UP);
                    this.direction = null;
                    setUpNewCoordinates(y, x, null, cells);
                } else if (cells[y - 1][x].isCellChecked()) {
                    listOfDirections.remove(ShootDirection.UP);
                    this.direction = null;
                    setUpNewCoordinates(y, x, null, cells);
                } else {
                    setDirection(ShootDirection.UP);
                    setUpdatedY(y - 1);
                }
            } else if (direction == ShootDirection.DOWN) {
                if (y == 9) {
                    listOfDirections.remove(ShootDirection.DOWN);
                    this.direction = null;
                    setUpNewCoordinates(y, x, null, cells);
                } else if (cells[y + 1][x].isCellChecked()) {
                    listOfDirections.remove(ShootDirection.DOWN);
                    this.direction = null;
                    setUpNewCoordinates(y, x, null, cells);
                } else {
                    setDirection(ShootDirection.DOWN);
                    setUpdatedY(y + 1);
                }
            }
        }
    }

    /**
     * This method marks the hit and checks if it is time to hunt or hunt is over.
     */
    private void madeShot(int y, int x, ShootDirection direction, GameMap enemyMap, Element[][] cells) {
        Ship ship = GameMap.getShipFromMap(enemyMap, y, x);
        if (ship == null) {
            madeMiss(y, x, direction, cells);
            setDirection(direction.revert());
            setUpdatedY(getFirstHitY());
            setUpdatedX(getFirstHitX());
        } else {
            ship.markHit(y, x);
            cells[y][x].setCellChecked(true);
            cells[y][x].setSymbol('X');
            if (ship.checkIsDead()) {
                this.direction = null;
                setHunting(false);
                setDirectionLock(false);
                listOfDirections = refillDirections();
                System.out.println("Your ship has drowned.");
                markSurroundChecked(ship, cells);
                waitOneSecond();
                if (checkIsItVictory(enemyMap)) {
                    System.out.println();
                    System.out.println("It's over! Computer has won.");
                    markMapChecked(cells);
                    GameMap computerMap = gameProcess.getEnemyMap();
                    markMapChecked(computerMap.getCells());
                    waitOneSecond();
                    setVictory(true);
                    setResult(false);
                } else {
                    setResult(true);
                }
            } else {
                System.out.println("Computer hits the ship!");
                setResult(true);
                waitOneSecond();
                if (!isHunting()) {
                    startHunt(y, x);
                } else {
                    setDirectionLock(true);
                    setDirection(direction);
                }
            }
        }
    }

    private void startHunt(int y, int x) {
        setHunting(true);
        setFirstHitX(x);
        setFirstHitY(y);
        setUpdatedX(x);
        setUpdatedY(y);
    }

    /**
     * This method marks a miss and resets Y and X to initial state.
     */
    private void madeMiss(int y, int x, ShootDirection direction, Element[][] cells) {
        cells[y][x].setCellChecked(true);
        cells[y][x].setSymbol('▪');
        System.out.println("Computer missed");
        if (isHunting()) {
            setUpdatedY(getFirstHitY());
            setUpdatedX(getFirstHitX());
        }
        if (isDirectionLocked()) {
            setDirection(getDirection().revert());
        }
        waitOneSecond();
        setResult(false);
    }

    private void markMapChecked(Element[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].setCellChecked(true);
            }
        }
    }

    private void markSurroundChecked(Ship ship, Element[][] cells) {
        Element[] shipBody = ship.getBody();
        for (Element element : shipBody) {
            ArrayList<Element> surround = element.getSurround();
            for (Element elements : surround) {
                cells[elements.getY()][elements.getX()].setCellChecked(true);
            }
        }
    }

    private ArrayList<ShootDirection> refillDirections() {
        ArrayList<ShootDirection> directions = new ArrayList<>(4);
        directions.add(ShootDirection.DOWN);
        directions.add(ShootDirection.UP);
        directions.add(ShootDirection.LEFT);
        directions.add(ShootDirection.RIGHT);
        return directions;
    }

    private ShootDirection getRandomDirection() {
        return listOfDirections.get((int) (Math.random() * listOfDirections.size() - 1));
    }

    private boolean isHunting() {
        return hunting;
    }

    private void setHunting(boolean hunting) {
        this.hunting = hunting;
    }

    private int getFirstHitY() {
        return firstHitY;
    }

    private int getFirstHitX() {
        return firstHitX;
    }

    private void setFirstHitY(int firstHitY) {
        this.firstHitY = firstHitY;
    }

    private void setFirstHitX(int firstHitX) {
        this.firstHitX = firstHitX;
    }

    private void setDirection(ShootDirection direction) {
        this.direction = direction;
    }

    private ShootDirection getDirection() {
        return direction;
    }

    private int getUpdatedY() {
        return updatedY;
    }

    private void setUpdatedY(int updatedY) {
        this.updatedY = updatedY;
    }

    private int getUpdatedX() {
        return updatedX;
    }

    private void setUpdatedX(int updatedX) {
        this.updatedX = updatedX;
    }

    private boolean isDirectionLocked() {
        return directionLock;
    }

    private void setDirectionLock(boolean directionLock) {
        this.directionLock = directionLock;
    }
}