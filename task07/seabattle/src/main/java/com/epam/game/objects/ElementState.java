package com.epam.game.objects;

/**
 * This enum provides the cells' state.
 * {@code WATER} for initial map filling.
 * {@code BORDER} for surrounding cells on the map upon ship has been put.
 * {@code SHIP} for the map cells' and ships' objects upon ship has been put.
 */
public enum ElementState {
    WATER, BORDER, SHIP
}