package root.solution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class Task12x271Test {
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

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void testResolveTask() {
        Task12x271 task12x271 = new Task12x271(new Integer[] {0, 1, 2});
        String actual = task12x271.resolveTask(dataArray, task12x271.getIndexes());
        String excepted = "\n\tRow 0: abc\n\tRow 1: fgh\n\tRow 2: klm\n\tRow 3: pqr\n\tRow 4: uvw";
        assertEquals(excepted, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFillIndexes_ForEmptyInput() {
        String actual = "";
        System.setIn(new ByteArrayInputStream(actual.getBytes()));
        assertEquals(actual, new Task12x271().fillIndexes());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFillIndexes_ForWrongInput_beyondLowBorder() {
        Character lowBorder = '0';
        String actual = lowBorder.toString();
        System.setIn(new ByteArrayInputStream(actual.getBytes()));
        assertEquals(actual, new Task12x271().fillIndexes());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFillIndexes_ForWrongInput_beyondHighBorder() {
        Character highBorder = '5';
        String actual = highBorder.toString();
        System.setIn(new ByteArrayInputStream(actual.getBytes()));
        assertEquals(actual, new Task12x271().fillIndexes());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFillIndexes_ForWrongInput_WrongSequence() {
        String actual = "213";
        System.setIn(new ByteArrayInputStream(actual.getBytes()));
        assertEquals(actual, new Task12x271().fillIndexes());
    }
}