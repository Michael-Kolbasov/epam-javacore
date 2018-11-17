package game.objects;

/**
 * This enum provides the cells' state.
 * {@code WATER} for initial map filling.
 * {@code BORDER} for surrounding cells on the map upon ship put.
 * {@code SHIP} for the map cells' and ships' objects when upon ship put.
 */
public enum ElementState {
    WATER, BORDER, SHIP
}