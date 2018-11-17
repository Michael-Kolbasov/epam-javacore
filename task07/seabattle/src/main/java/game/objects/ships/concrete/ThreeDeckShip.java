package game.objects.ships.concrete;
import game.objects.Element;
import game.objects.ships.Ship;

public class ThreeDeckShip extends Ship {

    public ThreeDeckShip() {
        length = 3;
        body = new Element[length];
        fillBody();
    }
}