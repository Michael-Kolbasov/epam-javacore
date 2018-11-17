package game.objects.ships.concrete;
import game.objects.Element;
import game.objects.ships.Ship;

public class FourDeckShip extends Ship {

    public FourDeckShip() {
        length = 4;
        body = new Element[length];
        fillBody();
    }
}