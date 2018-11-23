package com.epam;

import com.epam.Task12x274;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task12x274Test {
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
    public void testResolveTask() {
        Task12x274 task12x274 = new Task12x274();
        String expected = "fpgqhrisjt";
        String actual = task12x274.resolveTask(dataArray);
        assertEquals(expected, actual);
    }
}