package com.epam.game.objects.ships.concrete;
import com.epam.game.objects.Element;
import com.epam.game.objects.ships.Ship;

public class OneDeckShip extends Ship {

    public OneDeckShip() {
        length = 1;
        body = new Element[length];
        fillBody();
    }
}