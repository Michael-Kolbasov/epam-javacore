package com.epam.game.objects.ships.concrete;
import com.epam.game.objects.ships.Ship;
import com.epam.game.objects.Element;

public class TwoDeckShip extends Ship {

    public TwoDeckShip() {
        length = 2;
        body = new Element[length];
        fillBody();
    }
}