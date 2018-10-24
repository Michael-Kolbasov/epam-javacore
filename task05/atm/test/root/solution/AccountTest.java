package root.solution;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = Account.getInstance();
        account.deposit(100);
    }

    @Test
    public void testWithdraw_InsufficientFunds() {
        assertFalse(account.withdraw(200));
        assertFalse(account.withdraw(-200));
        assertFalse(account.withdraw(100.01));
        assertFalse(account.withdraw(0));
    }

    @Test
    public void testWithdraw_AllOK() {
        assertTrue(account.withdraw(50));
        assertTrue(account.withdraw(50));
        assertFalse(account.withdraw(50));
    }
}