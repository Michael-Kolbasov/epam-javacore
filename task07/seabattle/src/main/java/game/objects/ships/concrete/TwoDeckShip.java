package game.objects.ships.concrete;
import game.objects.Element;
import game.objects.ships.Ship;

public class TwoDeckShip extends Ship {

    public TwoDeckShip() {
        length = 2;
        body = new Element[length];
        fillBody();
    }
}