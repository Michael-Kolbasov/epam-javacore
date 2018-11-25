package com.epam;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task12x272Test {
    private Character[][] dataArray = new Character[5][5];

    @Before
    public void setUp() {
        char initialValue = 'a';
        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < dataArray[i].length; j++) {
                dataArray[i][j] = initialValue;
                initialValue++;
            }
        }
    }

    @Test
    public void testResolveTaskA() {
        Task12x272 task12x272 = new Task12x272();
        String expected = "acegikmoqsuwy";
        String actual = task12x272.resolveTaskA(dataArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testResolveTaskB() {
        Task12x272 task12x272 = new Task12x272();
        String expected = "akugqcmwiseoy";
        String actual = task12x272.resolveTaskB(dataArray);
        assertEquals(expected, actual);
    }
}