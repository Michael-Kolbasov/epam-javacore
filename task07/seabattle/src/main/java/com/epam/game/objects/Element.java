package com.epam.game.objects;
import java.util.ArrayList;

/**
 * This class is the core of all games objects. Everything consists of it:
 * Ships have Element[] body with coordinates Y and X.
 * GameMap is an Element[][] with each cell having the corresponding coordinates.
 *
 * {@code y}    elements' Y coordinate
 * {@code X}    elements' X coordinate
 * {@code state}    elements' state (WATER, BORDER, SHIP)
 * {@code symbol}   elements' symbol representation on the map
 * {@code isCellChecked}    a flag that helps to determinate if player has already checked this cell
 * {@code surrogate}    elements' symbol for showing enemy map while cell hasn't been checked
 */
public class Element {
    private int y;
    private int x;
    private ElementState state;
    private char symbol;
    private boolean isCellChecked;
    private char surrogate = '*';

    public Element() {

    }

    public Element(int y, int x) {
        this.y = y;
        this.x = x;
    }

    /**
     * Each cell has a unique combination of Y and X coordinate.
     * The multiplying (y + 1) block serves the purpose of distinguishing cells like (0, 1) and (1, 0).
     * @return  hashcode of a cell
     */
    @Override
    public int hashCode() {
        return (x + y) * (y + 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Element other = (Element) obj;
        if (getX() != other.getX() || getY() != other.getY()) {
            return false;
        }
        return true;
    }

    /**
     * This method is used when a ship becomes dead to set all surrounded cells to Checked.
     */
    public ArrayList<Element> getSurround() {
        ArrayList<Element> elements = new ArrayList<>();
        if ((getX() != 0 && getX() != 9) && (getY() != 0 && getY() != 9)) {
            elements.add(new Element(getY() + 1, getX() + 1));
            elements.add(new Element(getY() + 1, getX()));
            elements.add(new Element(getY() + 1, getX() - 1));
            elements.add(new Element(getY(), getX() - 1));
            elements.add(new Element(getY() - 1, getX() - 1));
            elements.add(new Element(getY() - 1, getX()));
            elements.add(new Element(getY() - 1, getX() + 1));
            elements.add(new Element(getY(), getX() + 1));
        } else if (y == 0) {
            if (x == 0) {
                elements.add(new Element(getY(), getX() + 1));
                elements.add(new Element(getY() + 1, getX() + 1));
                elements.add(new Element(getY() + 1, getX()));
            } else if (x == 9) {
                elements.add(new Element(getY() + 1, getX()));
                elements.add(new Element(getY() + 1, getX() - 1));
                elements.add(new Element(getY(), getX() - 1));
            } else {
                elements.add(new Element(getY(), getX() - 1));
                elements.add(new Element(getY() + 1, getX() - 1));
                elements.add(new Element(getY() + 1, getX()));
                elements.add(new Element(getY() + 1, getX() + 1));
                elements.add(new Element(getY(), getX() + 1));
            }
        } else if (y == 9) {
            if (x == 0) {
                elements.add(new Element(getY() - 1, getX()));
                elements.add(new Element(getY() - 1, getX() + 1));
                elements.add(new Element(getY(), getX() + 1));
            } else if (x == 9) {
                elements.add(new Element(getY() - 1, getX()));
                elements.add(new Element(getY() - 1, getX() - 1));
                elements.add(new Element(getY(), getX() - 1));
            } else {
                elements.add(new Element(getY(), getX() - 1));
                elements.add(new Element(getY() - 1, getX() - 1));
                elements.add(new Element(getY() - 1, getX()));
                elements.add(new Element(getY() - 1, getX() + 1));
                elements.add(new Element(getY(), getX() + 1));
            }
        } else if (y > 0 && y < 9) {
            if (x == 0) {
                elements.add(new Element(getY() - 1, getX()));
                elements.add(new Element(getY() - 1, getX() + 1));
                elements.add(new Element(getY(), getX() + 1));
                elements.add(new Element(getY() + 1, getX() + 1));
                elements.add(new Element(getY() + 1, getX()));
            } else if (x == 9) {
                elements.add(new Element(getY() - 1, getX()));
                elements.add(new Element(getY() - 1, getX() - 1));
                elements.add(new Element(getY(), getX() - 1));
                elements.add(new Element(getY() + 1, getX() - 1));
                elements.add(new Element(getY() + 1, getX()));
            }
        }
        return elements;
    }

    public boolean isCellChecked() {
        return isCellChecked;
    }

    public void setCellChecked(boolean cellChecked) {
        isCellChecked = cellChecked;
    }

    public char getSurrogate() {
        return surrogate;
    }

    public boolean checkEmptiness() {
        return state != ElementState.SHIP;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ElementState getState() {
        return state;
    }

    public void setState(ElementState state) {
        this.state = state;
    }
}