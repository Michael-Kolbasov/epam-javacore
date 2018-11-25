package com.epam;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class SumOfDigitsTest {
    private SumOfDigits sumOfDigits;

    @Before
    public void setUp() {
        sumOfDigits = new SumOfDigits(1);
    }

    @Test
    public void testFindPower() {
        assertEquals(5, sumOfDigits.findSumOfDigits(23));
        assertEquals(0, sumOfDigits.findSumOfDigits(0));
        assertEquals(1, sumOfDigits.findSumOfDigits(-1));
        assertEquals(15, sumOfDigits.findSumOfDigits(12345));
        assertEquals(15, sumOfDigits.findSumOfDigits(-12345));
        assertEquals(1, sumOfDigits.findSumOfDigits(10000));
        assertEquals(2, sumOfDigits.findSumOfDigits(200));
        assertEquals(19, sumOfDigits.findSumOfDigits(9091));
    }
}