package com.epam.game.objects.ships.concrete;
import com.epam.game.objects.ships.Ship;
import com.epam.game.objects.Element;

public class FourDeckShip extends Ship {

    public FourDeckShip() {
        length = 4;
        body = new Element[length];
        fillBody();
    }
}