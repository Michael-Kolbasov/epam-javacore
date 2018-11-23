package com.epam;
import com.epam.Task12x270;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Task12x270Test {
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
        String expected = "aeuy";
        String actual = new Task12x270().resolveTask(dataArray);
        assertEquals(expected, actual);
    }
}
