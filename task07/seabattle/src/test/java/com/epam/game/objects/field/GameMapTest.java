package com.epam.game.objects.field;
import com.epam.game.objects.Element;
import com.epam.game.objects.ElementState;
import com.epam.game.objects.ships.Ship;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameMapTest {
    private GameMap gameMap;

    @Before
    public void setUp() {
        gameMap = new GameMap();
    }

    @Test
    public void testHowManyShipsLeft() {
        assertEquals(10, GameMap.countHowManyShipsLeft(gameMap));
    }

    @Test
    public void testGetShipFromMap() {
        Element[][] cells = gameMap.getCells();
        int y = 0;
        int x = 0;
        if (cells[y][x].getState() == ElementState.SHIP) {
            Ship ship = GameMap.getShipFromMap(gameMap, y, x);
            assertNotNull(ship);
            assertSame(ship, GameMap.getShipFromMap(gameMap, y, x));
        } else {
            Ship ship = GameMap.getShipFromMap(gameMap, y, x);
            assertNull(ship);
        }
    }
}
