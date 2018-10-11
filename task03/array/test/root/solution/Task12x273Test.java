package root.solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task12x273Test {
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
        Task12x273 task12x273 = new Task12x273();
        String expected = "acefhjkmoprtuwy";
        String actual = task12x273.resolveTask(dataArray);
        assertEquals(expected, actual);
    }
}