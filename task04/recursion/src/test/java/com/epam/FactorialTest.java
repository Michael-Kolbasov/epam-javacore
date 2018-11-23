package com.epam;
import com.epam.Factorial;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class FactorialTest {
    private Factorial factorial;

    @Before
    public void setUp() {
        factorial = new Factorial(1);
    }

    @Test
    public void testFindFactorial() {
        assertEquals(1, factorial.findFactorial(0));
        assertEquals(1, factorial.findFactorial(1));
        assertEquals(2, factorial.findFactorial(2));
        assertEquals(6, factorial.findFactorial(3));
        assertEquals(24, factorial.findFactorial(4));
        assertEquals(120, factorial.findFactorial(5));
        assertEquals(720, factorial.findFactorial(6));
        assertEquals(5040, factorial.findFactorial(7));
        assertEquals(40320, factorial.findFactorial(8));
        assertEquals(362880, factorial.findFactorial(9));
        assertEquals(3628800, factorial.findFactorial(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFactorial_ForNegativeInput() {
        factorial.findFactorial(-1);
    }
}