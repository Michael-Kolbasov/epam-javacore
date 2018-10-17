package root.solution;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class AmountOfDigitsTest {
    private AmountOfDigits amountOfDigits;

    @Before
    public void setUp() {
        amountOfDigits = new AmountOfDigits(1);
    }

    @Test
    public void testFindPower() {
        assertEquals(2, amountOfDigits.findAmountOfDigits(23));
        assertEquals(1, amountOfDigits.findAmountOfDigits(0));
        assertEquals(1, amountOfDigits.findAmountOfDigits(1));
        assertEquals(2, amountOfDigits.findAmountOfDigits(-10));
        assertEquals(6, amountOfDigits.findAmountOfDigits(332211));
        assertEquals(10, amountOfDigits.findAmountOfDigits(1234567890));
        assertEquals(2, amountOfDigits.findAmountOfDigits(2*10));
    }
}