package com.epam.game.objects.ships;
import com.epam.game.objects.ships.concrete.OneDeckShip;
import com.epam.game.objects.ships.concrete.TwoDeckShip;
import com.epam.game.objects.ships.concrete.FourDeckShip;
import com.epam.game.objects.ships.concrete.ThreeDeckShip;

/**
 * This Factory creates ships depending on {@code size} input.
 * It is used by GameMap to initially create the ArrayList of Ships.
 * One 4-deck ship, two 3-deck ships, three 2-deck ships, four 1-deck ship.
 */
public class ShipFactory {
    public Ship createShip(int size) {
        Ship ship = null;
        switch (size) {
            case 1:
                ship = new OneDeckShip();
                break;
            case 2:
                ship = new TwoDeckShip();
                break;
            case 3:
                ship = new ThreeDeckShip();
                break;
            case 4:
                ship = new FourDeckShip();
                break;
            default:
                System.err.println("No such ship");
                break;
        }
        return ship;
    }
}