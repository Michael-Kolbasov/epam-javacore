package com.epam.game.objects;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ElementTest {
    private Element elementInUpLeftCorner;
    private Element elementInUpRightCorner;
    private Element elementInDownRightCorner;
    private Element elementInDownLeftCorner;
    private Element elementInCenter;
    private Element elementAtLeftWall;
    private Element elementAtRightWall;
    private Element elementAtCeil;
    private Element elementAtFloor;

    @Before
    public void setUp() {
        elementInUpLeftCorner = new Element(0, 0);
        elementInUpRightCorner = new Element(0, 9);
        elementInDownRightCorner = new Element(9, 9);
        elementInDownLeftCorner = new Element(9, 0);
        elementInCenter = new Element(5, 5);
        elementAtLeftWall = new Element(3, 0);
        elementAtRightWall = new Element(3, 9);
        elementAtCeil = new Element(0, 3);
        elementAtFloor = new Element(9, 3);
    }

    @Test
    public void testGetSurround_forUpLeftCorner() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementInUpLeftCorner.getY(), elementInUpLeftCorner.getX() + 1));
        elements.add(new Element(elementInUpLeftCorner.getY() + 1, elementInUpLeftCorner.getX() + 1));
        elements.add(new Element(elementInUpLeftCorner.getY() + 1, elementInUpLeftCorner.getX()));
        assertArrayEquals(elements.toArray(), elementInUpLeftCorner.getSurround().toArray());
    }

    @Test
    public void testGetSurround_forUpRightCorner() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementInUpRightCorner.getY() + 1, elementInUpRightCorner.getX()));
        elements.add(new Element(elementInUpRightCorner.getY() + 1, elementInUpRightCorner.getX() - 1));
        elements.add(new Element(elementInUpRightCorner.getY(), elementInUpRightCorner.getX() - 1));
        assertArrayEquals(elements.toArray(), elementInUpRightCorner.getSurround().toArray());
    }

    @Test
    public void testGetSurround_forCeiling() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementAtCeil.getY(), elementAtCeil.getX() - 1));
        elements.add(new Element(elementAtCeil.getY() + 1, elementAtCeil.getX() - 1));
        elements.add(new Element(elementAtCeil.getY() + 1, elementAtCeil.getX()));
        elements.add(new Element(elementAtCeil.getY() + 1, elementAtCeil.getX() + 1));
        elements.add(new Element(elementAtCeil.getY(), elementAtCeil.getX() + 1));
        assertArrayEquals(elements.toArray(), elementAtCeil.getSurround().toArray());
    }

    @Test
    public void testGetSurround_forDownRightCorner() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementInDownRightCorner.getY() - 1, elementInDownRightCorner.getX()));
        elements.add(new Element(elementInDownRightCorner.getY() - 1, elementInDownRightCorner.getX() - 1));
        elements.add(new Element(elementInDownRightCorner.getY(), elementInDownRightCorner.getX() - 1));
        assertArrayEquals(elements.toArray(), elementInDownRightCorner.getSurround().toArray());
    }

    @Test
    public void testGetSurround_forDownLeftCorner() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementInDownLeftCorner.getY() - 1, elementInDownLeftCorner.getX()));
        elements.add(new Element(elementInDownLeftCorner.getY() - 1, elementInDownLeftCorner.getX() + 1));
        elements.add(new Element(elementInDownLeftCorner.getY(), elementInDownLeftCorner.getX() + 1));
        assertArrayEquals(elements.toArray(), elementInDownLeftCorner.getSurround().toArray());
    }

    @Test
    public void testGetSurround_forFloor() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementAtFloor.getY(), elementAtFloor.getX() - 1));
        elements.add(new Element(elementAtFloor.getY() - 1, elementAtFloor.getX() - 1));
        elements.add(new Element(elementAtFloor.getY() - 1, elementAtFloor.getX()));
        elements.add(new Element(elementAtFloor.getY() - 1, elementAtFloor.getX() + 1));
        elements.add(new Element(elementAtFloor.getY(), elementAtFloor.getX() + 1));
        assertArrayEquals(elements.toArray(), elementAtFloor.getSurround().toArray());
    }

    @Test
    public void testGetSurround_forLeftWall() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementAtLeftWall.getY() - 1, elementAtLeftWall.getX()));
        elements.add(new Element(elementAtLeftWall.getY() - 1, elementAtLeftWall.getX() + 1));
        elements.add(new Element(elementAtLeftWall.getY(), elementAtLeftWall.getX() + 1));
        elements.add(new Element(elementAtLeftWall.getY() + 1, elementAtLeftWall.getX() + 1));
        elements.add(new Element(elementAtLeftWall.getY() + 1, elementAtLeftWall.getX()));
        assertArrayEquals(elements.toArray(), elementAtLeftWall.getSurround().toArray());
    }

    @Test
    public void testGetSurround_forRightWall() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementAtRightWall.getY() - 1, elementAtRightWall.getX()));
        elements.add(new Element(elementAtRightWall.getY() - 1, elementAtRightWall.getX() - 1));
        elements.add(new Element(elementAtRightWall.getY(), elementAtRightWall.getX() - 1));
        elements.add(new Element(elementAtRightWall.getY() + 1, elementAtRightWall.getX() - 1));
        elements.add(new Element(elementAtRightWall.getY() + 1, elementAtRightWall.getX()));
        assertArrayEquals(elements.toArray(), elementAtRightWall.getSurround().toArray());
    }

    @Test
    public void testGetSurround_forCenter() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(elementInCenter.getY() + 1, elementInCenter.getX() + 1));
        elements.add(new Element(elementInCenter.getY() + 1, elementInCenter.getX()));
        elements.add(new Element(elementInCenter.getY() + 1, elementInCenter.getX() - 1));
        elements.add(new Element(elementInCenter.getY(), elementInCenter.getX() - 1));
        elements.add(new Element(elementInCenter.getY() - 1, elementInCenter.getX() - 1));
        elements.add(new Element(elementInCenter.getY() - 1, elementInCenter.getX()));
        elements.add(new Element(elementInCenter.getY() - 1, elementInCenter.getX() + 1));
        elements.add(new Element(elementInCenter.getY(), elementInCenter.getX() + 1));
        assertArrayEquals(elements.toArray(), elementInCenter.getSurround().toArray());
    }
}
