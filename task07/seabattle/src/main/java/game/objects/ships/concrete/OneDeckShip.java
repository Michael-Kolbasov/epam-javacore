package game.objects.ships.concrete;
import game.objects.Element;
import game.objects.ships.Ship;

public class OneDeckShip extends Ship {

    public OneDeckShip() {
        length = 1;
        body = new Element[length];
        fillBody();
    }
}