package com.epam;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class PowerTest {
    private Power power;

    @Before
    public void setUp() {
        power = new Power(1);
    }

    @Test
    public void testFindPower() {
        assertEquals(1, power.findPower(0, 0));
        assertEquals(1, power.findPower(1, 0));
        assertEquals(1, power.findPower(2, 0));
        assertEquals(4, power.findPower(2, 2));
        assertEquals(100, power.findPower(10, 2));
        assertEquals(100, power.findPower(-10, 2));
        assertEquals(27, power.findPower(3, 3));
        assertEquals(-27, power.findPower(-3, 3));
        assertEquals(25, power.findPower(-5, 2));
        assertEquals(961, power.findPower(31, 2));
    }
}