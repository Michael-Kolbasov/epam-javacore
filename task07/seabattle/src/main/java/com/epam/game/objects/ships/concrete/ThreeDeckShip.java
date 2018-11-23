package com.epam.game.objects.ships.concrete;
import com.epam.game.objects.Element;
import com.epam.game.objects.ships.Ship;

public class ThreeDeckShip extends Ship {

    public ThreeDeckShip() {
        length = 3;
        body = new Element[length];
        fillBody();
    }
}